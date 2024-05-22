package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Conversion {

    public static String convertCountry(String shortCodeCountry)
    {
        String convertedCountry="";

        switch (shortCodeCountry)
        {
            case "IN" :
                convertedCountry = "India";
                break;
            case "US" :
                convertedCountry = "United States";
                break;
            case "CA" :
                convertedCountry = "Canada";
                break;
            case "GB" :
                convertedCountry = "United Kingdom";
                break;
            case "AU" :
                convertedCountry = "Australia";
                break;
            case "FR" :
                convertedCountry = "France";
                break;
            case "DE" :
                convertedCountry = "Germany";
                break;
            case "JP" :
                convertedCountry = "Japan";
                break;
            case "CN" :
                convertedCountry = "China";
                break;
            case "BR" :
                convertedCountry = "Brazil";
                break;
            case "ZA" :
                convertedCountry = "South Africa";
                break;
            case "BS" :
                convertedCountry = "Bahamas";
                break;
            default:
                convertedCountry = "Unknown Country";
                break;
        }


        return convertedCountry;
    }


    public static String getGender(String genderID)
    {
        String gender = "";

        switch (genderID)
        {
            case "0" : gender = "Male";break;
            case "1" : gender = "Female";break;
            case "2" : gender = "Other";break;
        }

        return gender;
    }

    /*  Expected : 28/05/2024 --> Excel --> dd/MM/yyyy
        Actual   : 2024-05-28 --> Database
        */

    public static String convertDate(String dbDate) throws ParseException //yyyy-MM-dd
    {
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dbDate);

        return  new SimpleDateFormat("dd/MM/yyyy").format(date);
    }
}
