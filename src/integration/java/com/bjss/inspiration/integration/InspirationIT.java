package com.bjss.inspiration.integration;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/integration/resources/features")
public class InspirationIT {
    // No Content - marker class for Cucumber annotations
}
