package regression.clients;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Login;
import pages.Menu;
import pages.clients.AddClient;
import util.DoLogin;

import java.io.IOException;

import static util.ForDataProvider.getDataFromExcelSheet;

public class AddClientDataProviderTest extends DoLogin {



    @Test (dataProvider = "getData")
    public void addClientTest(String ClientName, String ClientSurname, String Language,
                              String StreetAddress1, String StreetAddress2, String City,
                              String State, String ZipCode, String Country, String Gender,
                              String BirthDate, String PhoneNumber, String FaxNumber,
                              String MobileNumber, String EmailAddress, String WebAddress,
                              String VATID, String TaxesCode,String expected,String xpathActual)
    {
        Menu menu = new Menu(driver);
        menu.clickAddClient();

        AddClient addClient = new AddClient(driver);

        addClient.setClientName(ClientName);
        addClient.setClientSurname(ClientSurname);
        addClient.setLanguage(Language);
        addClient.setStreetAddress1(StreetAddress1);
        addClient.setStreetAddress2(StreetAddress2);
        addClient.setCity(City);
        addClient.setState(State);
        addClient.setZipCode(ZipCode);
        addClient.setCountry(Country);
        addClient.setGender(Gender);
        addClient.setBirthDate(BirthDate);
        addClient.setPhoneNumber(PhoneNumber);
        addClient.setFaxNumber(FaxNumber);
        addClient.setMobileNumber(MobileNumber);
        addClient.setEmailAddress(EmailAddress);
        addClient.setWebAddress(WebAddress);
        addClient.setVATID(VATID);
        addClient.setTaxesCode(TaxesCode);

        addClient.clickBtnSave();


        String actual = "";
        try {
            actual = driver.findElement(By.xpath(xpathActual)).getText();
        }
        catch (Exception e)
        {

        }

        System.out.println("expected="+expected);
        System.out.println("actual="+actual);

        Assert.assertEquals(actual,expected,"Incorrect message or user not added");

    }

    @DataProvider
    Object[][] getData() throws IOException {
       return getDataFromExcelSheet("Data/invoiceplane.xlsx","mydata");
    }
}
