package UITesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Login;

public class LoginTest {
    WebDriver driver;
    Login login;
    @BeforeClass
    public void openUrl()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost/ip");
        login = new Login(driver);
    }


   /* @BeforeClass
    public void initLogin()
    {
       login = new Login(driver);
    }*/

    @Test
    public void txtUsernameVisibilityCheck()
    {
        boolean expected =  true;
        boolean actual = false;
        try {
             actual = login.txtUsername.isDisplayed();
        }
        catch (Exception e)
        {

        }
        Assert.assertEquals(actual,expected,
                "username text box is not displayed");
    }
}
