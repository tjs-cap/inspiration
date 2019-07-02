package com.bjss.inspiration.integration;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = "src/integration/java")
public class InspirationIT {
    // No Content - marker class for Cucumber annotations
}
