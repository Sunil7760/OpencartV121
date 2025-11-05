package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBases.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {

    @Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
    public void verify_loginDDT(String email, String pwd, String exp) {

        logger.info("***** Starting TC003_LoginDDT *****");

        try {
            // Home Page
            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            hp.clickLogin();

            // Login Page
            LoginPage lp = new LoginPage(driver);
            lp.setEmail(email);
            lp.setPassword(pwd);
            lp.clickLogin();

            // My Account Page
            MyAccountPage macc = new MyAccountPage(driver);
            boolean targetPage = macc.isMyPageExists();

            if (exp.equalsIgnoreCase("Valid")) {
                if (targetPage) {
                    macc.clickLogout();
                    Assert.assertTrue(true);
                }
                else
                {
                    Assert.assertTrue(false, "Valid login data failed to login.");
                }
            }

            if (exp.equalsIgnoreCase("Invalid")) {
                if (targetPage) {
                    macc.clickLogout();
                    Assert.assertTrue(false, "Invalid login succeeded unexpectedly.");
                } else {
                    Assert.assertTrue(true);
                }
            }

        } catch (Exception e) {
            logger.error("Exception in TC003_LoginDDT: " + e.getMessage());
            Assert.fail("Test failed due to exception.");
        }

        logger.info("***** Finished TC003_LoginDDT *****");
    }
}
