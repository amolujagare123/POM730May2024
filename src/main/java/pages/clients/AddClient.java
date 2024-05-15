package pages.clients;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddClient {
    @FindBy(xpath = "//input[@id='client_name']")
    WebElement clientName;
    @FindBy(xpath = "//input[@id='client_surname']") WebElement clientSurname;
    @FindBy(xpath = "//input[@id='client_address_1']") WebElement streetAddress1;
    @FindBy(xpath = "//input[@id='client_address_2']") WebElement streetAddress2;
    @FindBy(xpath = "//input[@id='client_city']") WebElement city;
    @FindBy(xpath = "//input[@id='client_state']") WebElement state;
    @FindBy(xpath = "//input[@id='client_zip']") WebElement zipCode;
    @FindBy(xpath = "//input[@id='client_phone']") WebElement phoneNumber;
    @FindBy(xpath = "//input[@id='client_fax']") WebElement faxNumber;
    @FindBy(xpath = "//input[@id='client_mobile']") WebElement mobileNumber;
    @FindBy(xpath = "//input[@id='client_email']") WebElement emailAddress;
    @FindBy(xpath = "//input[@id='client_web']") WebElement webAddress;
    @FindBy(xpath = "//input[@id='client_vat_id']") WebElement vATID;
    @FindBy(xpath = "//input[@id='client_tax_code']") WebElement taxesCode;

    public AddClient(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    // Set Client Name
    public void setClientName(String name) {
        clientName.sendKeys(name);
    }

    // Set Client Surname
    public void setClientSurname(String surname) {
        clientSurname.sendKeys(surname);
    }

    // Set Street Address 1
    public void setStreetAddress1(String address) {
        streetAddress1.sendKeys(address);
    }

    // Set Street Address 2
    public void setStreetAddress2(String address) {
        streetAddress2.sendKeys(address);
    }

    // Set City
    public void setCity(String cityName) {
        city.sendKeys(cityName);
    }

    // Set State
    public void setState(String stateName) {
        state.sendKeys(stateName);
    }

    // Set Zip Code
    public void setZipCode(String zip) {
        zipCode.sendKeys(zip);
    }

    // Set Phone Number
    public void setPhoneNumber(String number) {
        phoneNumber.sendKeys(number);
    }

    // Set Fax Number
    public void setFaxNumber(String number) {
        faxNumber.sendKeys(number);
    }

    // Set Mobile Number
    public void setMobileNumber(String number) {
        mobileNumber.sendKeys(number);
    }

    // Set Email Address
    public void setEmailAddress(String email) {
        emailAddress.sendKeys(email);
    }

    // Set Web Address
    public void setWebAddress(String web) {
        webAddress.sendKeys(web);
    }

    // Set VAT ID
    public void setVATID(String vat) {
        vATID.sendKeys(vat);
    }

    // Set Taxes Code
    public void setTaxesCode(String code) {
        taxesCode.sendKeys(code);
    }

}
