package UITesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Login;
import util.OpenURL;

import static UITesting.uiUtility.UITestMethods.*;

public class LoginTest extends OpenURL {
    Login login;
    @BeforeClass
    public void initLogin()
    {
        login = new Login(driver);
    }


    @Test
    public void txtUsernameVisibilityCheck()
    {
              /*
        boolean expected =  true;
        boolean actual = false;
        try {
             actual = login.txtUsername.isDisplayed();
        }
        catch (Exception e)
        {

        }*/

        boolean expected =  true;
        boolean actual = visibilityCheck(login.txtUsername);
        Assert.assertEquals(actual,expected,
                "this element is not displayed");
    }

    @Test
    public void txtPasswordVisibilityCheck() {
        boolean expected =  true;
        boolean actual = visibilityCheck(login.txtPassword);
        Assert.assertEquals(actual,expected,
                "this element is not displayed");


      /*  Assert.assertEquals(visibilityCheck(login.txtPassword),
                true,
                "this element is not displayed");*/
    }

    @Test
    public void lblEmailSpellCheck()
    {
        String expected = "Email";
        String actual = spellCheck(login.lblEmail);

        System.out.println("expected="+expected);
        System.out.println("actual="+actual);

        Assert.assertEquals(actual,expected,
                "this spelling is incorrect");
    }

    @Test
    public void lblPasswordSpellCheck()
    {
        String expected = "Password";
        String actual = spellCheck(login.lblPassword);

        System.out.println("expected="+expected);
        System.out.println("actual="+actual);

        Assert.assertEquals(actual,expected,
                "this spelling is incorrect");
    }

    @Test
    public void txtEmailPlaceholderCheck()
    {
        String expected = "Email";
        String actual = getValue(login.txtUsername,"placeholder");

        System.out.println("expected="+expected);
        System.out.println("actual="+actual);

        Assert.assertEquals(actual,expected,
                "placeholder value is incorrect");
    }

    @Test
    public void lblEmailFontSizeCheck()
    {
        String expected = "14px";
        String actual = getStyleValue(login.lblEmail,"font-size");

        System.out.println("expected="+expected);
        System.out.println("actual="+actual);

        Assert.assertEquals(actual,expected,
                "font size value is incorrect");
    }

    //-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif
    @Test
    public void lblEmailFontFamilyCheck()
    {
        String expected = "-apple-system, system-ui, BlinkMacSystemFont, \"Segoe UI\", Roboto, \"Helvetica Neue\", Arial, sans-serif";
        String actual = getStyleValue(login.lblEmail,"font-family");

        System.out.println("expected="+expected);
        System.out.println("actual="+actual);

        Assert.assertEquals(actual,expected,
                "font family value is incorrect");
    }

    @Test
    public void btnLoginColorCheck()
    {
        String expected = "#2C8EDD";
        String rgbColor = getStyleValue(login.btnLogin,"background-color");

        String actual = Color.fromString(rgbColor).asHex().toUpperCase();

        System.out.println("expected="+expected);
        System.out.println("actual="+actual);

        Assert.assertEquals(actual,expected,
                "font color value is incorrect");
    }
}
