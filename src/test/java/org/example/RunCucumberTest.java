package org.example;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
                features = ".",
                dryRun = false,
                monochrome = true,
                tags = "@login",
                plugin = {"pretty", "json:target/CucumberTestReport.json",
                                    "html:target/CucumberTestReport.html"},
                publish = true
                )

public class RunCucumberTest {

}
