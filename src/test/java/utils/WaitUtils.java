package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
	
	public static void waitForElementToAppear(WebDriver driver, WebElement webElement) {
	
	WebDriverWait wait=new WebDriverWait(driver,70);

	wait.until(ExpectedConditions.visibilityOf(webElement));

	}

	public static void waitForElementToBeClickable(WebDriver driver, WebDriver webElement){

		WebDriverWait wait = new WebDriverWait(driver, 6000);
		wait.until(ExpectedConditions.elementToBeClickable((By) webElement));
	}
}
