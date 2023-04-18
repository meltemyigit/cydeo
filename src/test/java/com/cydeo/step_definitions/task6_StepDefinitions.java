package com.cydeo.step_definitions;

import com.cydeo.pages.Task6Page;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class task6_StepDefinitions {
    Task6Page task6Page = new Task6Page();

    @Given("User is on the dropdowns page of practice tool")
    public void user_is_on_the_dropdowns_page_of_practice_tool() {
        String envType = ConfigurationReader.getProperty("envtask4");
        Driver.getDriver().get(envType);
    }

    @Then("User should see below info in month dropdown")
    public void user_should_see_below_info_in_month_dropdown(List<String> expectedmonths) {

       Assert.assertEquals(expectedmonths,BrowserUtils.dropdownOptionsAsString(task6Page.monthsdropdownbrowser));
       BrowserUtils.sleep(2);
    }
}