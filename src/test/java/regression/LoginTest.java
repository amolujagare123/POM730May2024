package regression;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;
import pages.Login;
import util.OpenURL;

import java.io.IOException;

import static util.ConfigReader.getPassword;
import static util.ConfigReader.getUsername;

public class LoginTest extends OpenURL {
  @Test
  public void loginTest() throws IOException {
    Login login = new Login(driver);
    login.setTxtUsername(getUsername());
    login.setTxtPassword(getPassword());
    login.clickLogin();

  }




}
