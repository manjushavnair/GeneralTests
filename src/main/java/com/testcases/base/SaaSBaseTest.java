/**
 *
 */
package com.testcases.base;

/**
 * @author Manjusha Saju
 */

import com.commons.BrowserFactory;
import com.commons.PropertyReader;
import com.commons.SAASCONSTANTS;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class SaaSBaseTest extends BaseTest {

    private static Logger logger = Logger.getLogger(SaaSBaseTest.class);

    public SaaSBaseTest() {

        prpr = PropertyReader.readProperty();

        setDriver(prpr.getProperty(SAASCONSTANTS.BROWSER_TYPE),
                prpr.getProperty(SAASCONSTANTS.APPLICATION_URL));

    }

    public WebDriver setDriver(String browserType, String appURL) {
        if (driver == null)
            driver = BrowserFactory.startBrowser(browserType, appURL);
        return driver;
    }

	/*
	@AfterSuite
	public void testDown() {
		BrowserFactory.stopDriver();

	}


	@Parameters({ "browserType", "appURL" })
	@BeforeSuite
	public void initializeTestBaseSetup(String browserType, String appURL) {
		try {
			setDriver(prpr.getProperty(TeaLeafCONSTANTS.BROWSER_TYPE),
				prpr.getProperty(TeaLeafCONSTANTS.APPLICATION_URL));
		} catch (Exception e) {
			logger.info("Cannot Identoify the WebDriver");
			e.printStackTrace();
		}
	}
	*/

}
