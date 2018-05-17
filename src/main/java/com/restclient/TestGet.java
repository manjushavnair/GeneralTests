//https://dzone.com/articles/how-test-rest-api-junit
//https://semaphoreci.com/community/tutorials/testing-rest-endpoints-using-rest-assured
package com.restclient;

import com.commons.RESTAPICONSTANTS;
import com.utils.ExcelUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.log4j.Logger;
import org.testng.Assert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class TestGet {

    private static Logger logger = Logger
            .getLogger(TestGet.class);
    private ExcelUtil eu = null;

    public static void main(String[] args) throws ClientProtocolException, IOException {
        new TestGet().readExcelData();
    }

    public void readExcelData() {
        String baseurl =null;
        String posts =null;
        try {

            eu = new ExcelUtil();

            eu.setExcelFile(RESTAPICONSTANTS.LOGINXLSDATAPATH,
                    RESTAPICONSTANTS.LOGINXLSDATASHEETNAMEVALID);
            baseurl = eu.getCellData(0, 1);
            posts = eu.getCellData(0, 2);

            logger.info(baseurl);

            HttpClient client = HttpClientFactory.getHttpsClient();
            HttpGet request = new HttpGet(baseurl+posts);
            HttpResponse response = client.execute(request);
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String line = "";
            while ((line = rd.readLine()) != null) {
                System.out.println(line);
            }


        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Unable to access "+baseurl);


        }
        logger.info("Exiting verifyValidLogin");
    }

    public void testBase() {
        String baseurl =null;
        String posts =null;
        try {

            eu = new ExcelUtil();

            eu.setExcelFile(RESTAPICONSTANTS.LOGINXLSDATAPATH,
                    RESTAPICONSTANTS.LOGINXLSDATASHEETNAMEVALID);
            baseurl = eu.getCellData(0, 1);
            posts = eu.getCellData(0, 2);

            logger.info(baseurl);

            HttpClient client = HttpClientFactory.getHttpsClient();
            HttpGet request = new HttpGet(baseurl+posts);
            HttpResponse response = client.execute(request);
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String line = "";
            while ((line = rd.readLine()) != null) {
                System.out.println(line);
            }


        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Unable to access "+baseurl);


        }
        logger.info("Exiting verifyValidLogin");
    }

}
