package com.solvd.selenium.pages.android;

import java.util.List;

import org.openqa.selenium.WebDriver;

import com.solvd.selenium.pages.common.CategoryPageBase;
import com.solvd.selenium.pages.common.HomePageBase;
import com.solvd.selenium.pages.common.SearchResultsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public SearchResultsPageBase clickSearchButton() {
        // TODO: implement logic
        return null;
    }

    @Override
    public SearchResultsPageBase searchForProduct(String searchText) {
        // TODO: implement logic
        return null;
    }

    @Override
    public CategoryPageBase hoverOverMainCategoryAndClick(String category, String subCategory) {
        // TODO: implement logic
        return null;
    }

    @Override
    public boolean isDeliveryTitleVisible() {
        // TODO: implement logic
        return false;
    }

    @Override
    public String getDeliveryTitleText() {
        // TODO: implement logic
        return null;
    }

    @Override
    public boolean isStoreLocatorVisible() {
        // TODO: implement logic
        return false;
    }

    @Override
    public boolean isHelpLinkVisible() {
        // TODO: implement logic
        return false;
    }

    @Override
    public boolean isLogoVisible() {
        // TODO: implement logic
        return false;
    }

    @Override
    public boolean isSearchBarVisible() {
        // TODO: implement logic
        return false;
    }

    @Override
    public boolean isAccountIconVisible() {
        // TODO: implement logic
        return false;
    }

    @Override
    public boolean isFavoritesIconVisible() {
        // TODO: implement logic
        return false;
    }

    @Override
    public boolean isShoppingBagIconVisible() {
        // TODO: implement logic
        return false;
    }

    @Override
    public boolean isCheckoutButtonVisible() {
        // TODO: implement logic
        return false;
    }

    @Override
    public boolean isMainMenuVisible() {
        // TODO: implement logic
        return false;
    }

    @Override
    public List<String> getMainMenuCategoriesList() {
        // TODO: implement logic
        return null;
    }

}
