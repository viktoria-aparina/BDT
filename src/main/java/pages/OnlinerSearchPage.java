package pages;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.*;

public class OnlinerSearchPage {

    public void searchInCatalog(String searchText) {
        $(".fast-search__input").sendKeys(searchText);
    }

    public ElementsCollection getSearchResultProductTitles() {
        switchTo().frame($(".modal-iframe"));
        return $$(".result__item_product .product__title .product__title-link");
    }

    public ElementsCollection getSearchResultProductDetails() {
        return $$(".product__details .product__description");
    }
}

