package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SecureAreaPageObject extends BasePageObject {

    private String expectedUrl = "https://the-internet.herokuapp.com/secure";
    private By logOutButton = By.xpath("//a[@class='button secondary radius']");
    public By message = By.id("flash-messages");

    public SecureAreaPageObject(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /**
     * Get URL variable from PageObject
     */
    public String getPageUrl(){
        return expectedUrl;
    }

    /**
     * Verification if LogOutButton is visible on the page
     * @return if button is visible
     */
    public boolean isLogOutButtonVisible(){
        return find(logOutButton).isDisplayed();
    }

    /**
     * Return text from success message
     * @return current page message
     */
    public String getSuccessMessageTest(){
        return find(message).getText();
    }

}
