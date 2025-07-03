package com.solvd.selenium.pages.android;

import org.openqa.selenium.WebDriver;

import com.solvd.selenium.pages.common.CategoryPageBase;
import com.solvd.selenium.pages.common.ProductPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CategoryPageBase.class)
public class CategoryPage extends CategoryPageBase {

    public CategoryPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ProductPageBase clickFirstProduct() {
        // TODO: implement logic
        return null;
    }

    @Override
    public String getPageTitle() {
        // TODO: implement logic
        return null;
    }

    @Override
    public boolean areProductsVisible() {
        // TODO: implement logic
        return false;
    }

    @Override
    public boolean areFiltersVisible() {
        // TODO: implement logic
        return false;
    }

    @Override
    public boolean isSortingVisible() {
        // TODO: implement logic
        return false;
    }
}
