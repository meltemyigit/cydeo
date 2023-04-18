package com.cydeo.utilities;

/*
In this class only general utility methods that are NOT related to some specific page.
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

public class BrowserUtils {

    /*
    This method will accept int (in seconds) and execute Thread.sleep
    for given duration
     */
    public static void sleep(int second) {
        second *= 1000;
        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {

        }
    }

    /*
    This method accepts 3 arguments.
    Arg1: webdriver
    Arg2: expectedInUrl : for verify if the url contains given String.
        - If condition matches, will break loop.
    Arg3: expectedInTitle to be compared against actualTitle
     */
    public static void switchWindowAndVerify( String expectedInUrl, String expectedInTitle) {

        Set<String> allWindowsHandles = Driver.getDriver().getWindowHandles();

        for (String each : allWindowsHandles) {

            Driver.getDriver().switchTo().window(each);

            System.out.println("Current URL: " + Driver.getDriver().getCurrentUrl());

            if (Driver.getDriver().getCurrentUrl().contains(expectedInUrl)) {
                break;
            }
        }

        //5. Assert:Title contains “expectedInTitle”
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedInTitle));
    }

    /*
    This method accepts a String "expectedTitle" and Asserts if it is true
     */
    public static void verifyTitle( String expectedTitle) {

        Assert.assertEquals(Driver.getDriver().getTitle(), expectedTitle);

    }

    /*
    Creating a utility method for ExplicitWait, so we don't have to repeat the lines
     */

    public static void verifyCurrentContain( String expectedTitleContain) {
       Driver.getDriver().getCurrentUrl().contains(expectedTitleContain);

    }

    public static List<String> dropdownOptionsAsString(WebElement dropdownElement){
        Select select = new Select(dropdownElement);
        List<WebElement> monthsbrowser = select.getOptions();
        List<String> monthsbrowserString = new ArrayList<>();
        for(WebElement each :monthsbrowser) {
            monthsbrowserString.add(each.getText());
        }

        return monthsbrowserString;
    }

    public class Main {
        public static void main(String[] args) {
            for (int i = 0; i < 100; i++) {
                System.out.println(randomDOB());
            }
        }

        public static String randomDOB() {

            int yyyy = random(1900, 2013);
            int mm = random(1, 12);
            int dd = 0; // will set it later depending on year and month

            switch(mm) {
                case 2:
                    if (isLeapYear(yyyy)) {
                        dd = random(1, 29);
                    } else {
                        dd = random(1, 28);
                    }
                    break;

                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    dd = random(1, 31);
                    break;

                default:
                    dd = random(1, 30);
                    break;
            }

            String year = Integer.toString(yyyy);
            String month = Integer.toString(mm);
            String day = Integer.toString(dd);

            if (mm < 10) {
                month = "0" + mm;
            }

            if (dd < 10) {
                day = "0" + dd;
            }

            return month + '/' + day + '/' + year;
        }

        public static int random(int lowerBound, int upperBound) {
            return (lowerBound + (int) Math.round(Math.random()
                    * (upperBound - lowerBound)));
        }

        public static boolean isLeapYear(int year) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, year);
            int noOfDays = calendar.getActualMaximum(Calendar.DAY_OF_YEAR);

            if (noOfDays > 365) {
                return true;
            }

            return false;
        }
    }



}



