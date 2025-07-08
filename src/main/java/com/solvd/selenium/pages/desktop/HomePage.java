package com.solvd.selenium.pages.desktop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.solvd.selenium.pages.common.CategoryPageBase;
import com.solvd.selenium.pages.common.HomePageBase;
import com.solvd.selenium.pages.common.SearchResultsPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

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

    @FindBy(css = "a[title='All Dresses']")
    private ExtendedWebElement allDressesLink;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public SearchResultsPageBase clickSearchButton() {
        searchButton.click();
        return initPage(getDriver(), SearchResultsPageBase.class);
    }

    @Override
    public SearchResultsPageBase searchForProduct(String searchText) {
        searchInput.type(searchText);
        LOGGER.info("Searching for product: {}", searchText);
        return clickSearchButton();
    }

    @Override
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

    @Override
    public boolean isDeliveryTitlePresent() {
        return deliveryTitle.isElementPresent();
    }

    @Override
    public String getDeliveryTitleText() {
        return deliveryTitle.getText();
    }

    @Override
    public boolean isStoreLocatorPresent() {
        return storeLocatorLink.isElementPresent();
    }

    @Override
    public boolean isHelpLinkPresent() {
        return helpLink.isElementPresent();
    }

    @Override
    public boolean isLogoPresent() {
        return logo.isElementPresent();
    }

    @Override
    public boolean isSearchBarPresent() {
        return searchBar.isElementPresent();
    }

    @Override
    public boolean isAccountIconPresent() {
        return accountIcon.isElementPresent();
    }

    @Override
    public boolean isFavoritesIconPresent() {
        return favoritesIcon.isElementPresent();
    }

    @Override
    public boolean isShoppingBagIconPresent() {
        return shoppingBagIcon.isElementPresent();
    }

    @Override
    public boolean isCheckoutButtonPresent() {
        return checkoutButton.isElementPresent();
    }

    @Override
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

    @Override
    public List<String> getMainMenuCategoriesList() {
        List<String> actualCategories = new ArrayList<>();
        for (ExtendedWebElement item : mainMenuItems) {
            actualCategories.add(item.getText().toLowerCase());
        }
        return actualCategories;
    }
}