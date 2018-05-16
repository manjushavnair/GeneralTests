/**
 *
 */
package com.commons;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

/**
 * @author manjusha saju
 */
public class BrowserFactory {


    private static WebDriver driver;
    private static PropertyReader prpr;

    private static Logger logger = Logger.getLogger(BrowserFactory.class);

    public static WebDriver startBrowser(String browserName, String url) {
        BasicConfigurator.configure();

        logger.info("Starting Browser");

        prpr = PropertyReader.readProperty();
        logger.info("Starting reader ");

        /*
         * Preconditions.checkNotNull(browserName,
         * "Target browser parameter is null"); if (BrowserFactory.driver !=
         * null) { throw new
         * AssertionError("WebDriver instance  re-initialized"); }
         */
        if (driver == null) {
            synchronized (BrowserFactory.class) {

                if (browserName.equalsIgnoreCase(SAASCONSTANTS.FIREFOX))

                {
                    synchronized (BrowserFactory.class) {
                        if (driver == null)
                            driver = new FirefoxDriver();
                    }

                } else if (browserName
                        .equalsIgnoreCase(SAASCONSTANTS.CHROME)) {
                    System.setProperty("webdriver.chrome.driver",
                            prpr.getProperty("CHROME_DRIVER_SERVER_PATH"));
                    synchronized (BrowserFactory.class) {
                        if (driver == null)
                            driver = new ChromeDriver();
                    }
                } else if (browserName.equalsIgnoreCase(SAASCONSTANTS.IE)) {
                    System.setProperty("webdriver.ie.driver",
                            prpr.getProperty("IE_DRIVER_SERVER_PATH"));
                    synchronized (BrowserFactory.class) {
                        if (driver == null)
                            driver = new InternetExplorerDriver();
                    }
                }
            }
        }

        // driver.manage().timeouts().pageLoadTimeout(10L, TimeUnit.SECONDS);

        driver.manage().window().maximize();
        driver.manage()
                .timeouts()
                .implicitlyWait(SAASCONSTANTS.WAITTIME15SEC,
                        TimeUnit.SECONDS);
        driver.get(url);
        return driver;

    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void stopDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

}
