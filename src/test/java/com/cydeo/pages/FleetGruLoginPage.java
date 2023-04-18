package com.cydeo.pages;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FleetGruLoginPage {

public FleetGruLoginPage(){
        /*initElements method will create connection in between the current
        driver session (instance) and the object of the current class.
         */
    PageFactory.initElements(Driver.getDriver(), this);
}
    //#2- use @FindBy annotation to locate web elements
    public static boolean  popUpMessage(String message) {
        boolean flag = false;
        if (username.getText().equals("")){
            if(username.getAttribute("validationMessage").equals(message)){
                flag = true;
            }
        }
        if(password.getText().equals("")){
            if(password.getAttribute("validationMessage").equals(message)){
                flag = true;
            }
        }
        return flag;
    }
    @FindBy(xpath = "//input [@name='_username']")
    public static WebElement username;

    @FindBy(xpath = "//input [@name='_password']")
    public static WebElement password;


    @FindBy(xpath = "//div [@class='form-signin__footer control-group form-row']/a")
    public  WebElement forgotyourpasswordlink;


    @FindBy(xpath = "//span [@class='custom-checkbox__text']")
    public  WebElement remembermeonthiscomputer;


    @FindBy(xpath = "//button [@id='_submit']")
    public static WebElement loginbutton;


    @FindBy(xpath = "//div [@class = 'alert alert-error']/div")
    public WebElement invalidusernameorpassworderrormessage;




    @FindBy(xpath = "//input [@type = 'checkbox']")
    public WebElement checkboxbutton;


    @FindBy(xpath = "(//a [@class='dropdown-toggle'])[1]")
    public WebElement ownusername ;

}

