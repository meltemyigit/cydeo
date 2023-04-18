package com.cydeo.step_definitions;

import com.cydeo.pages.DashboardPage;
import com.cydeo.pages.FleetGruLoginPage;
import com.cydeo.pages.QuickLaunchpadPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class FleetGruLogin_StepDefinitions {
    FleetGruLoginPage fleetGruLoginPage;
    QuickLaunchpadPage quickLaunchpadPage;
    DashboardPage dashboardPage;

    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        fleetGruLoginPage = new FleetGruLoginPage();
        quickLaunchpadPage = new QuickLaunchpadPage();
        dashboardPage = new DashboardPage();
    }



    @When("The user logs in as a store manager")
    public void theUserLogsInAsAStoreManager() {
        fleetGruLoginPage.username.sendKeys("storemanager51");
        fleetGruLoginPage.password.sendKeys("UserUser123");
        fleetGruLoginPage.loginbutton.click();

    }

    @When("The user logs in as a sales manager")
    public void theUserLogsInAsASalesManager() {
        fleetGruLoginPage.username.sendKeys("salesmanager101");
        fleetGruLoginPage.password.sendKeys("UserUser123");
        fleetGruLoginPage.loginbutton.click();

    }

    @When("The user logs in as a driver")
    public void theUserLogsInAsADriver() {
        fleetGruLoginPage.username.sendKeys("user1");
        fleetGruLoginPage.password.sendKeys("UserUser123");
        fleetGruLoginPage.loginbutton.click();

    }
    @Then("The user is on the Dashboard page")
    public void theUserIsOnTheDashboardPage() {
        Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait webDriverWait = new WebDriverWait(Driver.getDriver(), 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(dashboardPage.title));
        String expectedTitle = "Dashboard";
        String actualTitle = dashboardPage.title.getText();
        System.out.println(actualTitle);
        Assert.assertEquals(actualTitle, expectedTitle);


    }
    @Then("The user is on the Quick Launchpad page")
    public void the_user_is_on_the_quick_launchpad_page() {
        Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait webDriverWait = new WebDriverWait(Driver.getDriver(), 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(quickLaunchpadPage.title));
        String expectedTitle = "Quick Launchpad";
        String actualTitle = quickLaunchpadPage.title.getText();
        //System.out.println(actualTitle);
        Assert.assertEquals(actualTitle, expectedTitle);
        Driver.closeDriver();

    }

    @When("The user enter invalid username and valid password")
    public void theUserEnterInvalidUsernameAndValidPassword() {
        Faker faker = new Faker();
        fleetGruLoginPage.username.sendKeys(faker.name().fullName());
        fleetGruLoginPage.password.sendKeys("UserUser123");
        fleetGruLoginPage.loginbutton.click();

    }

    @Then("The user see Invalid user name or password error message")
    public void theUserSeeInvalidUserNameOrPasswordErrorMessage() {
        String expectedTitle = "Invalid user name or password.";
        String actualTitle = fleetGruLoginPage.invalidusernameorpassworderrormessage.getText();
        System.out.println(actualTitle);
        Assert.assertEquals(actualTitle, expectedTitle);

    }

    @When("The user enter valid username and invalid password")
    public void theUserEnterValidUsernameAndInvalidPassword() {
        Faker faker = new Faker();
        fleetGruLoginPage.username.sendKeys("user1");
        fleetGruLoginPage.password.sendKeys(faker.bothify("????-########"));
        fleetGruLoginPage.loginbutton.click();

    }

    @When("The user enter empty username and random password")
    public void theUserEnterEmptyUsernameAndRandomPassword() {
        fleetGruLoginPage.username.sendKeys("");
        fleetGruLoginPage.password.sendKeys("UserUser123");
        fleetGruLoginPage.loginbutton.click();
    }

    @Then("The user see Lütfen bu alanı doldurun error message")
    public void theUserSeeLütfenBuAlanıDoldurunErrorMessage() throws InterruptedException {
        Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        //Thread.sleep(20000);
        Assert.assertTrue(FleetGruLoginPage.popUpMessage("Lütfen bu alanı doldurun."));


    }


    @When("The user enter random username and empty password")
    public void theUserEnterRandomUsernameAndEmptyPassword() {
        fleetGruLoginPage.username.sendKeys("user1");
        fleetGruLoginPage.password.sendKeys("");
        fleetGruLoginPage.loginbutton.click();
    }

    @When("The user enter empty username and empty password")
    public void theUserEnterEmptyUsernameAndEmptyPassword() {
        fleetGruLoginPage.username.sendKeys("");
        fleetGruLoginPage.password.sendKeys("");
        fleetGruLoginPage.loginbutton.click();
    }

    @When("The user click Forgot your password? link")
    public void theUserClickForgotYourPasswordLink() {
        fleetGruLoginPage.forgotyourpasswordlink.click();

    }

    @Then("The user see Forgot Password page")
    public void theUserSeeForgotPasswordPage() throws InterruptedException {
        Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        //Thread.sleep(20000);
        String expectedTitle = "Forgot Password";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        Driver.closeDriver();

    }

    @Then("The user see Forgot Remember me on this computer link")
    public void theUserSeeForgotRememberMeOnThisComputerLink() {
        Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        //Thread.sleep(20000);
        String expectedTitle = "Remember me on this computer";
        String actualTitle = fleetGruLoginPage.remembermeonthiscomputer.getText();
        Assert.assertEquals(actualTitle, expectedTitle);


    }

    @When("The user see Remember me on this computer link is clickable")
    public void theUserClickRememberMeOnThisComputerLink() {
        fleetGruLoginPage.checkboxbutton.isEnabled();
    }

    @When("User type the password")
    public void userTypeThePassword() {
        Faker faker = new Faker();
        FleetGruLoginPage.password.sendKeys(faker.bothify("?******?????"));
    }

    @Then("User see the password in bullet signs by default")
    public void userSeeThePasswordInBulletSignsByDefaultLike() {
        FleetGruLoginPage.password.getAttribute("type").equals("password");

    }


    @When("User press enter key of the keyboard")
    public void userPressEnterKeyOfTheKeyboard() {
        fleetGruLoginPage.loginbutton.sendKeys(Keys.ENTER);
    }

    @Then("User see enter key is working")
    public void userSeeEnterKeyIsWorking() {
        Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        Assert.assertTrue(FleetGruLoginPage.popUpMessage("Lütfen bu alanı doldurun."));
        Driver.closeDriver();

    }


    @When("User enter valid username and valid password and click")
    public void userEnterValidUsernameAndValidPasswordAndClick() {
        fleetGruLoginPage.username.sendKeys("user1");
        fleetGruLoginPage.password.sendKeys("UserUser123");
        fleetGruLoginPage.loginbutton.click();
        BrowserUtils.sleep(5);
    }

    @Then("User see own username in the profile menu")
    public void userSeeOwnUsernameInTheProfileMenu() {
        String actualvalue = fleetGruLoginPage.ownusername.getText();
        String expectedvalue = "user1";
        Assert.assertEquals(actualvalue,expectedvalue);

    }
}