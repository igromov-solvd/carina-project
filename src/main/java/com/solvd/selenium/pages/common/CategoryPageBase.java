package com.solvd.selenium.pages.common;

import org.openqa.selenium.WebDriver;
import com.zebrunner.carina.webdriver.gui.AbstractPage;

public abstract class CategoryPageBase extends AbstractPage {

    public CategoryPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract ProductPageBase clickFirstProduct();

    public abstract String getPageTitle();

    public abstract boolean areProductsVisible();

    public abstract boolean areFiltersVisible();

    public abstract boolean isSortingVisible();
}
