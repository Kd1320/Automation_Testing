
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TransactionPage {

    WebDriver driver;

    By miniStatement = By.linkText("Mini Statement");

    public TransactionPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openMiniStatement() {
        driver.findElement(miniStatement).click();
    }
}
