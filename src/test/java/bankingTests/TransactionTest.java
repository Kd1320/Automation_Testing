
package bankingTests;

import base.BaseClass;
import pages.LoginPage;
import pages.TransactionPage;
import org.testng.annotations.Test;

public class TransactionTest extends BaseClass {

    @Test
    public void verifyMiniStatement() {

        driver.get("https://demo.guru99.com/V4/");

        LoginPage login = new LoginPage(driver);
        login.enterUsername("mngr34926");
        login.enterPassword("amUpenu");
        login.clickLogin();

        TransactionPage tp = new TransactionPage(driver);
        tp.openMiniStatement();

        System.out.println("Transaction Test Passed");
    }
}
