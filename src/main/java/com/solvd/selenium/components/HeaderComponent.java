package com.solvd.selenium.components;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.solvd.selenium.pages.common.CategoryPageBase;
import com.solvd.selenium.pages.common.SearchResultsPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;

public class HeaderComponent extends AbstractUIObject {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(css = "input#header-big-screen-search-box")
    private ExtendedWebElement searchInput;

    @FindBy(css = "button[data-testid='header-search-bar-button']")
    private ExtendedWebElement searchButton;

    @FindBy(css = "a[href='/delivery-service-local-store'] > span")
    private ExtendedWebElement deliveryTitle;

    @FindBy(css = "a[href$='/storelocator']")
    private ExtendedWebElement storeLocatorLink;

    @FindBy(css = "a[href$='/help']")
    private ExtendedWebElement helpLink;

    @FindBy(css = "div[data-testid='header-adaptive-brand']")
    private ExtendedWebElement logo;

    @FindBy(css = "div[data-testid='header-big-screen-search']")
    private ExtendedWebElement searchBar;

    @FindBy(css = "div[data-testid='header-adaptive-my-account']")
    private ExtendedWebElement accountIcon;

    @FindBy(css = "div[data-testid='header-favourites']")
    private ExtendedWebElement favoritesIcon;

    @FindBy(css = "div[data-testid='header-shopping-bag']")
    private ExtendedWebElement shoppingBagIcon;

    @FindBy(css = "div[data-testid='header-adaptive-checkout']")
    private ExtendedWebElement checkoutButton;

    @FindBy(css = "ul[data-testid='snail-trail-container'] > li:not([style*='none']):not(.hideWideView)")
    private List<ExtendedWebElement> mainMenuItems;

    @FindBy(css = "a[title='%s']")
    private ExtendedWebElement subCategoryElement;

    public HeaderComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public SearchResultsPageBase clickSearchButton() {
        searchButton.click();
        return initPage(getDriver(), SearchResultsPageBase.class);
    }

    public SearchResultsPageBase searchForProduct(String searchText) {
        searchInput.type(searchText);
        LOGGER.info("Searching for product: {}", searchText);
        return clickSearchButton();
    }

    public CategoryPageBase hoverOverMainCategoryAndClick(String category, String subCategory) {
        LOGGER.info("Hovering over category: {} and clicking sub-category: {}", category, subCategory);

        // Find the category element
        ExtendedWebElement categoryElement = mainMenuItems.stream()
                .filter(item -> item.getText().equalsIgnoreCase(category))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Category not found: " + category));
        LOGGER.info("Found category: {}", categoryElement.getText());

        categoryElement.hover();
        subCategoryElement.format(subCategory).click();

        return initPage(getDriver(), CategoryPageBase.class);
    }

    public boolean isDeliveryTitlePresent() {
        return deliveryTitle.isElementPresent();
    }

    public String getDeliveryTitleText() {
        return deliveryTitle.getText();
    }

    public boolean isStoreLocatorPresent() {
        return storeLocatorLink.isElementPresent();
    }

    public boolean isHelpLinkPresent() {
        return helpLink.isElementPresent();
    }

    public boolean isLogoPresent() {
        return logo.isElementPresent();
    }

    public boolean isSearchBarPresent() {
        return searchBar.isElementPresent();
    }

    public boolean isAccountIconPresent() {
        return accountIcon.isElementPresent();
    }

    public boolean isFavoritesIconPresent() {
        return favoritesIcon.isElementPresent();
    }

    public boolean isShoppingBagIconPresent() {
        return shoppingBagIcon.isElementPresent();
    }

    public boolean isCheckoutButtonPresent() {
        return checkoutButton.isElementPresent();
    }

    public boolean areAllMainMenuItemsPresent() {
        if (mainMenuItems.isEmpty()) {
            return false;
        }
        for (ExtendedWebElement item : mainMenuItems) {
            if (!item.isElementPresent()) {
                return false;
            }
        }
        return true;
    }

    public List<String> getMainMenuCategoriesList() {
        List<String> actualCategories = new ArrayList<>();
        for (ExtendedWebElement item : mainMenuItems) {
            actualCategories.add(item.getText());
        }
        return actualCategories;
    }

}
