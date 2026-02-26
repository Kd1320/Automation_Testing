
package bankingTests;

import base.BaseClass;
import pages.LoginPage;
import pages.DashboardPage;
import pages.FundTransferPage;
import org.testng.annotations.Test;

public class FundTransferTest extends BaseClass {

    @Test
    public void verifyFundTransfer() {

        driver.get("https://demo.guru99.com/V4/");

        LoginPage login = new LoginPage(driver);
        login.enterUsername("mngr34926");
        login.enterPassword("amUpenu");
        login.clickLogin();

        FundTransferPage fund = new FundTransferPage(driver);
        fund.openFundTransfer();
        fund.transfer("123456", "654321", "5000", "Testing Transfer");

        System.out.println("Fund Transfer Test Passed");
    }
}
