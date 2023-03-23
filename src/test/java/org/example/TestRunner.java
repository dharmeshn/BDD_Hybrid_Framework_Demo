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
                plugin = {"pretty", "json:target/cucumber-reports/cucumber.json",
                                    "html:target/cucumber-reports/cucumber-reports.html"},
                publish = true
                )

public class TestRunner {

}
