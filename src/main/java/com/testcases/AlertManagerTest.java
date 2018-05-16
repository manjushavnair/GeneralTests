/**
 *
 */
package com.testcases;

/**
 * @author Manjusha Saju
 */

import com.commons.SAASCONSTANTS;
import com.pageobjects.AlertManagerPage;
import com.utils.ExcelUtil;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertManagerTest extends SaaSloginTest {

    private static Logger logger = Logger.getLogger(AlertManagerTest.class);
    private AlertManagerPage alertmanager_page;

    public AlertManagerTest() {

        super();
        System.out.println("AlertManagerTest called");
        alertmanager_page = PageFactory.initElements(
                driver, AlertManagerPage.class);

    }

    /*
     * Test Case 1
     * 1.Log into SaaS
     * 2.Navigate to Alert Manager view
     * 3.Click on Alert Manager
     * 4. Search for an alert from existing ones
     * 5. Ensure the alert has been selected and displayed
     * */
    @Test(priority = 2)
    public void clickAlertManager() {

        try {

            logger.info("Entering into clickAlertManager ");

            Thread.sleep(SAASCONSTANTS.WAITTIME100000MILLISEC);

            alertmanager_page.invokeAlertManager();

            logger.info("Exiting from clickAlertManager");

        } catch (Exception e) {
            Assert.fail("Unable to click the  AlertManager Links");
            e.printStackTrace();

        }

    }

    @Test(priority = 3)
    public void searchAlert() {

        String searchString = null;
        try {
            ExcelUtil eu = new ExcelUtil();
            eu.setExcelFile(SAASCONSTANTS.LOGINXLSDATAPATH, SAASCONSTANTS.LOGINXLSDATASHEETNAMEALERTMANAGER);
            searchString = eu.getCellData(2, 0);

            Thread.sleep(SAASCONSTANTS.WAITTIME5000MILLISEC);

            alertmanager_page.searchAlert(searchString);

            logger.info("searchString " + searchString);


            //go to home

        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    /*
     * Test Case 2
     * 1. From the opened Alert Manager window, select new alert
     * 2. Ensure new alert window is popped up to add details further
     *
     * */

    @Test(priority = 4)
    public void newAlertpopup() {

        try {

            logger.info("Entering into newAlertpopup");

            //Thread.sleep(TeaLeafCONSTANTS.WAITTIME100000MILLISEC);

            alertmanager_page.newAlert();

            logger.info("Exiting from newAlertpopup");

        } catch (Exception e) {
            Assert.fail("Unable to open new alert window from Alert Manager");
            e.printStackTrace();
        }
    }

}
