package api.com.lorimobile.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.JUnitSoftAssertions;
import org.junit.Rule;

import api.com.lorimobile.constants.MiscConstants;

//To be implemented with Serenity
public abstract class TestContext {

	@Rule
	public final JUnitSoftAssertions softAssertions = new JUnitSoftAssertions();
	public final Logger logger = LogManager.getLogger(this.getClass());
	private static ThreadLocal<TestContext> testContext = new ThreadLocal<TestContext>();

	public static String TEST_ENV;

	static {
		setTestEnvironment();
	}

	public TestContext() {
		testContext.set(this);
	}

	public static TestContext getContext() {
		return testContext.get();
	}

	private static void setTestEnvironment() {
		String arg = System.getProperty("test.environment");
		if (arg == null) {
			LogManager.getLogger(TestContext.class)
					.warn("test.environment not explicitly set via -D flag. setting to QA by default");
			TEST_ENV = MiscConstants.QA;
			return;
		}
		if (arg.equalsIgnoreCase(MiscConstants.QA)) {
			TEST_ENV = MiscConstants.QA;
			return;
		}
		if (arg.equalsIgnoreCase(MiscConstants.UAT)) {
			TEST_ENV = MiscConstants.UAT;
			return;
		}
		if (arg.equalsIgnoreCase(MiscConstants.PROD)) {
			TEST_ENV = MiscConstants.PROD;
			return;
		}
		throw new IllegalStateException("test environment cannot be set. no such environment recognized: " + arg);
	}

	public static String getTestEnvironment() {
		return TEST_ENV;
	}

}
