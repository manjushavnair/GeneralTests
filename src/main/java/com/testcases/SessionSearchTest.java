package com.testcases;

/**
 * @author Manjusha Saju
 */

import com.commons.SAASCONSTANTS;
import com.pageobjects.SessionSearchPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SessionSearchTest extends SaaSloginTest {

    private static Logger logger = Logger.getLogger(SessionSearchTest.class);

    public SessionSearchTest() {

        super();
        System.out.println("SessionSearchTest called");

    }

    /*
     * Test Case 1 1.Log into  SaaS 2.Navigate to Session Search view 3.
     * Click on Search button for the default session end time 4. Select one of
     * the BBR session to replay. 5. Ensure session availability in default
     * session search view 6. Naviagate back to Session Search page
     */
    @Test(priority = 1)
    public void sessionSearchLast24hrs() {

        try {

            logger.info("Entering into sessionSearchLast24hrs ");
            SessionSearchPage sessionsearch_page = PageFactory.initElements(
                    driver, SessionSearchPage.class);

            try {
                Thread.sleep(SAASCONSTANTS.WAITTIME1000MILLISEC);
            } catch (Exception e) {

                e.printStackTrace();
            }

            sessionsearch_page.sessSearch();
            logger.info("Identify sessSearch default session search page view  :: sessionSearchLast24hrs ");

            sessionsearch_page.clickonSearchButton();
            logger.info("clickonsearch button   :: sessionSearchLast24hrs ");

            sessionsearch_page.selectBBRsession();
            logger.info("select  selectBBRsession  for reply  :: sessionSearchLast24hrs ");

            sessionsearch_page.backToSearch("sessionSearchLast24hrs");

            logger.info("Go back to default search view   :: sessionSearchLast24hrs ");

            logger.info("Exiting from sessionSearchLast24hrs");

        } catch (Exception e) {
            Assert.fail("Unable to execute default search with BBR session replay");
            e.printStackTrace();

        }

    }


    /*Test Case 2 1.Log into  SaaS 2.Navigate to Session Search view
     * 3.Click on the option for session end time-Last 5 minutes 4. Click on
     * Search button 5.Select one of the BBR session to replay. 6. Ensure
     * session availability in this session search view 7. Naviagate back to
     * Session Search page*/

/*	@Test()
	public void sessionSearchLast5Min() {

		logger.info("Entering into sessionSearchLast5Min ");
		try {

			SessionSearchPage sessionsearch_page = PageFactory.initElements(
					driver, SessionSearchPage.class);
			//sessionsearch_page.sessSearch(); //no need to go to new session ssearch for this instance

			sessionsearch_page.clickonDefaultOption_Last24hrs();

			logger.info("Executed  clickonDefaultOption_Last24hrs to get the drop down list :: sessionSearchLast5Min ");

			sessionsearch_page.clickonOption_Last5min();

			logger.info("Clicked on drop down 5 minutes to replay   :: sessionSearchLast5Min ");

			sessionsearch_page.clickonSearchButton();

			logger.info("Clicked on search button to list the  replay  items :: sessionSearchLast5Min ");

			sessionsearch_page.selectBBRsession();

			logger.info("Selected the replay item :: sessionSearchLast5Min ");

			sessionsearch_page.backToSearch("sessionSearchLast5Min");

		} catch (Exception e) {
			e.printStackTrace();

		}
		logger.info("Exiting from sessionSearchLast5Min ");
	}



	 /* Test Case 3 1.Log into  SaaS 2.Navigate to Session Search view
	 * 3.Click on the option for session end time-Last 15 minutes 4. Click on
	 * Search button 5.Select one of the BBR session to replay. 6. Ensure
	 * session availability in this session search view 7. Naviagate back to
	 * Session Search page*/

/*	@Test()
	public void sessionSearchLast15Min() {

		logger.info("Entering into sessionSearchLast15Min ");
		try {

			SessionSearchPage sessionsearch_page = PageFactory.initElements(
					driver, SessionSearchPage.class);
			sessionsearch_page.sessSearch();

			sessionsearch_page.clickonDefaultOption_Last24hrs();
			sessionsearch_page.clickonOption_Last15min();
			sessionsearch_page.clickonSearchButton();
			sessionsearch_page.selectBBRsession();
			sessionsearch_page.backToSearch("sessionSearchLast15Min");

		} catch (Exception e) {
			e.printStackTrace();

		}
		logger.info("Exiting into sessionSearchLast15Min ");

	}


	 /* Test Case 4 1.Log into  SaaS 2.Navigate to Session Search view
	 * 3.Click on the option for session end time-Last 30 minutes 4. Click on
	 * Search button 5.Select one of the BBR session to replay. 6. Ensure
	 * session availability in this session search view 7. Naviagate back to
	 * Session Search page */

    /*	@Test()
        public void sessionSearchLast30Min() {

            logger.info("Entering into sessionSearchLast30Min ");
            try {

                SessionSearchPage sessionsearch_page = PageFactory.initElements(
                        driver, SessionSearchPage.class);
                sessionsearch_page.sessSearch();

                sessionsearch_page.clickonDefaultOption_Last24hrs();
                sessionsearch_page.clickonOption_Last30min();
                sessionsearch_page.clickonSearchButton();
                sessionsearch_page.selectBBRsession();
                sessionsearch_page.backToSearch("sessionSearchLast30Min");

            } catch (Exception e) {
                e.printStackTrace();

            }
            logger.info("Exiting into sessionSearchLast30Min ");

        }


         /* Test Case 5 1.Log into  SaaS 2.Navigate to Session Search view
         * 3.Click on the option for session end time-Last hour 4. Click on
         * Searchbutton 5.Select one of the BBR session to replay. 6. Ensure session
         * availability in this session search view 7. Naviagate back to Session
         * Search page
        */
/*	@Test()
	public void sessionSearchLasthour() {
		logger.info("Entering  sessionSearchLasthour");
		try {

			SessionSearchPage sessionsearch_page = PageFactory.initElements(
					driver, SessionSearchPage.class);
			sessionsearch_page.sessSearch();

			sessionsearch_page.clickonDefaultOption_Last24hrs();

			logger.info("Executed  clickonDefaultOption_Last24hrs to get the drop down list :: sessionSearchLasthour");
			sessionsearch_page.clickonOption_Lasthour();
			logger.info("Executed  clickonOption_Lasthour to get the drop down list :: sessionSearchLasthour");
			sessionsearch_page.clickonSearchButton();
			logger.info("Executed  clickonSearchButton to get the drop down list :: sessionSearchLasthour");
			sessionsearch_page.selectBBRsession();
			logger.info("Executed  selectBBRsession to get the drop down list :: sessionSearchLasthour");

			sessionsearch_page.backToSearch("sessionSearchLasthour");

			logger.info("Exiting  sessionSearchLasthour ");
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	/*
	 * Test Case 6 1.Log into  SaaS 2.Navigate to Session Search view
	 * 3.Click on the option for session end time-Last 12 hours 4. Click on
	 * Search button 5.Select one of the BBR session to replay. 6. Ensure
	 * session availability in this session search view 7. Naviagate back to
	 * Session Search page
	 */
    @Test(priority = 2)
    public void sessionSearchLast12hours() {

        try {
            logger.info("Entering  sessionSearchLast12hours ");
            SessionSearchPage sessionsearch_page = PageFactory.initElements(
                    driver, SessionSearchPage.class);
            sessionsearch_page.sessSearch();

            sessionsearch_page.clickonDefaultOption_Last24hrs();
            logger.info("Executed  clickonDefaultOption_Last24hrs to get the drop down list :: sessionSearchLast12hours");
            sessionsearch_page.clickonOption_Last12hours();
            logger.info("Executed  clickonOption_Last12hrs to get the drop down list :: sessionSearchLast12hours");
            sessionsearch_page.clickonSearchButton();
            logger.info("Executed  clickSearchButton to get the drop down list :: sessionSearchLast12hours");
            sessionsearch_page.selectBBRsession();
            sessionsearch_page.backToSearch("sessionSearchLast12hours");
            logger.info("Exiting  sessionSearchLast12hours ");

        } catch (Exception e) {
            e.printStackTrace();

        }

    }



    /* Test Case 7 1.Log into  SaaS 2.Navigate to Session Search view
     * 3.Click on the option for session end time-Last 7 days
     * 4. Click on Search
     * button
     * 5.Select one of the BBR session to replay.
     * 6. Ensure session
     * availability in this session search view
     * 7. Naviagate back to Session
     * Search page*/

    @Test(priority = 3)
    public void sessionSearchLast7days() {

        try {
            logger.info("Entering  sessionSearchLast7days ");
            SessionSearchPage sessionsearch_page = PageFactory.initElements(
                    driver, SessionSearchPage.class);
            sessionsearch_page.sessSearch();

            sessionsearch_page.clickonDefaultOption_Last24hrs();
            sessionsearch_page.clickonOption_Last7days();
            sessionsearch_page.clickonSearchButton();
            sessionsearch_page.selectBBRsession();
            sessionsearch_page.backToSearch("sessionSearchLast7days");
            logger.info("Exiting  sessionSearchLast7days ");

        } catch (Exception e) {
            e.printStackTrace();

        }

    }


    /* Test Case 8 1.Log into  SaaS 2.Navigate to Session Search view
     * 3.Click on the option for session end time-Last 14 days 4. Click on
     * Search button 5.Select one of the BBR session to replay. 6. Ensure
     * session availability in this session search view 7. Naviagate back to
     * Session Search page*/

    @Test(priority = 4)
    public void sessionSearchLast14days() {

        try {
            logger.info("Entering  sessionSearchLast14days ");
            SessionSearchPage sessionsearch_page = PageFactory.initElements(
                    driver, SessionSearchPage.class);
            sessionsearch_page.sessSearch();

            sessionsearch_page.clickonDefaultOption_Last24hrs();
            sessionsearch_page.clickonOption_Last14days();
            sessionsearch_page.clickonSearchButton();
            sessionsearch_page.selectBBRsession();
            sessionsearch_page.backToSearch("sessionSearchLast14days");
            logger.info("Exiting  sessionSearchLast14days ");
        } catch (Exception e) {
            e.printStackTrace();

        }

    }

/*
	 * Test Case 9 1.Log into  SaaS 2.Navigate to Session Search view
	 * 3.Click on the option for session end time-Custom date range 4. Click on
	 * Search button 5.Select one of the BBR session to replay. 6. Ensure
	 * session availability in this session search view 7. Naviagate back to
	 * Session Search page


	@Test(priority = 10)
	public void sessionSearch_Customdaterange() {

		try {
			logger.info("Entering  sessionSearch_Customdaterange ");
			SessionSearchPage sessionsearch_page = PageFactory.initElements(
					driver, SessionSearchPage.class);
			sessionsearch_page.sessSearch();

			sessionsearch_page.clickonDefaultOption_Last24hrs();
			sessionsearch_page.clickonOption_Customdaterange();
			sessionsearch_page.clickonSearchButton();
			sessionsearch_page.selectBBRsession();
			sessionsearch_page.backToSearch("sessionSearch_Customdaterange");
			logger.info("Exiting  sessionSearch_Customdaterange ");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}*/


}

