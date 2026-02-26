
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountsPage {

    WebDriver driver;

    By balanceLink = By.linkText("Balance Enquiry");

    public AccountsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openBalance() {
        driver.findElement(balanceLink).click();
    }
}
