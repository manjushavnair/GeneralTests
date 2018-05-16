/**
 *
 */
package com.testcases;

/**
 * @author Manjusha Saju
 */

import com.commons.SAASCONSTANTS;
import com.pageobjects.LoginPage;
import com.testcases.base.SaaSBaseTest;
import com.utils.ExcelUtil;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
//import com.listener.LoginListener;

//@Listeners(com.listener.LoginListener.class)

public class SaaSloginTest extends SaaSBaseTest {

    private static Logger logger = Logger
            .getLogger(SaaSloginTest.class);

    public SaaSloginTest() {

        super();

    }

    @Test(priority = 1)
    public void verifyValidLogin() {

        logger.info("Entering verifyValidLogin");

        // Created page object using Page Factory
        LoginPage login_page = PageFactory
                .initElements(driver, LoginPage.class);


        // Call the method
        String userName = "";
        String password = "";
        try {

            ExcelUtil eu = new ExcelUtil();

            eu.setExcelFile(SAASCONSTANTS.LOGINXLSDATAPATH,
                    SAASCONSTANTS.LOGINXLSDATASHEETNAMELOGIN);
            userName = eu.getCellData(1, 1);
            password = eu.getCellData(1, 2);
        } catch (Exception e) {
            Assert.fail("Unable to login");

            e.printStackTrace();
        }
        logger.info("Exiting verifyValidLogin");
        login_page.login_SaaS(userName, password);
    }


}
