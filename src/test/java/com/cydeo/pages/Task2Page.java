package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Task2Page {
    public Task2Page(){
        /*initElements method will create connection in between the current
        driver session (instance) and the object of the current class.
         */
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//input [@accesskey = 'f']")
    public WebElement wikisearchBox;

    @FindBy(xpath = "//button [@class = 'cdx-button cdx-button--action-default cdx-button--weight-normal cdx-button--framed cdx-search-input__end-button']")
    public WebElement wikisearchButton;


    @FindBy(xpath = "//span [@class = 'mw-page-title-main']")
    public WebElement mainHeader;


    @FindBy(xpath = "//div [@class = 'fn']")
    public WebElement imageHeader;
}

