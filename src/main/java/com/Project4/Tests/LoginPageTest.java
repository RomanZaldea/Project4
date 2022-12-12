package com.Project4.Tests;

import com.Project4.Pages.LoginPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {
    @Parameters({"userName", "password"})
    @Test
    public void loginTest(String userName, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(userName, password);
    }

}
