package com.Project4.Pages;

import Utils.BrowserUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

import static Utils.DriverHelper.driver;

public class MainPage {
    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "anySearchBox")
    WebElement searchBox;

    @FindBy(xpath = "//tr[@id='pid_1']//td")
    List<WebElement> patientInfo;

    @FindBy(xpath = "(//tr[@id='pid_1']//td)[5]")
    WebElement externalIdMainPage;

    @FindBy(xpath = "//a[contains(text(),'Demographics')]")
    WebElement demographicsButton;

    @FindBy(xpath = "//td[@id='text_pubpid']")
    WebElement externalIdDemographicsPage;

    @FindBy(id = "logoutinnerframe")
    WebElement iframe;


    public void searchPatient(String patient) {
        this.searchBox.sendKeys(patient, Keys.ENTER);
    }

    public void validatePatientInfo(String fullName, String homePhone, String ssn, String dateOfBirth) throws InterruptedException {

        driver.switchTo().frame("fin");
        for (int i = 0; i < patientInfo.size() - 2; i++) {
            String text = BrowserUtils.getText(patientInfo.get(i));
            Assert.assertTrue(text.contains(fullName) || text.contains(homePhone) || text.contains(ssn) || text.contains(dateOfBirth));
        }

        String expectedText = externalIdMainPage.getText().trim();
        System.out.println("expectedText " + expectedText);
        Thread.sleep(5000);
        externalIdMainPage.click();
        driver.switchTo().defaultContent();
        driver.switchTo().frame("pat");
        demographicsButton.click();
        String actualText = externalIdDemographicsPage.getAttribute("data-value").trim();
        System.out.println("actualText " + actualText);
        Assert.assertEquals(actualText, expectedText);

        System.out.println("fasula");


    }
}
