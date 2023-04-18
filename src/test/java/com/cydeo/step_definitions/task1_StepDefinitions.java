package com.cydeo.step_definitions;

import com.cydeo.pages.Task1Page;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;



public class task1_StepDefinitions {

    Task1Page task1Page = new Task1Page();
    @When("User is on Google search page")
    public void user_is_on_google_search_page() {
        String envType = ConfigurationReader.getProperty("envtask1");
        Driver.getDriver().get(envType);
    }
    @When("User types apple in the google search box and clicks enter")
    public void user_types_apple_in_the_google_search_box_and_clicks_enter() {
        task1Page.googlesearchButton.sendKeys("Apple", Keys.ENTER);

    }
    @Then("User sees Steve Jobs is in the google title")
    public void user_sees_steve_jobs_is_in_the_google_title() {
     String actualValue = Driver.getDriver().getTitle();
     String expectedValue = "Steve Jobs";
        Assert.assertEquals(expectedValue,actualValue);
    }

}
