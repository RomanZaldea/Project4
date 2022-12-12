package com.Project4.Tests;

import Utils.BrowserUtils;
import Utils.ConfigReader;
import Utils.DriverHelper;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    public WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = DriverHelper.getDriver();
        driver.get(ConfigReader.readProperty("openemrurl"));
    }

    @AfterMethod
    public void tearDown(ITestResult iTestResult) {
        if (!iTestResult.isSuccess()) {
            BrowserUtils.getScreenshot(driver, "Project4");
        }
        //driver.quit();
    }
}
