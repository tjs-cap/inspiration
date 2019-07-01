package com.bjss.inspiration.integration;

import com.bjss.inspiration.domain.Quote;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Ignore;

import static org.assertj.core.api.Assertions.assertThat;

@Ignore
public class InspirationSteps extends SpringBootCucumberIntegration {

    @Given("^I select the home page$")
    public void lookingAtHomePage() throws Throwable {
        setEndpointPath("/inspire");
    }

    @When("^I view the content$")
    public void fetchHomePageContent() throws Throwable {
        requestHomePageHtml();
    }

    @Then("^An HTTP 200 OK is received$")
    public void receivesHttpOkStatus() {
        assertThat(getHomePageStatus()).isEqualTo(200);
    }

    @Then("^The page contains \"([^\"]*)\"$")
    public void quoteContainsText(String expectedText) throws Throwable {
        assertThat(getHomePageContent()).contains(expectedText);
    }
}
