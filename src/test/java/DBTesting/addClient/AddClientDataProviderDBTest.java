package DBTesting.addClient;

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

import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;

import static util.Conversion.*;
import static util.ForDataProvider.getDataFromExcelSheet;

public class AddClientDataProviderDBTest {

    WebDriver driver;
    @BeforeClass
    public void doLogin()
    {

            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("http://localhost/ip");

            Login login = new Login(driver);

            login.setTxtUsername("amolujagare@gmail.com");
            login.setTxtPassword("admin123");
            login.clickLogin();

    }

    @Test (dataProvider = "getData")
    public void addClientTest(String ClientName, String ClientSurname, String Language,
                              String StreetAddress1, String StreetAddress2, String City,
                              String State, String ZipCode, String Country, String Gender,
                              String BirthDate, String PhoneNumber, String FaxNumber,
                              String MobileNumber, String EmailAddress, String WebAddress,
                              String VATID, String TaxesCode) throws ClassNotFoundException, SQLException, ParseException {
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


        ArrayList<String> expected = new ArrayList<>();
        expected.add(ClientName);
        expected.add(ClientSurname);
        expected.add(Language.toLowerCase());
        expected.add(StreetAddress1);
        expected.add(StreetAddress2);
        expected.add(City);
        expected.add(State);
        expected.add(ZipCode);
        expected.add(Country);
        expected.add(Gender);
        expected.add(BirthDate);
        expected.add(PhoneNumber);
        expected.add(FaxNumber);
        expected.add(MobileNumber);
        expected.add(EmailAddress);
        expected.add(WebAddress);
        expected.add(VATID);
        expected.add(TaxesCode);

        // 1. loading a driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2. creating a connection
        String user = "root";
        String pass = "root";
        String connectionUrl = "jdbc:mysql://localhost:3306/ip";

        Connection con = DriverManager.getConnection(connectionUrl,user,pass);

        // 3. creating a statement
        Statement st = con.createStatement();

        // 4. execute query
        String sql ="SELECT * FROM ip_clients where client_name='"+ClientName+"'";

        ResultSet rs = st.executeQuery(sql);

        ArrayList<String> actual = new ArrayList<>();

        while (rs.next())
        {
            actual.add(rs.getString("client_name"));
            actual.add(rs.getString("client_surname"));
            actual.add(rs.getString("client_language"));
            actual.add(rs.getString("client_address_1"));
            actual.add(rs.getString("client_address_2"));
            actual.add(rs.getString("client_city"));
            actual.add(rs.getString("client_state"));
            actual.add(rs.getString("client_zip"));

            String shortCountry = rs.getString("client_country");
            String fullFormCountry = convertCountry(shortCountry);
            actual.add(fullFormCountry);


            actual.add(getGender(rs.getString("client_gender")));


            actual.add(convertDate(rs.getString("client_birthdate")));
            actual.add(rs.getString("client_phone"));
            actual.add(rs.getString("client_fax"));
            actual.add(rs.getString("client_mobile"));
            actual.add(rs.getString("client_email"));
            actual.add(rs.getString("client_web"));
            actual.add(rs.getString("client_vat_id"));
            actual.add(rs.getString("client_tax_code"));
        }


        System.out.println("expected="+expected);
        System.out.println("actual="+actual);

        Assert.assertEquals(actual,expected,"Data Miss match");

    }

    @DataProvider
    Object[][] getData() throws IOException {
       return getDataFromExcelSheet("Data/invoiceplane.xlsx","Db Testing Data");
    }
}
