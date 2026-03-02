
package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    // Resilient locators (cover common variants on the demo site):
    private final By username = By.cssSelector("input[name='uid'], input#uid, input[name='username']");
    private final By password = By.cssSelector("input[name='password'], input#password");
    private final By loginBtn = By.cssSelector("input[name='btnLogin'], input[type='submit'][value='LOGIN']");
    private final By managerHomeMarker = By.cssSelector(".barone, td.heading3, h2"); // unique post-login element

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait   = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public LoginPage open(String baseUrl) {
        driver.get(baseUrl);
        wait.until(ExpectedConditions.visibilityOfElementLocated(username));
        return this;
    }

    public LoginPage enterUsername(String user) {
        WebElement u = wait.until(ExpectedConditions.visibilityOfElementLocated(username));
        u.clear();
        u.sendKeys(user);
        return this;
    }

    public LoginPage enterPassword(String pass) {
        WebElement p = wait.until(ExpectedConditions.visibilityOfElementLocated(password));
        p.clear();
        p.sendKeys(pass);
        return this;
    }

    // >>> Final alert-first logic to avoid UnhandledAlertException <<<
    public LoginPage clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();

        // 1) If an alert appears (invalid login), return immediately.
        try {
            new WebDriverWait(driver, Duration.ofSeconds(2))
                    .until(ExpectedConditions.alertIsPresent());
            return this; // let the test decide when to accept the alert
        } catch (TimeoutException ignored) { }

        // 2) Otherwise, wait for the dashboard marker (valid login).
        wait.until(ExpectedConditions.presenceOfElementLocated(managerHomeMarker));
        return this;
    }
}
