package com.commons;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class RestAPIReader extends Properties {

    private static RestAPIReader prpreader;

    public static RestAPIReader readProperty() {

        if (prpreader == null) {
            prpreader = new RestAPIReader();
        }

        try {
            InputStream in = new FileInputStream(new File(
                    RESTAPICONSTANTS.CONFIGPATH));
            prpreader.load(in);
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (Exception e) {
            e.printStackTrace();

        }

        return prpreader;
    }

}
