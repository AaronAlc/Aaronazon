package com.aaronazon.test.frontend;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ItemManagementFrontEndTest {

	private WebDriver driver;

	private WebDriverWait wait;
	private final String ITEM_URL = "http://localhost:8081/AaronazonMVCFE/items/";

	private final String TEST_ITEM_NAME = "NewItem";
	private final String TEST_ITEM_DESCRIPTION = "Item Description Goes here";
	private final String TEST_ITEM_NAME_CHANGED = "NewItemChanged";

	@BeforeClass
	public void beforeClass() {
		// System.out.println("My browser is " + browser);
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 10);
	}

	@Test(priority = 1)
	public void openItemWebPage() {
		driver.get(ITEM_URL);
		Assert.assertEquals("Item Management Control", driver.getTitle());
	}

	@Test(priority = 2)
	public void testItemCreate() {
		driver.findElement(By.cssSelector("#itemName")).sendKeys(TEST_ITEM_NAME);
		driver.findElement(By.cssSelector("#itemDesc")).sendKeys(TEST_ITEM_DESCRIPTION);
		driver.findElement(By.cssSelector("#submit_btn")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#table_" + TEST_ITEM_NAME)));
		Assert.assertEquals(TEST_ITEM_NAME, driver.findElement(By.cssSelector("#table_" + TEST_ITEM_NAME)).getText());
	}

	@Test(priority = 3)
	public void testItemErrorMessage() {
		driver.findElement(By.cssSelector("#itemName")).sendKeys(TEST_ITEM_NAME);
		driver.findElement(By.cssSelector("#itemDesc")).sendKeys("Item Description Goes Here");
		driver.findElement(By.cssSelector("#submit_btn")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#error_message")));
		Assert.assertEquals("Item already exists", driver.findElement(By.cssSelector("#error_message")).getText());
	}

	@Test(priority = 4)
	public void testItemUpdate() {
		driver.findElement(By.cssSelector("#" + TEST_ITEM_NAME + "_edit_btn")).click();
		driver.findElement(By.cssSelector("#itemName")).clear();
		driver.findElement(By.cssSelector("#itemName")).sendKeys(TEST_ITEM_NAME_CHANGED);
		driver.findElement(By.cssSelector("#submit_btn")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#table_" + TEST_ITEM_NAME_CHANGED)));
		Assert.assertEquals(TEST_ITEM_NAME_CHANGED, driver.findElement(By.cssSelector("#table_" + TEST_ITEM_NAME_CHANGED)).getText());
	}
	
	@Test(priority = 5)
	public void testItemDelete() {
		driver.findElement(By.cssSelector("#" + TEST_ITEM_NAME_CHANGED + "_remove_btn")).click();
		wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(By.cssSelector("#table_" + TEST_ITEM_NAME_CHANGED), TEST_ITEM_NAME_CHANGED)));
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}