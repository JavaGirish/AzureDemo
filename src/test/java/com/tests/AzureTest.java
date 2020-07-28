package com.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;



public class AzureTest {
	
	public static WebDriver driver;

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.tripadvisor.in/");

		driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	}
	
	
	@Test(priority = 1, description = "verifying tripadvisor logo is displayed")
	@Severity(SeverityLevel.MINOR)
	@Description("Test Case Description: Verify that the logo is displayed")
	@Story("Story Name: Logo Test")
	//@Step("Step 2")
	public void test2() {

		Assert.assertTrue(driver.findElement(By.cssSelector("img[alt='Tripadvisor']")).isDisplayed());

	}

	@Test(priority = 2, description = "verifying Sign Up link is displayed")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Case Description: Verify that the signup link is displayed and enabled")
	@Story("Story Name: SignUp Link Test")
	//@Step("Step 3")
	public void test3() {
		Assert.assertTrue(driver.findElement(By.cssSelector(".HLvj7Lh5._9RPF_Kg6")).isDisplayed());
		//Assert.assertTrue(driver.findElement(By.cssSelector(".HLvj7Lh5._9RPF_Kg6")).isEnabled());

	}

	@Test(priority = 3, description = "verifying Trips Menu is displayed")
	@Severity(SeverityLevel.TRIVIAL)
	@Description("Test Case Description: Verify that the Trips option is seen in Menu")
	@Story("Story Name: Menu Test")
	//@Step("Step 4")
	public void test4() {
		WebDriverWait wait =new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Trips']")));
		
		driver.findElement(By.xpath("//span[text()='Trips']")).click();

	}

	@AfterMethod
	public void tearDown() {

		driver.quit();

	}

}

