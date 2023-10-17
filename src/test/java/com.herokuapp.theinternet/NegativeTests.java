package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeTests {

    @Test(priority = 2, groups = {"negativeTests", "smokeTests"})
    public void incorrectUsernameTest() {
        System.out.println("Starting negativeLoginTest Tests");

        //Create driver
        WebDriver driver = new FirefoxDriver();

        //Open test page
        driver.get("http://the-internet.herokuapp.com/login");
        driver.manage().window().maximize();

        System.out.println("Page opened");

        //enter username
        WebElement usernameElement = driver.findElement(By.id("username"));
        usernameElement.sendKeys("Johan");

        //enter password
        WebElement passwordElement = driver.findElement(By.id("password"));
        passwordElement.sendKeys("SuperSecretPassword!");

        //click login button
        WebElement loginButton = driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
        loginButton.click();

        //verifications:

        //Unsuccessful login message
        WebElement errorMessage = driver.findElement(By.id("flash"));
        String expectedErrorMessage = "Your username is invalid!";
        String actualErrorMessage = errorMessage.getText();

        Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage),
                "Actual error message does not contain expected. \nActual Message: "
                        + actualErrorMessage + "\nExpected Message: "
                        + expectedErrorMessage);

        driver.close();
        System.out.println("Test Finished");
    }

    @Test(priority = 2, groups = {"negativeTests", "smokeTests"})
    public void incorrectPasswordTest() {
        System.out.println("Starting negativeLoginTest Tests");

        //Create driver
        WebDriver driver = new ChromeDriver();

        //Open test page
        driver.get("http://the-internet.herokuapp.com/login");
        driver.manage().window().maximize();

        System.out.println("Page opened");

        //enter username
        WebElement usernameElement = driver.findElement(By.id("username"));
        usernameElement.sendKeys("tomsmith");

        //enter password
        WebElement passwordElement = driver.findElement(By.id("password"));
        passwordElement.sendKeys("password");

        //click login button
        WebElement loginButton = driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
        loginButton.click();

        //verifications:

        //Unsuccessful login message
        WebElement errorMessage = driver.findElement(By.id("flash"));
        String expectedErrorMessage = "Your password is invalid!";
        String actualErrorMessage = errorMessage.getText();

        Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage),
                "Actual error message does not contain expected. \nActual Message: "
                        + actualErrorMessage + "\nExpected Message: "
                        + expectedErrorMessage);

        driver.close();
        System.out.println("Test Finished");
    }
}
