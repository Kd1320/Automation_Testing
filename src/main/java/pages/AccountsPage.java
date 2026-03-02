
package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountsPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By balanceLink = By.linkText("Balance Enquiry");
    private final By accountNo   = By.name("accountno");
    private final By submitBtn   = By.name("AccSubmit");

    // Optional success heading if a valid account is used
    private final By balanceDetailsHeading = By.xpath("//p[text()='Balance Details']");

    public AccountsPage(WebDriver driver) {
        this.driver = driver;
        this.wait   = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openBalance() {
        WebElement link = wait.until(ExpectedConditions.presenceOfElementLocated(balanceLink));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", link);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(link)).click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", link);
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(accountNo));
    }

    public boolean isBalanceFormLoaded() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(accountNo));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void enterAccount(String acc) {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(accountNo));
        input.clear();
        input.sendKeys(acc);
    }

    public void submit() {
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn)).click();
    }

    public boolean isBalanceDetailsShown() {
        return !driver.findElements(balanceDetailsHeading).isEmpty()
                && driver.findElement(balanceDetailsHeading).isDisplayed();
    }
}
