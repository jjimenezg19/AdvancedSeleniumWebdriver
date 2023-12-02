package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePageObject extends BasePageObject {

    private String pageUrl = "https://the-internet.herokuapp.com/";

    private By formAuthenticationinklocator = By.linkText("Form Authentication");

    public WelcomePageObject(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /**
     * Open welcome page with it's url
     */
    public void openPage() {
        log.info("Opening page: " + pageUrl);
        openUrl(pageUrl);
        log.info("Page opened!");
    }

    /**
     * Open loginPage by clicking on form Authentication link
     */
    public LoginPageObject clickFormAuthenticationlink() {
        log.info("Clicking form authentication link on Welcome Page");
        click(formAuthenticationinklocator);
        return new LoginPageObject(driver, log);
    }
}
