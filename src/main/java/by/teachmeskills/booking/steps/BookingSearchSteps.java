package by.teachmeskills.booking.steps;

import by.teachmeskills.booking.dto.Hotel;
import by.teachmeskills.booking.pages.BookingSearchPage;
import by.teachmeskills.onliner.dto.Characteristics;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class BookingSearchSteps {

    BookingSearchPage searchPage = new BookingSearchPage();

    @Given("User is on {string} page")
    public void userIsOnPage(String pageAddress) {
        open(pageAddress);
    }

    @And("The browser is maximized")
    public void theBrowserIsMaximized() {
        getWebDriver().manage().window().maximize();
    }

    @When("User searches for {string} and {string}")
    public void userSearchFor(String hotel, String city) {
        searchPage.search(hotel, city);
    }

    @Then("{string} exists on the Search page")
    public void existsOnTheSearchPage(String hotel) {
        ElementsCollection hotelTitle = searchPage.getSearchResultTitle();
        String actualTitle = hotelTitle.first().getText();
        assertThat(actualTitle).as("The first search result is incorrect").contains(hotel);
    }

    @Then("Search result contains the {string} equals to")
    public void searchResultContains(String rating) {
        ElementsCollection hotelRatings = searchPage.getSearchResultRating();
        String actualRating = hotelRatings.first().getText();
        assertThat(actualRating).as("The rating is incorrect").isEqualTo(rating);
    }
}
