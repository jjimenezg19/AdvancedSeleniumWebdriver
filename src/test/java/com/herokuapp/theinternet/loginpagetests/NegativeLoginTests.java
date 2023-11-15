package com.herokuapp.theinternet.loginpagetests;

import com.herokuapp.theinternet.base.BaseTest;
import com.herokuapp.theinternet.base.TestUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;


public class NegativeLoginTests extends TestUtilities {

    @Parameters({"username", "password", "expectedMessage"})
    @Test(priority = 2, groups = {"negativeTests", "smokeTests"})
    public void incorrectUsernameTest(String username, String password, String expectedErrorMessage) {
        log.info("Starting incorrectPasswordTest Tests with " + username + " " + password);

        String url = "http://the-internet.herokuapp.com/login";
        driver.get(url);
        log.info("Page opened");

        //enter username
        WebElement usernameElement = driver.findElement(By.id("username"));
        usernameElement.sendKeys(username);

        //enter password
        WebElement passwordElement = driver.findElement(By.id("password"));
        passwordElement.sendKeys(password);

        //click login button
        WebElement loginButton = driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
        loginButton.click();

        //verifications:

        //Unsuccessful login message
        WebElement errorMessage = driver.findElement(By.id("flash"));
        String actualErrorMessage = errorMessage.getText();

        Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage),
                "Actual error message does not contain expected. \nActual Message: "
                        + actualErrorMessage + "\nExpected Message: "
                        + expectedErrorMessage);

    }

    @Parameters({"username", "password", "expectedMessage"})
    @Test(priority = 2, groups = {"negativeTests", "smokeTests"})
    public void incorrectPasswordTest(String username, String password, String expectedErrorMessage) {
        log.info("Starting incorrectPasswordTest Tests with " + username + " " + password);

        String url = "http://the-internet.herokuapp.com/login";
        driver.get(url);
        log.info("Page opened");

        //enter username
        WebElement usernameElement = driver.findElement(By.id("username"));
        usernameElement.sendKeys(username);

        //enter password
        WebElement passwordElement = driver.findElement(By.id("password"));
        passwordElement.sendKeys(password);

        //click login button
        WebElement loginButton = driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
        loginButton.click();

        //verifications:

        //Unsuccessful login message
        WebElement errorMessage = driver.findElement(By.id("flash"));
        String actualErrorMessage = errorMessage.getText();

        Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage),
                "Actual error message does not contain expected. \nActual Message: "
                        + actualErrorMessage + "\nExpected Message: "
                        + expectedErrorMessage);

    }
}
