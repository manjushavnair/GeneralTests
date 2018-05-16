/**
 *
 */
package com.testcases;

/**
 * @author Manjusha Saju
 */
//http://www.webtoolkitonline.com/xml-xpath-tester.html

//	http://xmltoolbox.appspot.com/xpath_generator.html


import com.commons.SAASCONSTANTS;
import com.pageobjects.HomePage;
import com.pageobjects.StruggleAnalyticsPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class StruggleAnalyticsTest extends SaaSloginTest {

    private static Logger logger = Logger.getLogger(StruggleAnalyticsTest.class);

    public StruggleAnalyticsTest() {

        super();

    }

    @Test(priority = 2)
    public void struggleAnalytics() {
        logger.info("Entering struggleAnalytics");

        try {

            StruggleAnalyticsPage stru_page = PageFactory.initElements(driver,
                    StruggleAnalyticsPage.class);

            try {

                logger.info("Waiting 20 sec before StruggleAnalytics Page click");

                Thread.sleep(SAASCONSTANTS.WAITTIME20000MILLISEC);
                logger.info("Waiting 20 sec completed and calling  clickStrugAnalytics");
            } catch (Exception e) {

                e.printStackTrace();
            }

            stru_page.clickStrugAnalytics();
            stru_page.registration();


            stru_page.backToStruggleAnalytics();

            stru_page.shoppingCart();
            stru_page.backToStruggleAnalytics();
            stru_page.checkOut();
            stru_page.backToStruggleAnalytics();
            stru_page.bannerLandingPage();
            //	stru_page.backToStruggleAnalytics();

            HomePage home_page = PageFactory.initElements(driver,
                    HomePage.class);
            home_page.backToHome();

        } catch (Exception e) {

            e.printStackTrace();

        }
        logger.info("Exiting struggleAnalytics");

    }

}
