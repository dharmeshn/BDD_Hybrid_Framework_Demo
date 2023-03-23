package org.example;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
                features = ".",
                dryRun = false,
                monochrome = true,
                tags = "@e2e",
                plugin = {"pretty", "html:target/cucumber-reports.html"},
                publish = true
                )

public class TestRunner {

}
