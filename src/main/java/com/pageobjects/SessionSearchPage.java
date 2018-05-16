/**
 *
 */
package com.pageobjects;

import com.commons.SAASCONSTANTS;
import com.pageobjects.base.BasePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

/**
 * @author Manjusha Saju
 */

//http://www.utilities-online.info/xpath/#.WSz7M2mGNrQ
//http://xmltoolbox.appspot.com/xpathevaluator.html
public class SessionSearchPage extends BasePage {

    private static Logger logger = Logger.getLogger(SessionSearchPage.class);
    // 1.Navigate to session search page view from home
    //@FindBy(xpath = "//span[contains(@title,'Session Search')]")
    @FindBy(xpath = "//span[@class='name sessionsearch sessionsearch-click']")
    //@FindBy(xpath = "//span[@class='name sessionsearch sessionsearch-click'] | //span[contains(@title,'Session Search')]")

            WebElement sess_search;
    // 2. Display default Session search view( for last 24 hrs )
    //@FindBy(xpath = "//button[text()='Search']")
    @FindBy(xpath = "//button[@class='btn btn-primary ng-binding']")
    WebElement defaultsearch;
    @FindBy(xpath = "//*[@id='sessions_list']/tbody/tr[3]/td[2]")
    WebElement firstsession;
    /**
     * Navigating back to Session Search page
     *
     * @throws InterruptedException
     */
    @FindBy(xpath = "//a[contains(@href,'/sessionsearch?result=false')and contains(.,'Session Search')]")
    WebElement searchpage;
    // Select drop down option for Session End Time by clicking on
    // 24hrs.Option-default search
    @FindBy(xpath = "//div[contains(@class,'sess-endtime')]//filtering-select//div//div[1]//div[3]//div[contains(@class, 'input-icon icons glyphicon glyphicon-chevron-down')]")
    WebElement last_24hrs;
    // Click on drop down option-Last 5 min
    //@FindBy(xpath = "//div[contains(@class,'sess-endtime')]//filtering-select//div//div[2]//ul//li[1]//a[@title='Last 5 minutes']")
    @FindBy(xpath = "//div[@class='sess-endtime']//a[@title='Last 5 minutes']")
    WebElement last_5min;

    // 3. Select a BBR session for replay
    // Click on drop down option-Last 15 min
    @FindBy(xpath = "//div[contains(@class,'sess-endtime')]//filtering-select//div//div[2]//ul//li[2]//a[@title='Last 15 minutes']")
    WebElement last_15min;
    // Click on drop down option-Last 30 min
    @FindBy(xpath = "//div[contains(@class,'sess-endtime')]//filtering-select//div//div[2]//ul//li[3]//a[@title='Last 30 minutes']")
    WebElement last_30min;
    // Click on drop down option-Last hour
    @FindBy(xpath = "//div[contains(@class,'sess-endtime')]//filtering-select//div//div[2]//ul//li[4]//a[@title='Last hour']")
    WebElement last_hour;
    // Click on drop down option-Last 12 hours
    //@FindBy(xpath = "//div[contains(@class,'sess-endtime')]//filtering-select//div//div[2]//ul//li[5]//a[@title='Last 12 hours']")
    @FindBy(xpath = "//*[contains(@title, 'Last 12 hours')]|//*[contains(.,'Last 12 hours')]")
    WebElement last_12hours;
    // Click on drop down option-Last 7 days
    @FindBy(xpath = "//div[contains(@class,'sess-endtime')]//filtering-select//div//div[2]//ul//li[7]//a[@title='Last 7 days']")
    WebElement last_7days;
    // Click on drop down option-Last 14 days
    @FindBy(xpath = "//div[contains(@class,'sess-endtime')]//filtering-select//div//div[2]//ul//li[8]//a[@title='Last 14 days']")
    WebElement last_14days;
    // Click on drop down option-custom date range
    @FindBy(xpath = "//div[contains(@class,'sess-endtime')]//filtering-select//div//div[2]//ul//li[9]//a[@title='Custom date range']")
    WebElement customdaterange;

    public SessionSearchPage() {
        logger.info("default constructor called");

    }

    public SessionSearchPage(WebDriver driver) {
        super(driver);

    }

    public void sessSearch() {
        logger.info("Entering into Session Search Page View");
        WebDriverWait wait = new WebDriverWait(driver, SAASCONSTANTS.WAITTIME60SEC);
        wait.until(ExpectedConditions.textToBePresentInElement(sess_search, "Session Search"));
        logger.info("Entering into Session Search Page View going to click on view");
        sess_search.click();


        try {
            Thread.sleep(SAASCONSTANTS.WAITTIME10000MILLISEC);
        } catch (Exception e) {
            Assert.fail("Unable to navigate to Session Search page");
            e.printStackTrace();
        }
        logger.info("In Session Search Page View");
    }

