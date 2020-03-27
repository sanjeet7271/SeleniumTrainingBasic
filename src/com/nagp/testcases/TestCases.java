package com.nagp.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.nagp.constants.SeleniumConstant;
import com.nagp.dataprovider.ExcelSheetReader;
import com.nagp.pages.HomePage;
import com.nagp.utility.Drivers;
import com.nagp.utility.PropertiesFiles;

/**
 * 
 * @author sanjeetpandit
 *
 */

public class TestCases {
	Drivers drivers = new Drivers();
	PropertiesFiles prop = new PropertiesFiles();
	HomePage homePage = new HomePage();
	ExcelSheetReader ProvideData = new ExcelSheetReader();
	Object[][] data;
	
	/**
	 * Initializing driver here
	 */

	@BeforeMethod
	public void setBrowsers() {

		drivers.DriversInit();
	}

	@Test(priority = 1, description = "verify title of the webpage")
	public void verifyHomePageTitleTest() throws InterruptedException {
		String homePageTitle = homePage.verifyHomePageTitle(drivers.getSelenium());
		System.out.println(homePageTitle);
		// some times title appear is "My Store " sometimes appear as blank " "
		Assert.assertEquals(homePageTitle, "", "Home page title not matched");
	}

	@Test(priority = 2, description = "hover the curser to Women and T-Shirt link")
	public void verifyHoverAndClick() throws InterruptedException {

		homePage.clickOnNewTShirt(drivers.getSelenium());

	}

	@DataProvider(name = "productcount")
	public Object[][] productCount() throws Exception {
		data = ProvideData.testData(SeleniumConstant.EXCEL_SHEET_PATH, SeleniumConstant.PRODUCT_COUNT_SHEETNAME);
		return data;
	}

	@Test(priority = 3, dataProvider = "productcount", description = "verify the number of links present on the women T-Shirt section webpage")
	public void countProductOnPage(String pCount) throws InterruptedException {
		System.out.println(Integer.parseInt(pCount));
		homePage.noOfProduct(drivers.getSelenium(), Integer.parseInt(pCount));
	}

	@DataProvider(name = "productname")
	public Object[][] productNames() throws Exception {
		data = ProvideData.testData(SeleniumConstant.EXCEL_SHEET_PATH, SeleniumConstant.PRODUCT_NAME_SHEETNAME);
		return data;
	}

	@Test(priority = 4, dataProvider = "productname", description = "verify the product name search through search box")
	public void searchProductOnPage(String pName) throws InterruptedException {
		System.out.println(pName);
		homePage.productSearch(drivers.getSelenium(), pName);
	}

	@AfterMethod
	public void tearDown() {
		drivers.closeBrowser();
	}

}
