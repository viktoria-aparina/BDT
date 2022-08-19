package by.teachmeskills.steps;

import com.codeborne.selenide.ElementsCollection;
import dto.Characteristics;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.OnlinerSearchPage;

import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Selenide.getWebDriverLogs;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class OnlinerSearchSteps {

    OnlinerSearchPage searchPage = new OnlinerSearchPage();

    @Given("User is on {string} page")
    public void userIsOnPage(String pageAddress) {
        open(pageAddress);
    }

    @And("The browser is maximized")
    public void theBrowserIsMaximized() {
        getWebDriver().manage().window().maximize();
    }

    @DataTableType
    public Characteristics characteristic(Map<String, String> entry) {
        return new Characteristics(entry.get("OS"),
                                   entry.get("SCREEN"),
                                   entry.get("CAMERA"),
                                   entry.get("SIM NUMBER"));
    }

    @When("User searches for {string}")
    public void userSearchesFor(String searchText) {
        searchPage.searchInCatalog(searchText);
    }

    @Then("{string} is the first search result")
    public void isTheFirstSearchResult(String searchResultTitle) {
        ElementsCollection productTitles = searchPage.getSearchResultProductTitles();
        String actualTitle = productTitles.first().getText();
        assertThat(actualTitle).as("The first search result in incorrect").contains(searchResultTitle);
    }

    @And("Search result contains the next characteristics")
    public void searchResultContainsTheNextCharacteristics(Characteristics characteristics) {
        ElementsCollection productDetails = searchPage.getSearchResultProductDetails();
        String actualDescription = productDetails.first().getText();
        assertThat(actualDescription).as("The OS platform is invalid in description").contains(characteristics.getOs());
        assertThat(actualDescription).as("The Screen platform is invalid in description").contains(characteristics.getScreen());
        assertThat(actualDescription).as("The Camera platform is invalid in description").contains(characteristics.getCamera());
        assertThat(actualDescription).as("The SIM number platform is invalid in description").contains(characteristics.getSimNumber());
    }
}


