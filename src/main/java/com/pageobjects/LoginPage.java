package com.pageobjects;

/**
 * @author Manjusha Saju
 */

import com.pageobjects.base.BasePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage extends BasePage {

    private static Logger logger = Logger.getLogger(LoginPage.class);
    @FindBy(id = "j_username")
    WebElement username;
    @FindBy(id = "j_password")
    WebElement password;

    // Instead of above commented method we can call @FindBy
    @FindBy(className = "submit")
    WebElement login_button;
    @FindBy(xpath = "//a[contains(text(),'Forgot password')]")
    WebElement forgot_password;
    public LoginPage() {
        logger.info("default constructor called");

    }
    public LoginPage(WebDriver driver) {
        super(driver);

    }

    public void login_SaaS(String userName, String passWord) {
        try {
            logger.info("Entering login");

            username.sendKeys(userName);
            password.sendKeys(passWord);
            login_button.click();
            logger.info("Exiting  login");
        } catch (Exception e) {
            Assert.fail("Login failed");
        }
        //return PageFactory.initElements(driver, LoginPage.class);

    }

}
