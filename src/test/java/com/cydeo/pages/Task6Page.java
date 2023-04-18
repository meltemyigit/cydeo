package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Task6Page {

    public Task6Page() {
        /*initElements method will create connection in between the current
        driver session (instance) and the object of the current class.
         */
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//select [@id = 'month']")
    public WebElement monthsdropdownbrowser;
}
