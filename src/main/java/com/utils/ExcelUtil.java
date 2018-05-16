package com.utils;

import com.commons.SAASCONSTANTS;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class ExcelUtil {

    private static Logger logger = Logger.getLogger(ExcelUtil.class);
    private Sheet datatypeSheet;


    // This method is to set the File path and to open the Excel file, Pass
    // Excel Path and Sheetname as Arguments to this method

    public static void main(String arg[]) {

        // Call the method
        String userName = "";
        String password = "";
        try {

            ExcelUtil eu = new ExcelUtil();

            eu.setExcelFile(SAASCONSTANTS.LOGINXLSDATAPATH,
                    SAASCONSTANTS.LOGINXLSDATASHEETNAMELOGIN);

            userName = eu.getCellData(1, 1);
            password = eu.getCellData(1, 2);

            System.out.print("username" + userName + "password" + password);
        } catch (Exception e) {

            e.printStackTrace();
        }

        // login_page.login_SaaS(userName, password);
    }

    // This method is to read the test data from the Excel cell, in this we are
    // passing parameters as Row num and Col num

    public void setExcelFile(String filePath, String sheetName)
            throws Exception {

        try {

            // Open the Excel file
            File f = new File(filePath);
            FileInputStream excelFile = new FileInputStream(filePath);

            // Access the required test data sheet
            Workbook workbook = null;
            if (filePath.endsWith("xlsx")) {
                workbook = new XSSFWorkbook(excelFile);
            } else if (filePath.endsWith("xls")) {
                workbook = new HSSFWorkbook(excelFile);
            } else {
                throw new IllegalArgumentException(
                        "The specified file is not Excel file");
            }
            logger.info("Reading the excel file ::" + filePath + " and sheetname ::" + sheetName);

            datatypeSheet = workbook.getSheet(sheetName);

        } catch (Exception e) {
            e.printStackTrace();

            throw (e);

        }

    }

    public String getCellData(int rowNum, int colNum) throws Exception {

        try {

            String cellData = datatypeSheet.getRow(rowNum).getCell(colNum)
                    .getStringCellValue();

            return cellData;

        } catch (Exception e) {
            e.printStackTrace();

            return "";

        }

    }

}