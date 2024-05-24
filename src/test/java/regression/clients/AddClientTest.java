package regression.clients;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Login;
import pages.Menu;
import pages.clients.AddClient;
import util.DoLogin;

public class AddClientTest extends DoLogin {


    @Test
    public void addClientTest()
    {
        Menu menu = new Menu(driver);
        menu.clickAddClient();

        AddClient addClient = new AddClient(driver);

        addClient.setClientName("John");
        addClient.setClientSurname("Doe");
        addClient.setLanguage("Thai");
        addClient.setStreetAddress1("123 Main St");
        addClient.setStreetAddress2("Apt 101");
        addClient.setCity("New York");
        addClient.setState("NY");
        addClient.setZipCode("10001");
        addClient.setCountry("Iran");
        addClient.setGender("Female");
        addClient.setBirthDate("16/11/1750");
        addClient.setPhoneNumber("123-456-7890");
        addClient.setFaxNumber("123-456-7891");
        addClient.setMobileNumber("987-654-3210");
        addClient.setEmailAddress("john.doe@example.com");
        addClient.setWebAddress("http://www.example.com");
        addClient.setVATID("123456789");
        addClient.setTaxesCode("TAX123");
        addClient.clickBtnSave();




    }
}
