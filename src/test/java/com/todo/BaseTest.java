package com.todo;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.todo.utils.Constants;

/*
 * BaseTest Class - All basic operation for any test
 * */
public class BaseTest {

	public static WebDriver driver;
	public static Actions actions;

	@BeforeTest
	public void beforeTestMethod() {
	}

	@BeforeMethod
	@Parameters(value = { "browserName" })
	public void beforeMethod(String browserName) {
		setupDriver(browserName);
		driver.manage().window().maximize();
		actions = new Actions(driver);
		driver.get(Constants.URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@AfterTest
	public void afterTestMethod() {
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

	public void setupDriver(String browserName) {
		if (browserName.equalsIgnoreCase(Constants.CHROME)) {
			System.setProperty(Constants.CHROME_DRIVER, Constants.CHROME_DRIVER_PATH);
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase(Constants.FIREFOX)) {
			System.setProperty(Constants.FIREFOX_DRIVER, Constants.FIREFOX_DRIVER_PATH);
			driver = new FirefoxDriver();
		} else {
			System.setProperty(Constants.CHROME_DRIVER, Constants.CHROME_DRIVER_PATH);
			driver = new ChromeDriver();
		}
	}

}
