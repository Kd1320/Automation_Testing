
package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FundTransferPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By fundTransferLink = By.linkText("Fund Transfer");
    private final By payerAccount     = By.name("payersaccount");
    private final By payeeAccount     = By.name("payeeaccount");
    private final By amount           = By.name("ammount");
    private final By description      = By.name("desc");
    private final By submitBtn        = By.name("AccSubmit");
    private final By formMarker       = By.cssSelector("form[action*='stmt/Input'], form[action*='fundtrans'], input[name='payersaccount']");

    public FundTransferPage(WebDriver driver) {
        this.driver = driver;
        this.wait   = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openFundTransfer() {
        WebElement link = wait.until(ExpectedConditions.presenceOfElementLocated(fundTransferLink));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", link);

        try {
            wait.until(ExpectedConditions.elementToBeClickable(link)).click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", link);
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(formMarker));
    }

    public boolean isFormLoaded() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(formMarker));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void transfer(String payer, String payee, String amt, String descText) {
        WebElement payerEl = wait.until(ExpectedConditions.visibilityOfElementLocated(payerAccount));
        WebElement payeeEl = wait.until(ExpectedConditions.visibilityOfElementLocated(payeeAccount));
        WebElement amtEl   = wait.until(ExpectedConditions.visibilityOfElementLocated(amount));
        WebElement descEl  = wait.until(ExpectedConditions.visibilityOfElementLocated(description));

        payerEl.clear(); payerEl.sendKeys(payer);
        payeeEl.clear(); payeeEl.sendKeys(payee);
        amtEl.clear();   amtEl.sendKeys(amt);
        descEl.clear();  descEl.sendKeys(descText);

        wait.until(ExpectedConditions.elementToBeClickable(submitBtn)).click();
    }
}
