package com.nagp.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.nagp.utility.CommonUtilty;

/**
 * 
 * @author sanjeetpandit
 *
 */
public class HomePage {
	/**
	 * Xpaths
	 */
	String hoverXpath = "//a[@class='sf-with-ul']";
	String tShirtXpth = "//a[contains(text(),'T-shirts')]";
	String productsXpath = "//ul[contains(@class,'product_list grid row')]";

	String firstProductXpath = "//div[@class='right-block']//h5//a[@class='product-name']";
	String searchBoxXpath = "//input[@class='search_query form-control ac_input']";
	String searchButtonXpath = "//button[@class='btn btn-default button-search']";
	String productBoxXpath = "//ul[contains(@class,'product_list grid row')]";

	CommonUtilty common = new CommonUtilty();

	/**
	 * 
	 * @param driver
	 * @return title of the page
	 * @throws InterruptedException
	 */
	public String verifyHomePageTitle(WebDriver driver) throws InterruptedException {
		String title = driver.getTitle();
		System.out.println(title);
		Thread.sleep(5000);
		return title;
	}

	/**
	 * 
	 * @param driver
	 * @throws InterruptedException
	 */

	public void clickOnNewTShirt(WebDriver driver) throws InterruptedException {
		WebElement ele = driver.findElement(By.xpath(hoverXpath));
		Thread.sleep(5000);
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();
		Thread.sleep(5000);
		WebElement ele1 = driver.findElement(By.xpath(tShirtXpth));
		action.moveToElement(ele1).perform();
		ele1.click();
		Thread.sleep(5000);
	}

	/**
	 * 
	 * @param driver
	 * @param count
	 * @throws InterruptedException
	 */
	public void noOfProduct(WebDriver driver, int count) throws InterruptedException {
		clickOnNewTShirt(driver);
		common.scrollDown(driver, productBoxXpath);
		List<WebElement> products = driver.findElements(By.xpath(productsXpath));
		System.out.println(products.size());
		// verifying no of products and actual product
		Assert.assertEquals(products.size(), count);
		for (int i = 0; i < products.size(); i++) {
			String dressname = products.get(i).getText();
			System.out.println(dressname);
		}
		// getting 1st product from list
		String dressname = products.get(0).getText();
		System.out.println(dressname);
		Thread.sleep(5000);

	}

	/**
	 * 
	 * @param driver
	 * @param name
	 * @throws InterruptedException
	 */

	public void productSearch(WebDriver driver, String name) throws InterruptedException {
		clickOnNewTShirt(driver);
		common.scrollDown(driver, productBoxXpath);
		String dressname = driver.findElement(By.xpath(firstProductXpath)).getText();
		Thread.sleep(5000);
		WebElement searchBox = driver.findElement(By.xpath(searchBoxXpath));
		searchBox.sendKeys(dressname);
		WebElement searchButton = driver.findElement(By.xpath(searchButtonXpath));
		searchButton.click();
		Thread.sleep(5000);
		common.scrollDown(driver, productBoxXpath);
		Assert.assertEquals(dressname, name);
	}

}
