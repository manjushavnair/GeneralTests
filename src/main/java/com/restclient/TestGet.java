package com.restclient;

import com.commons.RESTAPICONSTANTS;
import com.utils.ExcelUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
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
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet("http://lifecharger.org/3-tips-for-a-better-life/");
        HttpResponse response = client.execute(request);
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String line = "";
        while ((line = rd.readLine()) != null) {
            System.out.println(line);
        }
    }

    public void readExcelData() {
        try {

            eu = new ExcelUtil();

            eu.setExcelFile(RESTAPICONSTANTS.LOGINXLSDATAPATH,
                    RESTAPICONSTANTS.LOGINXLSDATASHEETNAMELOGIN);
            String userName = eu.getCellData(1, 1);
            String password = eu.getCellData(1, 2);
        } catch (Exception e) {
            Assert.fail("Unable to login");

            e.printStackTrace();
        }
        logger.info("Exiting verifyValidLogin");
    }
}