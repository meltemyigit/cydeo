package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FleetGruLogoutPage {
    public FleetGruLogoutPage(){
        /*initElements method will create connection in between the current
        driver session (instance) and the object of the current class.
         */
        PageFactory.initElements(Driver.getDriver(), this);
    }
    //#2- use @FindBy annotation to locate web elements


    @FindBy(xpath = "//*[@id='user-menu']/a")
    public static WebElement usernameintheprofilemenu;

    @FindBy(xpath = "//*[@id='user-menu']/ul/li[4]/a")
    public static WebElement logoutbutton;


}

