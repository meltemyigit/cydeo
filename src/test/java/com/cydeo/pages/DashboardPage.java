package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

    public DashboardPage(){
        /*initElements method will create connection in between the current
        driver session (instance) and the object of the current class.
         */
        PageFactory.initElements(Driver.getDriver(), this);
    }
    //#2- use @FindBy annotation to locate web elements

    @FindBy(xpath = "//h1 [@class='oro-subtitle']")
    public WebElement title;
}
