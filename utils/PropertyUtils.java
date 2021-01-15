package api.com.lorimobile.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import api.com.lorimobile.constants.MiscConstants;
import api.com.lorimobile.tests.TestContext;




public class PropertyUtils {

	private static final Logger logger = LogManager.getLogger(PropertyUtils.class);

	static {
		loadTestDataProperties();
		loadConfigurationProperties();
	}

	public static String getProperty(String propertyName, String defaultValue) {

		String value = getProperty(propertyName);
		if (value == null) {
			logger.info("returning default value [" + defaultValue + "] for system property: " + propertyName);
			return defaultValue;
		}
		return value;
	}

	public static String getProperty(String propertyName) {

		String property = System.getProperty(propertyName);
		if (property == null) {
			logger.info("did not find the requested system property: " + propertyName);
		}
		return property;
	}

	private static void loadConfigurationProperties() {

		String directoryPath = "src/test/resources/";
		String env = TestContext.getTestEnvironment();
		if (env.equals(MiscConstants.QA)) {
			directoryPath += "qa/";
		}
		if (env.equals(MiscConstants.UAT)) {
			directoryPath += "uat/";
		}
		directoryPath += "configuration/";
		File propertiesDirectory = new File(directoryPath);
		if (!propertiesDirectory.isDirectory()) {
			throw new IllegalStateException(directoryPath + " should be a directory");
		}

		List<File> propertyFiles = FileUtils.getFiles(propertiesDirectory);
		Properties properties = new Properties();
		InputStream input = null;
		for (File file : propertyFiles) {
			try {
				if (!file.getName().endsWith(".properties")) {
					// assuming all property files are of file type *.property,
					// and are all directly contained within this directory;
					// enhance if necessary
					throw new IllegalStateException(
							"found file in properties directory that is of not file-type *.properties: "
									+ file.getName());
				}
				input = new FileInputStream(file.getAbsolutePath());
				properties.load(input);
			} catch (IOException e) {
				throw new IllegalStateException("could not load property file: " + file.getName());
			}
		}

		Set<Object> setProperties = new HashSet<>(System.getProperties().keySet());
		for (String name : properties.stringPropertyNames()) {
			if (setProperties.contains(name)) {
				throw new IllegalStateException(String.format("error when attempting to set the following property:"
						+ "\n\t%1$s:%2$s\nthe following property already found:\n\t%1$s:%3$s\nplease take care to remove duplicate properties",
						name, properties.getProperty(name), System.getProperty(name)));
			}
			setProperties.add(name);
			System.setProperty(name, properties.getProperty(name));
		}
	}

	@SuppressWarnings("resource")
	private static void loadTestDataProperties() {

		String directoryPath = "src/test/resources/";
		String env = TestContext.getTestEnvironment();
		if (env.equals(MiscConstants.QA)) {
			directoryPath += "qa/";
		}
		if (env.equals(MiscConstants.UAT)) {
			directoryPath += "uat/";
		}
		directoryPath += "testdata/";
		File testDataDirectory = new File(directoryPath);
		if (!testDataDirectory.isDirectory()) {
			throw new IllegalStateException(directoryPath + " should be a directory");
		}
		List<File> dataFiles = FileUtils.getFiles(testDataDirectory);
		InputStream inputStream = null;
		String jsonContent;
		for (File file : dataFiles) {
			try {
				if (!file.getName().endsWith(".json")) {
					// assuming all test data files are of file type *.json,
					// enhance if necessary
					throw new IllegalStateException(
							"found file in testdata directory that is of not file-type *.json: " + file.getName());
				}

				inputStream = new FileInputStream(file.getAbsolutePath());
				jsonContent = FileUtils.getFileContent(inputStream);
				JsonParser jp = new JsonParser();
				try {
					JsonElement jsonTree = jp.parse(jsonContent);
					String fileName = file.getName().substring(0, file.getName().indexOf(".json"));
					loadPropertiesFromJsonRecursively(fileName, jsonTree);
				} catch (JsonSyntaxException e) {
					throw new RuntimeException(e);
				}
			} catch (IOException e) {
				throw new RuntimeException("could not load property file: " + file.getName());
			}
		}
	}

	private static void loadPropertiesFromJsonRecursively(String key, JsonElement jsonElement) {

		if (jsonElement.isJsonPrimitive()) {
			System.setProperty(key, jsonElement.getAsString());
			return;
		}
		if (jsonElement.isJsonObject()) {
			Set<Map.Entry<String, JsonElement>> elements = ((JsonObject) jsonElement).entrySet();
			for (Map.Entry<String, JsonElement> element : elements) {
				String childNodeKey = key + "." + element.getKey();
				loadPropertiesFromJsonRecursively(childNodeKey, ((JsonObject) jsonElement).get(element.getKey()));
			}
		}
	}

}
