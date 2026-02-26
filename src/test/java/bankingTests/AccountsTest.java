
package bankingTests;

import base.BaseClass;
import pages.LoginPage;
import pages.AccountsPage;
import org.testng.annotations.Test;

public class AccountsTest extends BaseClass {

    @Test
    public void verifyBalancePage() {

        driver.get("https://demo.guru99.com/V4/");

        LoginPage login = new LoginPage(driver);
        login.enterUsername("mngr34926");
        login.enterPassword("amUpenu");
        login.clickLogin();

        AccountsPage acc = new AccountsPage(driver);
        acc.openBalance();

        System.out.println("Accounts Test Passed");
    }
}
