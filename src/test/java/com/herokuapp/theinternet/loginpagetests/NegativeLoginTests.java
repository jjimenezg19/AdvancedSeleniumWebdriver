package com.herokuapp.theinternet.loginpagetests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.LoginPageObject;
import com.herokuapp.theinternet.pages.UnsuccesfulLoginPageObject;
import com.herokuapp.theinternet.pages.WelcomePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;


public class NegativeLoginTests extends TestUtilities {

    @Parameters({"username", "password", "expectedMessage"})
    @Test(priority = 2, groups = {"negativeTests", "smokeTests"})
    public void incorrectUsernameTest(String username, String password, String expectedErrorMessage) {
        log.info("Starting incorrectUsernameTest Tests with " + username + " " + password);

        //Open main page
        WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
        welcomePage.openPage();

        //Click on FormAuthentication link
        LoginPageObject loginPageObject = welcomePage.clickFormAuthenticationlink();

        //Execute login
        UnsuccesfulLoginPageObject unsuccesfulLoginPageObject = loginPageObject.logInU(username, password);

        //verifications:

        //Unsuccessful login message
        String actualErrorMessage = unsuccesfulLoginPageObject.getUnsuccesfulMessageTest();

        Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage),
                "Actual error message does not contain expected. \nActual Message: "
                        + actualErrorMessage + "\nExpected Message: "
                        + expectedErrorMessage);

    }

    @Parameters({"username", "password", "expectedMessage"})
    @Test(priority = 2, groups = {"negativeTests", "smokeTests"})
    public void incorrectPasswordTest(String username, String password, String expectedErrorMessage) {
        log.info("Starting incorrectPasswordTest Tests with " + username + " " + password);

        //Open main page
        WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
        welcomePage.openPage();

        //Click on FormAuthentication link
        LoginPageObject loginPageObject = welcomePage.clickFormAuthenticationlink();

        //Execute login
        UnsuccesfulLoginPageObject unsuccesfulLoginPageObject = loginPageObject.logInU(username, password);

        //verifications:

        //Unsuccessful login message
        String actualErrorMessage = unsuccesfulLoginPageObject.getUnsuccesfulMessageTest();

        Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage),
                "Actual error message does not contain expected. \nActual Message: "
                        + actualErrorMessage + "\nExpected Message: "
                        + expectedErrorMessage);

    }
}
