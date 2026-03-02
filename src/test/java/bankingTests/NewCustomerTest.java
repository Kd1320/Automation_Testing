
package bankingTests;

import org.testng.annotations.Test;
import pages.NewCustomerPage;
import utils.ExcelUtils;
import base.BaseClass;

public class NewCustomerTest extends BaseClass {

    @Test
    public void createNewCustomerTest() throws InterruptedException {

        NewCustomerPage newCustomer = new NewCustomerPage(driver);

        // Test Data
        String name = "Komal";
        String gender = "female";
        String dob = "12-10-1995";
        String address = "Pune";
        String city = "Pune";
        String state = "MH";
        String pin = "411001";
        String mobile = "9876543210";
        String email = "komal" + System.currentTimeMillis() + "@gmail.com";
        String password = "12345";

        // Actions
        newCustomer.enterName(name);
        newCustomer.selectFemaleGender();
        newCustomer.enterDOB(dob);
        newCustomer.enterAddress(address);
        newCustomer.enterCity(city);
        newCustomer.enterState(state);
        newCustomer.enterPIN(pin);
        newCustomer.enterMobile(mobile);
        newCustomer.enterEmail(email);
        newCustomer.enterPassword(password);

        newCustomer.clickSubmit();

        Thread.sleep(2000);

        // Fetch customer ID
        String customerID = newCustomer.getCustomerID();
        System.out.println("New Customer ID is: " + customerID);

        // Save to Excel (now goes to target/CustomerData.xlsx)
        ExcelUtils.writeCustomerData(
                name,
                email,
                mobile,
                customerID,
                "Success"
        );
    }
}
