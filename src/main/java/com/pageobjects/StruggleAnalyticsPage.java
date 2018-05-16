/**
 *
 */
package com.pageobjects;

import com.commons.SAASCONSTANTS;
import com.pageobjects.base.BasePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

/**
 * @author ManjushaSaju
 */
public class StruggleAnalyticsPage extends BasePage {


    private static Logger logger = Logger
            .getLogger(StruggleAnalyticsPage.class);
    @FindBy(xpath = "//span[contains(@title,'Struggle Analytics')]")
    //@FindBy(xpath = "//span[@class='name struggles struggles-click']")
            WebElement struggleanalytics;
    // Method to call StruggleAnalytics->Registration
    @FindBy(xpath = "//label[contains(.,'Registration')]")
    WebElement reglabel;
    /**
     * Method to call StruggleAnalytics->Shopping cart
     *
     * @throws InterruptedException
     */

    @FindBy(xpath = "//label[contains(.,'Shopping cart')]")
    WebElement shoppingcartlabel;
    /**
     * Method to call StruggleAnalytics->Checkout
     *
     * @throws InterruptedException
     */
    @FindBy(xpath = ("//label[contains(.,'Checkout')]"))
    WebElement checkoutlabel;
    /**
     * Method to call StruggleAnalytics->BannerLandingPage
     *
     * @throws InterruptedException
     */
    @FindBy(xpath = ("//label[contains(.,'Banner Landing Page')]"))
    WebElement bannerlabel;
    /**
     * Navigating back to StruggleAnalytics view
     *
     * @throws InterruptedException
     */
    @FindBy(xpath = ("//a[contains(@href,'/struggle-analytics')and contains(@ui-sref,'struggles({})')]"))
    WebElement menustruggle;

    public StruggleAnalyticsPage() {
        logger.info("default constructor called");

    }

    public StruggleAnalyticsPage(WebDriver driver) {
        super(driver);

    }

    public void clickStrugAnalytics() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, SAASCONSTANTS.WAITTIME10SEC);
        wait.until(ExpectedConditions.textToBePresentInElement(struggleanalytics, "Struggle Analytics"));
        logger.info("Entering clickStrugAnalytics");


        try {
            struggleanalytics.click();
        } catch (WebDriverException e) {
            Assert.fail("struggleanalytics click fail");
        }
        logger.info("Exiting clickStrugAnalytics  clicked");
        Thread.sleep(SAASCONSTANTS.WAITTIME10000MILLISEC);
        //return PageFactory.initElements(driver, StruggleAnalyticsPage.class);

    }

    public void registration() throws InterruptedException {
        logger.info("Entering Registration struggle report");
        Thread.sleep(SAASCONSTANTS.WAITTIME10000MILLISEC);

        try {
            reglabel.click();
        } catch (WebDriverException e) {
            Assert.fail("No such element");
        }

        logger.info("Exiting Registration struggle report");
    }

    public void shoppingCart() throws InterruptedException {

        logger.info("Entering Shopping cart struggle report yet to click");
        WebDriverWait wait = new WebDriverWait(driver, SAASCONSTANTS.WAITTIME60SEC);
        wait.until(ExpectedConditions.textToBePresentInElement(
                shoppingcartlabel, "Shopping cart"));

        shoppingcartlabel.click();
        logger.info("Exiting Shopping cart struggle report clicked");
        Thread.sleep(SAASCONSTANTS.WAITTIME10000MILLISEC);


    }

    public void checkOut() throws InterruptedException {

        logger.info("Entering Checkout struggle report");
        Thread.sleep(SAASCONSTANTS.WAITTIME10000MILLISEC);
        checkoutlabel.click();
        Thread.sleep(SAASCONSTANTS.WAITTIME10000MILLISEC);
        logger.info("Exiting Checkout struggle report");
    }

    public void bannerLandingPage() throws InterruptedException {
        logger.info("Enter Banner landing page report");
        Thread.sleep(SAASCONSTANTS.WAITTIME20000MILLISEC);
        bannerlabel.click();
        Thread.sleep(SAASCONSTANTS.WAITTIME10000MILLISEC);
        logger.info("In Banner landing page report");
    }

    public void backToStruggleAnalytics() throws InterruptedException {
        Thread.sleep(SAASCONSTANTS.WAITTIME10000MILLISEC);
        logger.info("Navigating back to Struggle Analytics ");
        driver.manage().timeouts()
                .implicitlyWait(SAASCONSTANTS.WAITTIME60SEC, TimeUnit.SECONDS);

        Actions builder2 = new Actions(driver);
        builder2.moveToElement(menustruggle).click(menustruggle);
        builder2.perform();
        logger.info("Successfully navigated back to Struggle Analytics ");
        Thread.sleep(SAASCONSTANTS.WAITTIME20000MILLISEC);
    }

}
