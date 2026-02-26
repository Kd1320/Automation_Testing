
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FundTransferPage {

    WebDriver driver;

    By fundTransferLink = By.linkText("Fund Transfer");
    By payer = By.name("payersaccount");
    By payee = By.name("payeeaccount");
    By amount = By.name("ammount");
    By desc = By.name("desc");
    By submit = By.name("AccSubmit");

    public FundTransferPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openFundTransfer() {
        driver.findElement(fundTransferLink).click();
    }

    public void transfer(String payerAcc, String payeeAcc, String amt, String description) {
        driver.findElement(payer).sendKeys(payerAcc);
        driver.findElement(payee).sendKeys(payeeAcc);
        driver.findElement(amount).sendKeys(amt);
        driver.findElement(desc).sendKeys(description);
        driver.findElement(submit).click();
    }
}
