
package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseClass {
    protected WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        // Uncomment to run headless in CI if needed:
        // if (Boolean.parseBoolean(System.getProperty("headless", "false"))) {
        //     options.addArguments("--headless=new");
        // }
        options.addArguments("--start-maximized");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        driver = new ChromeDriver(options);

        // Use explicit waits in page objects; keep implicit 0
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(45));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeEach() {
        // Avoid state leakage
        driver.manage().deleteAllCookies();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    protected String acceptAlertIfPresent(int timeoutSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
            Alert a = wait.until(ExpectedConditions.alertIsPresent());
            String txt = a.getText();
            a.accept();
            return txt;
        } catch (TimeoutException e) {
            return null;
        }
    }
}
