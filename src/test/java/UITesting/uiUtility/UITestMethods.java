package UITesting.uiUtility;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class UITestMethods {


    public static boolean visibilityCheck(WebElement element)
    {
        boolean result = false;
        try {
            result = element.isDisplayed();
        }
        catch (Exception e)
        {

        }
        return  result;
    }

    public static String spellCheck(WebElement element)
    {
        String result = "";
        try {
            result = element.getText();
        }
        catch (Exception e)
        {

        }
        return  result;
    }

    public static String getValue(WebElement element,String attributeName)
    {
        String result = "";
        try {
            result = element.getAttribute(attributeName);
        }
        catch (Exception e)
        {

        }
        return  result;
    }

    public static String getStyleValue(WebElement element,String propertyName)
    {
        String result = "";
        try {
            result = element.getCssValue(propertyName);
        }
        catch (Exception e)
        {

        }
        return  result;
    }
}
