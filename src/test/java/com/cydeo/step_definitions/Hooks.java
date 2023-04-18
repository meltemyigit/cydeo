package com.cydeo.step_definitions;

import com.cydeo.pages.DashboardPage;
import com.cydeo.pages.FleetGruLoginPage;
import com.cydeo.pages.QuickLaunchpadPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/*
In the class we will be able to pass pre & post conditions
to each scenario and each step
*/
public class Hooks {
    //import from io.cucumber.java not from junit

    @Before
    public void setupScenario(){
        String envType = ConfigurationReader.getProperty("env");
        Driver.getDriver().get(envType);

    }

    /*
    @After
    public void teardownScenario(){
        System.out.println("====Closing browser using cucumber @After");
        System.out.println("====Scenario ended/Take screenshot if failed");
    }
    @BeforeStep
    public void setupStep(){
        System.out.println("----------------------Applying setup using @BeforeStep");
    }
    @AfterStep
    public void teardownStep(){
        System.out.println("----------------------Applying teardown using @AfterStep");
    }
    */
    FleetGruLogin_StepDefinitions fleetGruLogin_StepDefinitions = new FleetGruLogin_StepDefinitions();

    @After
    public void teardownScenario(Scenario scenario) {

        //scenario.isFailed() --> if scenario fails this method will return TRUE boolean value

        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
    Driver.closeDriver();
    }

    }
