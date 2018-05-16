package com.testcases.base;

import com.commons.PropertyReader;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    protected static WebDriver driver;
    protected static PropertyReader prpr;
    private static Logger logger = Logger.getLogger(BaseTest.class);
    protected WebDriverWait wait;

    @BeforeSuite
    protected void setUpBeforeTestSuite() {
        // initialize a browser driver, connect to servers
    }

    @AfterSuite
    protected void tearDownAfterTestSuite() {
        logger.info("Quiting the tearDownAfterTestSuite ::BaseTest ");
        driver.quit();
    }

    /*
       @BeforeMethod
         protected  void setUpBeforeTestMethod() {
           // initialize testPage
           // login to the app, if necessary
         }
       @AfterMethod
         protected  void tearDownAfterTestMethod() {
           // logout of the app, if necessary
         }

        @BeforeClass
           protected void setUpBeforeTestClass(){
               // initialize a browser driver, connect to servers
             }
             */
    @AfterClass
    protected void tearDownAfterTestClass() {
        // close connections, close browser as needed
        logger.info("Quiting browser  tearDownAfterTestClass  ::BaseTest");
        driver.quit();
    }
}
