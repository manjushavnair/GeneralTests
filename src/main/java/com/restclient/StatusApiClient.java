package com.restclient;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.Response.Status;
import java.io.BufferedReader;
import java.io.IOException;

public class StatusApiClient {
    private static final Logger LOG = LoggerFactory.getLogger(StatusApiClient.class);
    HttpGet httpGet = null;
    private String targetUrl = "";
    private HttpClient client = null;

    public StatusApiClient(HttpClient client, HttpGet httpGet) {
        this.client = client;
        this.httpGet = httpGet;
    }

    public StatusApiClient(String targetUrl) {
        this.targetUrl = targetUrl;
        this.client = HttpClientBuilder.create().build();
        this.httpGet = new HttpGet(targetUrl);
    }

    public boolean getStatus() {
        BufferedReader rd = null;
        boolean status = false;
        try {
            LOG.debug("Requesting status: " + targetUrl);


            HttpResponse response = client.execute(httpGet);

            if (response.getStatusLine().getStatusCode() == Status.OK.getStatusCode()) {
                LOG.debug("Is online.");
                status = true;
            }

        } catch (Exception e) {
            LOG.error("Error getting the status", e);
        } finally {
            if (rd != null) {
                try {
                    rd.close();
                } catch (IOException ioe) {
                    LOG.error("Error while closing the Buffered Reader used for reading the status", ioe);
                }
            }
        }

        return status;
    }
}

