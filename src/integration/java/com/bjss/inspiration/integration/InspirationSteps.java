package com.bjss.inspiration.integration;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Ignore;

import static org.assertj.core.api.Assertions.assertThat;

@Ignore
public class InspirationSteps extends com.bjss.inspiration.integration.SpringBootCucumberIntegration {

    @Given("^I select the home page$")
    public void lookingAtHomePage() {
        setEndpointPath("/inspire");
    }

    @Given("^I click for inspiration$")
    public void requestInspirationalQuote() {
        setEndpointPath("/api/quote");
    }

    @When("^I view the content$")
    public void fetchHomePageContent() {
        requestHomePageHtml();
    }

    @When("^The inspiration is fetched$")
    public void requestQuote() {
        requestQuoteFromApi();
    }

    @Then("^An HTTP 200 OK is received from the Quote API$")
    public void receivesHttpOkStatusFromQuoteApi() {
        assertThat(getQuoteStatus()).isEqualTo(200);
    }

    @Then("^The quote has valid characters$")
    public void assertQuoteContainsValidCharacters() {
        String quoteText = getQuote().getText();
        assertThat(quoteText.length()).isGreaterThanOrEqualTo(5);
        assertThat(quoteText).containsPattern("[a-z|A-Z|\\s]+");
    }

    @Then("^An HTTP 200 OK is received$")
    public void receivesHttpOkStatus() {
        assertThat(getHomePageStatus()).isEqualTo(200);
    }

    @Then("^The page contains \"([^\"]*)\"$")
    public void quoteContainsText(String expectedText) {
        assertThat(getHomePageContent()).contains(expectedText);
    }
}
