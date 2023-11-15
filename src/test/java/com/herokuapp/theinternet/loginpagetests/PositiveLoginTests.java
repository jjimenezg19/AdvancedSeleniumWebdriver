package com.herokuapp.theinternet.loginpagetests;

import com.herokuapp.theinternet.base.TestUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

public class PositiveLoginTests extends TestUtilities {

    @Parameters({"username", "password", "expectedMessage"})
    @Test(priority = 1, groups = {"positiveTests", "smokeTests"})
    public void positiveLoginTest(String username, String password, String expectedSuccessMessage) {
        log.info("Starting positiveLoginTest Tests with " + username + " " + password);

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
        WebElement loginButton = driver.findElement(By.tagName("button"));
        loginButton.click();

        //verifications:
        //New url
        String expectedUrl = "http://the-internet.herokuapp.com/secure";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(actualUrl, expectedUrl, "Actual page url is not the same as expected");

        //logout button is visible
        WebElement logOutButton = driver.findElement(By.xpath("//a[@class='button secondary radius']"));
        Assert.assertTrue(logOutButton.isDisplayed(), "LogOut button is not visible");

        //successful login message
        WebElement successMessage = driver.findElement(By.id("flash"));
        String actualMessage = successMessage.getText();

        Assert.assertTrue(actualMessage.contains(expectedSuccessMessage), "Actual message does not contain expected.\nActual Message: " + actualMessage + "\nExpected Message: " + expectedSuccessMessage);

    }

}
