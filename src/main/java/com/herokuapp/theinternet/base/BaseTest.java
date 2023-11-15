package com.herokuapp.theinternet.base;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


public class BaseTest {

    protected WebDriver driver;
    protected Logger log;

    @Parameters({"browser"})
    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional("chrome") String browser, ITestContext ctx) {

        String testName = ctx.getCurrentXmlTest().getName();
        log = (Logger) LogManager.getLogger(testName);

        //Instance new Browser Driver Factory class
        BrowserDriverFactory factory = new BrowserDriverFactory(browser, log);

        //Create driver
        driver = factory.createDriver();

        //Maximize browser
        driver.manage().window().maximize();
    }

    //Close webpage
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.close();
        log.info("Test Finished");
    }
}
