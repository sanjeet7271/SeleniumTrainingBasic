package com.nagp.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * 
 * @author sanjeetpandit
 *
 */
public class CommonUtilty {

	public void scrollDown(WebDriver driver, String scroll) {
		WebElement element = driver.findElement(By.xpath(scroll));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

}
