package com.solvd.selenium.pages.android;

import java.util.List;

import org.openqa.selenium.WebDriver;

import com.solvd.selenium.pages.common.SearchResultsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SearchResultsPageBase.class)
public class SearchResultsPage extends SearchResultsPageBase {

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public List<String> getProductTitles() {
        // TODO: implement logic
        return null;
    }

    @Override
    public void printAllProductTitles() {
        // TODO: implement logic
    }

    @Override
    public int getProductCount() {
        // TODO: implement logic
        return 0;
    }

    @Override
    public String getPageTitleText() {
        // TODO: implement logic
        return null;
    }

    @Override
    public boolean areFiltersPresent() {
        // TODO: implement logic
        return false;
    }

    @Override
    public boolean isSortingPresent() {
        // TODO: implement logic
        return false;
    }

    @Override
    public boolean areProductPricesPresent() {
        // TODO: implement logic
        return false;
    }

    @Override
    public boolean areProductImagesPresent() {
        // TODO: implement logic
        return false;
    }

}
