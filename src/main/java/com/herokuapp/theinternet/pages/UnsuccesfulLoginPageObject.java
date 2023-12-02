package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UnsuccesfulLoginPageObject extends BasePageObject{

    public By message = By.id("flash");

    public UnsuccesfulLoginPageObject(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /**
     * Return text from success message
     * @return current page message
     */
    public String getUnsuccesfulMessageTest(){
        return find(message).getText();
    }
}
