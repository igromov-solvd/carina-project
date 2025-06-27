package com.solvd.selenium.pages.common;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;

public abstract class HomePageBase extends AbstractPage {

    @FindBy(css = "button#onetrust-accept-btn-handler")
    private ExtendedWebElement acceptCookiesButton;

    public HomePageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
    }

    @Override
    public void open() {
        super.open();
        acceptCookiesButton.clickIfPresent();
    }

    public abstract SearchResultsPageBase clickSearchButton();

    public abstract SearchResultsPageBase searchForProduct(String searchText);

    public abstract CategoryPageBase hoverOverMainCategoryAndClick(String category, String subCategory);

    public abstract boolean isDeliveryTitleVisible();

    public abstract String getDeliveryTitleText();

    public abstract boolean isStoreLocatorVisible();

    public abstract boolean isHelpLinkVisible();

    public abstract boolean isLogoVisible();

    public abstract boolean isSearchBarVisible();

    public abstract boolean isAccountIconVisible();

    public abstract boolean isFavoritesIconVisible();

    public abstract boolean isShoppingBagIconVisible();

    public abstract boolean isCheckoutButtonVisible();

    public abstract boolean isMainMenuVisible();

    public abstract List<String> getMainMenuCategoriesList();
}