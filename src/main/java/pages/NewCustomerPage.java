
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewCustomerPage {

    WebDriver driver;

    public NewCustomerPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By customerName = By.name("name");
    By genderFemale = By.xpath("//input[@value='f']");
    By dobInput = By.name("dob");
    By addressInput = By.name("addr");
    By cityInput = By.name("city");
    By stateInput = By.name("state");
    By pinInput = By.name("pinno");
    By mobileInput = By.name("telephoneno");
    By emailInput = By.name("emailid");
    By passwordInput = By.name("password");
    By submitBtn = By.name("sub");

    // Success Customer ID
    By customerIdCell = By.xpath("//td[text()='Customer ID']/following-sibling::td");

    // Actions
    public void enterName(String name) { driver.findElement(customerName).sendKeys(name); }
    public void selectFemaleGender() { driver.findElement(genderFemale).click(); }
    public void enterDOB(String dob) { driver.findElement(dobInput).sendKeys(dob); }
    public void enterAddress(String address) { driver.findElement(addressInput).sendKeys(address); }
    public void enterCity(String city) { driver.findElement(cityInput).sendKeys(city); }
    public void enterState(String state) { driver.findElement(stateInput).sendKeys(state); }
    public void enterPIN(String pin) { driver.findElement(pinInput).sendKeys(pin); }
    public void enterMobile(String mobile) { driver.findElement(mobileInput).sendKeys(mobile); }
    public void enterEmail(String email) { driver.findElement(emailInput).sendKeys(email); }
    public void enterPassword(String pass) { driver.findElement(passwordInput).sendKeys(pass); }
    public void clickSubmit() { driver.findElement(submitBtn).click(); }
    public String getCustomerID() { return driver.findElement(customerIdCell).getText(); }
}
