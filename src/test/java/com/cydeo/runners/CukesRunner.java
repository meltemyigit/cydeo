package com.cydeo.runners;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin =
                {       "json:target/cucumber.json",
                        "html:target/cucumber/report.html",
                        "junit:target/junit/junit-report.xml",
                        "rerun:target/rerun.txt",
                        "me.jvt.cucumber.report.PrettyReports:target/cucumber"

                },


        features ="src/test/resources/features",
        glue     ="com/cydeo/step_definitions",
        dryRun = false,
        tags = "@FLEET10-1026"

)

public class CukesRunner {
}