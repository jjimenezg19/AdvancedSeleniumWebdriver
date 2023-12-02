package com.herokuapp.theinternet.loginpagetests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.LoginPageObject;
import com.herokuapp.theinternet.pages.SecureAreaPageObject;
import com.herokuapp.theinternet.pages.WelcomePageObject;
import org.testng.Assert;
import org.testng.annotations.*;


public class PositiveLoginTests extends TestUtilities {

    @Parameters({"username", "password", "expectedMessage"})
    @Test(priority = 1, groups = {"positiveTests", "smokeTests"})
    public void positiveLoginTest(String username, String password, String expectedSuccessMessage) {
        log.info("Starting positiveLoginTest Tests with " + username + " " + password);

        //Open main page
        WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
        welcomePage.openPage();

        //Click on FormAuthentication link
        LoginPageObject loginPageObject = welcomePage.clickFormAuthenticationlink();

        //Execute login
        SecureAreaPageObject secureAreaPageObject = loginPageObject.logIn(username, password);

        //Verifications:
        //New url
        Assert.assertEquals(secureAreaPageObject.getCurrentUrl(), secureAreaPageObject.getPageUrl());

        //logout button is visible
        Assert.assertTrue(secureAreaPageObject.isLogOutButtonVisible(), "LogOut button is not visible");

        //successful login message

        String actualMessage = secureAreaPageObject.getSuccessMessageTest();

        Assert.assertTrue(actualMessage.contains(expectedSuccessMessage), "actualSuccessMessage does not contain expectedSuccessMessage\nexpectedSuccessMessage: "
                + expectedSuccessMessage + "\nactualSuccessMessage: " + actualMessage);

    }

}
