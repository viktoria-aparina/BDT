package by.teachmeskills.booking.pages;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class BookingSearchPage {

    public void search(String hotel, String city) {
        $x("//input[@name='ss']").sendKeys(hotel + " " + city);
        ElementsCollection hotels = $$x("//div[@data-testid='autocomplete-result']");
        hotels.first().click();
        $x("//span[text()='Search']").click();
    }

    public ElementsCollection getSearchResultTitle() {
        return $$x("//div[@data-testid='title']");
    }

    public ElementsCollection getSearchResultRating() {
        return $$x("//div[contains(@aria-label, 'Scored')]");
    }
}
