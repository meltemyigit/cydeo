package com.cydeo.step_definitions;

import com.cydeo.pages.DashboardPage;
import com.cydeo.pages.FleetGruLoginPage;
import com.cydeo.pages.FleetGruLogoutPage;
import com.cydeo.pages.QuickLaunchpadPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class FleetGruLogout_StepDefinitions {
    FleetGruLoginPage fleetGruLoginPage;
    QuickLaunchpadPage quickLaunchpadPage;
    DashboardPage dashboardPage;
    FleetGruLogoutPage fleetGruLogoutPage;

    @Given("User type valid username and valid password and click login button")
    public void user_type_valid_username_and_valid_password_and_click_login_button() {
        fleetGruLoginPage = new FleetGruLoginPage();
        quickLaunchpadPage = new QuickLaunchpadPage();
        dashboardPage = new DashboardPage();
        fleetGruLogoutPage = new FleetGruLogoutPage();

        String usernameType = ConfigurationReader.getProperty("driverusername");
        String passwordType = ConfigurationReader.getProperty("password");
        fleetGruLoginPage.username.sendKeys(usernameType);
        fleetGruLoginPage.password.sendKeys(passwordType);
        fleetGruLoginPage.loginbutton.click();
    }

    @When("The user click log out button")
    public void theUserClickLogOutButton() {
        Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait webDriverWait = new WebDriverWait(Driver.getDriver(), 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(quickLaunchpadPage.title));
        FleetGruLogoutPage.usernameintheprofilemenu.click();
        FleetGruLogoutPage.logoutbutton.click();


    }

    @Then("The user see login page")
    public void theUserSeeLoginPage() {
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://qa.fleetgru.com/user/login");
        BrowserUtils.sleep(5);
        Driver.closeDriver();

    }

    @And("The user click back button")
    public void theUserClickBackButton() {
        Driver.getDriver().navigate().back();
    }

    @When("The user close the all tab")
    public void theUserCloseTheAllTab() {
        JavascriptExecutor js=(JavascriptExecutor)Driver.getDriver();
        js.executeScript("window.open('https://qa.fleetgru.com/','_blank');");
        js.executeScript("window.open('https://qa.fleetgru.com/','_blank');");
        js.executeScript("window.open('https://qa.fleetgru.com/','_blank');");
        BrowserUtils.sleep(5);
        Driver.closeDriver();

    }

    @And("The user go to the login page")
    public void theUserGoToTheLoginPage() {
        String envType = ConfigurationReader.getProperty("env");
        Driver.getDriver().get(envType);
        BrowserUtils.sleep(5);
    }

    @When("The user wait three minutes without doing anything")
    public void theUserWaitThreeMinutesWithoutDoingAnything() {
        BrowserUtils.sleep(180);
    }
}
