package com.Project4.Tests;

import com.Project4.Pages.LoginPage;
import com.Project4.Pages.MainPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MainPageTest extends TestBase {
    @Parameters({"userName", "password", "patient", "fullName", "homePhone", "ssn", "dateOfBirth"})
    @Test
    public void patientFinder(String userName, String password, String patient, String fullName, String homePhone, String ssn, String dateOfBirth) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = new MainPage(driver);

        loginPage.login(userName, password);
        mainPage.searchPatient(patient);
        mainPage.validatePatientInfo(fullName, homePhone, ssn, dateOfBirth);
    }
}
