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
    public boolean isDeliveryTitlePresent() {
        // TODO: implement logic
        return false;
    }

    @Override
    public String getDeliveryTitleText() {
        // TODO: implement logic
        return null;
    }

    @Override
    public boolean isStoreLocatorPresent() {
        // TODO: implement logic
        return false;
    }

    @Override
    public boolean isHelpLinkPresent() {
        // TODO: implement logic
        return false;
    }

    @Override
    public boolean isLogoPresent() {
        // TODO: implement logic
        return false;
    }

    @Override
    public boolean isSearchBarPresent() {
        // TODO: implement logic
        return false;
    }

    @Override
    public boolean isAccountIconPresent() {
        // TODO: implement logic
        return false;
    }

    @Override
    public boolean isFavoritesIconPresent() {
        // TODO: implement logic
        return false;
    }

    @Override
    public boolean isShoppingBagIconPresent() {
        // TODO: implement logic
        return false;
    }

    @Override
    public boolean isCheckoutButtonPresent() {
        // TODO: implement logic
        return false;
    }

    @Override
    public boolean areAllMainMenuItemsPresent() {
        // TODO: implement logic
        return false;
    }

    @Override
    public List<String> getMainMenuCategoriesList() {
        // TODO: implement logic
        return null;
    }

}
