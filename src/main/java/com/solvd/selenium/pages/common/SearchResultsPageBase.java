package com.solvd.selenium.pages.common;

import java.util.List;

import org.openqa.selenium.WebDriver;
import com.zebrunner.carina.webdriver.gui.AbstractPage;

public abstract class SearchResultsPageBase extends AbstractPage {

    public SearchResultsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract List<String> getProductTitles();

    public abstract void printAllProductTitles();

    public abstract int getProductCount();

    public abstract String getPageTitleText();

    public abstract boolean areFiltersPresent();

    public abstract boolean isSortingPresent();

    public abstract boolean areProductPricesPresent();

    public abstract boolean areProductImagesPresent();
}
