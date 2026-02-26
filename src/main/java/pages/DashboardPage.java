package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {

    WebDriver driver;

    By managerID = By.xpath("//td[contains(text(),'Manger Id')]");

    By newAccountLink = By.linkText("New Account");
    By editAccountLink = By.linkText("Edit Account");
    By depositLink = By.linkText("Deposit");
    By withdrawalLink = By.linkText("Withdrawal");
    By fundTransferLink = By.linkText("Fund Transfer");
    By miniStatementLink = By.linkText("Mini Statement");
    By customizedStatementLink = By.linkText("Customised Statement");
    By logoutLink = By.linkText("Log out");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isManagerIDDisplayed() {
        return driver.findElement(managerID).isDisplayed();
    }

    public void clickFundTransfer() {
        driver.findElement(fundTransferLink).click();
    }

    public void clickLogout() {
        driver.findElement(logoutLink).click();
    }
}