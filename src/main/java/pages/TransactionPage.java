
package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TransactionPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By miniStatement = By.linkText("Mini Statement");
    private final By accountNo     = By.name("accountno");
    private final By submitBtn     = By.name("AccSubmit");

    private final By miniStatementHeading = By.xpath("//p[text()='Last Five Transaction Details']");

    public TransactionPage(WebDriver driver) {
        this.driver = driver;
        this.wait   = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openMiniStatement() {
        WebElement link = wait.until(ExpectedConditions.presenceOfElementLocated(miniStatement));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", link);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(link)).click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", link);
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(accountNo));
    }

    public boolean isMiniStatementFormLoaded() {
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

    public boolean isMiniStatementShown() {
        return !driver.findElements(miniStatementHeading).isEmpty()
                && driver.findElement(miniStatementHeading).isDisplayed();
    }
}
