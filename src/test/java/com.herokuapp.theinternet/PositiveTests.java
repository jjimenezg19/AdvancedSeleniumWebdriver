package com.herokuapp.theinternet;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class PositiveTests {

    @Test(priority = 1, groups = {"positiveTests", "smokeTests"})
    public void positiveLoginTest() {
        System.out.println("LoginTest Test Started");

        //Create driver
        WebDriver driver = new ChromeDriver();

        //Open test page
        driver.get("http://the-internet.herokuapp.com/login");
        driver.manage().window().maximize();

        System.out.println("Page opened");

        //enter username
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("tomsmith");

        //enter password
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("SuperSecretPassword!");

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
        String expectedMessage = "You logged into a secure area!";
        String actualMessage = successMessage.getText();
        //Assert.assertEquals(actualMessage, expectedMessage, "Actual message is not the same as expected");
        Assert.assertTrue(actualMessage.contains(expectedMessage), "Actual message does not contain expected.\nActual Message: " + actualMessage + "\nExpected Message: " + expectedMessage);

        driver.close();
        System.out.println("Test Finished");
    }

}
