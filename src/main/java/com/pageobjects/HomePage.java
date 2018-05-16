package com.pageobjects;

import com.commons.SAASCONSTANTS;
import com.pageobjects.base.BasePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class HomePage extends BasePage {


    private static Logger logger = Logger.getLogger(HomePage.class);
    /**
     * 1. Navigating back to home page from BBR replay view
     *
     * @throws InterruptedException
     */
    @FindBy(xpath = "//a[contains(@href,'/home')and contains(.,'Customer Experience')]")
    //@FindBy(xpath = "//a[@class='active']")
            WebElement homepage;

    public HomePage() {

    }

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void backToHome() throws InterruptedException {
        logger.info("Navigating back to Home Page ");
        Thread.sleep(SAASCONSTANTS.WAITTIME5000MILLISEC);
        driver.manage()
                .timeouts()
                .implicitlyWait(SAASCONSTANTS.WAITTIME15SEC,
                        TimeUnit.SECONDS);
        Actions builder = new Actions(driver);
        builder.moveToElement(homepage).click(homepage);
        builder.perform();
        logger.info("Successfully navigated back to Home Page ");
        try {
            Thread.sleep(SAASCONSTANTS.WAITTIME10SEC);
        } catch (Exception e) {
            Assert.fail("Unable to return back to home page");
            e.printStackTrace();
        }
    }

}