package com.herokuapp.theinternet.pages;

import com.beust.jcommander.IStringConverter;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePageObject {
    private WebDriver driver;
    private Logger log;

    private String pageUrl = "https://the-internet.herokuapp.com/";

    private By formAuthenticationinklocator = By.linkText("Form Authentication");

    public WelcomePageObject(WebDriver driver, Logger log) {
        this.driver = driver;
        this.log = log;
    }

    /**
     * Open welcome page with it's url
     */
    public void openPage() {
        log.info("Opening page: " + pageUrl);
        driver.get(pageUrl);
        log.info("Page opened!");
    }

    /**
     * Open loginPage by clicking on form Authentication link
     */
    public LoginPage clickFormAuthenticationlink() {
        log.info("Clicking form authentication link on Welcome Page");
        driver.findElement(formAuthenticationinklocator);
        return new LoginPage(driver, log);
    }
}
