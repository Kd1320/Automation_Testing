
package bankingTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.Test;

public class LoginTest {

    @Test
    public void openBankingSite() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://demo.guru99.com/V4/");

        System.out.println("Page Title: " + driver.getTitle());

        driver.quit();
    }
}
