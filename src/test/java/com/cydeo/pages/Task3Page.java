package com.cydeo.pages;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Task3Page {
    public Task3Page(){
        /*initElements method will create connection in between the current
        driver session (instance) and the object of the current class.
         */
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@name = 'username']")
    public WebElement usernamesearchBox;

    @FindBy(xpath = "//input [@name = 'password']")
    public WebElement passwordBox;

    @FindBy(xpath = "//button [@class = 'btn btn-primary login__submit']")
    public WebElement loginButton;




    @FindBy(xpath = "//button [.='Order']")
    public WebElement order;


    public void product(){
        Select s = new Select(Driver.getDriver().findElement(By.xpath("//select [@name ='product']")));
        Faker faker = new Faker();
        s.selectByIndex(faker.number().numberBetween(1,3));

    }


    @FindBy(xpath = "")
    public WebElement quantity;

    @FindBy(xpath = "//input [@placeholder='Full name of the customer']")
    public WebElement customerName;

    @FindBy(xpath = "//input [@placeholder='Street address of the customer']")
    public WebElement street;

    @FindBy(xpath = "//input [@placeholder='City where the customer lives']")
    public WebElement city;

    @FindBy(xpath = "")
    public WebElement state;

    @FindBy(xpath = "")
    public WebElement zip;

    @FindBy(xpath = "//input [@value='MasterCard']")
    public WebElement card;

    @FindBy(xpath = "//input [@placeholder='The number on the card']")
    public WebElement cardNo;

    @FindBy(xpath = "//input [@placeholder='e.g. 04/24']")
    public WebElement expireDate;

    @FindBy(xpath = "//button[.='Process Order']")
    public WebElement processOrder;


    @FindBy(xpath = " //table [@class='table is-fullwidth']/tbody//tr['Meltem']")
    public WebElement verify;
}

