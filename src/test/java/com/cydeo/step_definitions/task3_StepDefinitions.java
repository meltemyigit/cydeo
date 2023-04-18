package com.cydeo.step_definitions;

import com.cydeo.pages.Task3Page;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;


public class task3_StepDefinitions {

    Task3Page task3Page = new Task3Page();

    @When("User is on the login page of Web table app")
    public void user_is_on_the_login_page_of_web_table_app() {
        String envType = ConfigurationReader.getProperty("envtask3");
        Driver.getDriver().get(envType);
    }



    @Then("User should see url contains orders")
    public void user_should_see_url_contains_orders() {
        BrowserUtils.verifyCurrentContain("orders");

    }

    @When("User enters below credentials")
    public void userEntersBelowCredentials(Map<String,String> credentials ) {
        System.out.println(credentials.get("username"));
        task3Page.usernamesearchBox.sendKeys(credentials.get("username"));
        task3Page.passwordBox.sendKeys(credentials.get("password"));
        BrowserUtils.sleep(2);
        task3Page.loginButton.click();
    }
}