    public void clickonSearchButton() {

        logger.info("Identified the Search button to be clicked  :: clickonSearchButton");
        //	driver.manage().timeouts().implicitlyWait(TeaLeafCONSTANTS.WAITTIME30SEC,TimeUnit.SECONDS);
        try {
            WebDriverWait wait = new WebDriverWait(driver, SAASCONSTANTS.WAITTIME80SEC);
            wait.until(ExpectedConditions.textToBePresentInElement(defaultsearch,
                    "Search"));

            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", defaultsearch);

            logger.info("Performed the method ::clickonSearchButton");


            Thread.sleep(SAASCONSTANTS.WAITTIME20000MILLISEC);
        } catch (Exception e) {
            Assert.fail("Unable to display default session search view");
            e.printStackTrace();
        }

    }

    public void selectBBRsession() throws InterruptedException {
        logger.info("Selecting a BBR session");
        try {
            driver.manage()
                    .timeouts()
                    .implicitlyWait(SAASCONSTANTS.WAITTIME160SEC,
                            TimeUnit.SECONDS);
            Actions builder = new Actions(driver);
            // 3.a Move cursor to the Main Menu Element
            builder.moveToElement(firstsession).perform();
            // 3.b Giving 5 Secs for submenu to be displayed

            Thread.sleep(SAASCONSTANTS.WAITTIME20000MILLISEC);
            // 3.c Clicking on the Hidden SubMenu
            firstsession.click();
            logger.info("BBR session is selected");

        } catch (Exception e) {
            Assert.fail("Unable to click on replay icon");
            e.printStackTrace();
        }

        Thread.sleep(SAASCONSTANTS.WAITTIME20000MILLISEC);

    }

    public void backToSearch(String functionName) {
        logger.info("Navigating back to Session search Page from :" + functionName);
        try {
            Thread.sleep(SAASCONSTANTS.WAITTIME5000MILLISEC);
            driver.manage()
                    .timeouts()
                    .implicitlyWait(SAASCONSTANTS.WAITTIME60SEC,
                            TimeUnit.SECONDS);
            Actions builder = new Actions(driver);
            builder.moveToElement(searchpage).click(searchpage);
            builder.perform();
            logger.info("Successfully navigated back to Session search Page from :" + functionName);
            Thread.sleep(SAASCONSTANTS.WAITTIME30000MILLISEC);
        } catch (Exception e) {
            Assert.fail("Unable to return back to Session Search pageview");
            e.printStackTrace();
        }
    }

    public void clickonDefaultOption_Last24hrs() {
        logger.info("In default select option of 'Last 24 hrs'");
        try {
            WebDriverWait wait = new WebDriverWait(driver, SAASCONSTANTS.WAITTIME30SEC);
            wait.until(ExpectedConditions.visibilityOf(last_24hrs));
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", last_24hrs);
            // last_24hrs.click();
            logger.info("In default End option of 'Last 24 hrs'");

            Thread.sleep(SAASCONSTANTS.WAITTIME20000MILLISEC);
        } catch (Exception e) {
            Assert.fail("Unable to click the drop down menu for Session End Time");
            e.printStackTrace();
        }
    }

    public void clickonOption_Last5min() {
        logger.info("Selected session end time 'Last 5 minutes'");
        WebDriverWait wait = new WebDriverWait(driver, SAASCONSTANTS.WAITTIME30SEC);
        wait.until(ExpectedConditions.textToBePresentInElement(last_5min,
                "Last 5 minutes"));
        try {
            Actions builder = new Actions(driver);
            builder.moveToElement(last_5min).build().perform();
            last_5min.click();
            logger.info("End session end time 'Last 5 minutes'");

            Thread.sleep(SAASCONSTANTS.WAITTIME20000MILLISEC);
        } catch (InterruptedException e) {
            Assert.fail("Unable to click the drop down menu option- Last 5 min for Session End Time");
            e.printStackTrace();
        }

    }

    public void clickonOption_Last15min() throws InterruptedException {
        logger.info("Selected session end time 'Last 15 minutes'");
        WebDriverWait wait = new WebDriverWait(driver, SAASCONSTANTS.WAITTIME30SEC);
        wait.until(ExpectedConditions.textToBePresentInElement(last_15min,
                "Last 15 minutes"));
        Actions builder = new Actions(driver);
        builder.moveToElement(last_15min).build().perform();
        last_15min.click();
        logger.info("End session end time 'Last 15 minutes'");
        Thread.sleep(SAASCONSTANTS.WAITTIME30000MILLISEC);
    }

