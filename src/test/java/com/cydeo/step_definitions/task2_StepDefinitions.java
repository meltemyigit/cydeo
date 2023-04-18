package com.cydeo.step_definitions;

import com.cydeo.pages.Task2Page;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class task2_StepDefinitions {
    Task2Page task2Page = new Task2Page();
    @When("User is on Wikipedia home page")
    public void user_is_on_wikipedia_home_page() {
        String envType = ConfigurationReader.getProperty("envtask2");
        Driver.getDriver().get(envType);

    }

    @And("User types {string} in the wiki search box and clicks wiki search button")
    public void userTypesInTheWikiSearchBoxAndClicksWikiSearchButton(String string) {

        task2Page.wikisearchBox.sendKeys(string);
        task2Page.wikisearchButton.click();
    }

    @Then("User sees {string} is in the wiki title")
    public void userSeesIsInTheWikiTitle(String string) {
        String  actualValue = Driver.getDriver().getTitle();
        String  expectedValue = string + " - Vikipedi";
        Assert.assertEquals(expectedValue,actualValue);
    }

    @Then("User sees {string} is in the main header")
    public void userSeesIsInTheMainHeader(String string) {
       Assert.assertTrue(task2Page.mainHeader.getText().equals(string));

    }

    @Then("User sees {string} is in the image header")
    public void userSeesIsInTheImageHeader(String string) {
        Assert.assertTrue(task2Page.imageHeader.getText().equals(string));

    }
}
