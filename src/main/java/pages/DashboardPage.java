
package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    // Manager ID text
    private final By managerID = By.xpath("//td[contains(text(),'Manger Id')]");

    // --- LEFT MENU LINKS (CUSTOMER) ---
    private final By newCustomerLink = By.linkText("New Customer");
    private final By editCustomerLink = By.linkText("Edit Customer");
    private final By deleteCustomerLink = By.linkText("Delete Customer");

    // --- LEFT MENU LINKS (ACCOUNT) ---
    private final By newAccountLink = By.linkText("New Account");
    private final By editAccountLink = By.linkText("Edit Account");
    private final By deleteAccountLink = By.linkText("Delete Account");

    // --- TRANSACTION LINKS ---
    private final By depositLink = By.linkText("Deposit");
    private final By fundTransferLink = By.linkText("Fund Transfer");

    private final By logoutLink = By.linkText("Log out");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.wait   = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isManagerIDDisplayed() {
        try {
            return driver.findElement(managerID).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // Alias for backward compatibility (your old tests)
    public boolean isManagerIdVisible() {
        return isManagerIDDisplayed();
    }

    // Generic method to click left navigation links safely
    private void safeClick(By locator) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", element);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }

    // ---------------- CUSTOMER MODULE ----------------
    public void clickNewCustomer() { safeClick(newCustomerLink); }
    public void clickEditCustomer() { safeClick(editCustomerLink); }
    public void clickDeleteCustomer() { safeClick(deleteCustomerLink); }

    // ---------------- ACCOUNT MODULE ----------------
    public void clickNewAccount() { safeClick(newAccountLink); }
    public void clickEditAccount() { safeClick(editAccountLink); }
    public void clickDeleteAccount() { safeClick(deleteAccountLink); }

    // ---------------- TRANSACTION MODULE ----------------
    public void clickDeposit() { safeClick(depositLink); }
    public void clickFundTransfer() { safeClick(fundTransferLink); }

    public void clickLogout() { safeClick(logoutLink); }
}