    public void clickonOption_Last30min() throws InterruptedException {
        logger.info("Selected session end time 'Last 30 minutes'");
        WebDriverWait wait = new WebDriverWait(driver, SAASCONSTANTS.WAITTIME30SEC);
        wait.until(ExpectedConditions.textToBePresentInElement(last_30min,
                "Last 30 minutes"));
        Actions builder = new Actions(driver);
        builder.moveToElement(last_30min).build().perform();
        last_30min.click();
        logger.info("End session end time 'Last 30 minutes'");
        Thread.sleep(SAASCONSTANTS.WAITTIME30000MILLISEC);
    }

    public void clickonOption_Lasthour() throws InterruptedException {
        logger.info("Selected session end time 'Last hour'");
        WebDriverWait wait = new WebDriverWait(driver, SAASCONSTANTS.WAITTIME30SEC);
        wait.until(ExpectedConditions.textToBePresentInElement(last_hour,
                "Last hour"));
        Actions builder = new Actions(driver);
        builder.moveToElement(last_hour).build().perform();
        last_hour.click();
        logger.info("End session end time 'Last hour'");
        Thread.sleep(SAASCONSTANTS.WAITTIME30000MILLISEC);
    }

    public void clickonOption_Last12hours() throws InterruptedException {
        logger.info("Selected session end time 'Last 12 hours'");
        WebDriverWait wait = new WebDriverWait(driver, SAASCONSTANTS.WAITTIME30SEC);
        wait.until(ExpectedConditions.textToBePresentInElement(last_12hours,
                "Last 12 hours"));
        Actions builder = new Actions(driver);
        builder.moveToElement(last_12hours).build().perform();
        last_12hours.click();
        logger.info("End session end time 'Last 12 hours'");
        Thread.sleep(SAASCONSTANTS.WAITTIME30000MILLISEC);
    }

    public void clickonOption_Last7days() throws InterruptedException {
        logger.info("Selected session end time 'Last 7 days'");
        // Create instance of Javascript executor
        JavascriptExecutor je = (JavascriptExecutor) driver;
        //Identify the WebElement which will appear after scrolling down
        // now execute query which actually will scroll until that element is not appeared on page.
        je.executeScript("arguments[0].scrollIntoView(true);", last_7days);
        WebDriverWait wait = new WebDriverWait(driver, SAASCONSTANTS.WAITTIME30SEC);
        wait.until(ExpectedConditions.textToBePresentInElement(last_7days,
                "Last 7 days"));
        logger.info("Scrolled down to view the option 'Last 7 days'");
        Actions builder = new Actions(driver);
        builder.moveToElement(last_7days).build().perform();
        last_7days.click();
        logger.info("End session end time 'Last 7 days'");
        Thread.sleep(SAASCONSTANTS.WAITTIME30000MILLISEC);
    }

    public void clickonOption_Last14days() throws InterruptedException {
        logger.info("Selected session end time 'Last 14 days'");
        // Create instance of Javascript executor
        JavascriptExecutor je = (JavascriptExecutor) driver;
        //Identify the WebElement which will appear after scrolling down
        // now execute query which actually will scroll until that element is not appeared on page.
        je.executeScript("arguments[0].scrollIntoView(true);", last_14days);
        logger.info("Scrolled down to view the option 'Last 14 days'");
        WebDriverWait wait = new WebDriverWait(driver, SAASCONSTANTS.WAITTIME30SEC);
        wait.until(ExpectedConditions.textToBePresentInElement(last_14days,
                "Last 14 days"));
        Actions builder = new Actions(driver);
        builder.moveToElement(last_14days).build().perform();
        last_14days.click();
        logger.info("End session end time 'Last 14 days'");
        Thread.sleep(SAASCONSTANTS.WAITTIME30000MILLISEC);
    }

    public void clickonOption_Customdaterange() throws InterruptedException {
        logger.info("Selected session end time 'Custom Date Range'");
        WebDriverWait wait = new WebDriverWait(driver, SAASCONSTANTS.WAITTIME30SEC);
        wait.until(ExpectedConditions.textToBePresentInElement(customdaterange,
                "Custom date range"));
        Actions builder = new Actions(driver);
        builder.moveToElement(customdaterange).build().perform();
        customdaterange.click();
        logger.info("End session end time 'Custom Date Range'");
        Thread.sleep(SAASCONSTANTS.WAITTIME30000MILLISEC);
    }

}
