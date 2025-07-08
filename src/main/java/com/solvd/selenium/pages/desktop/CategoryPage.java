package com.solvd.selenium.pages.desktop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.selenium.pages.common.CategoryPageBase;
import com.solvd.selenium.pages.common.ProductPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = CategoryPageBase.class)
public class CategoryPage extends CategoryPageBase {

    @FindBy(css = "div[data-testid='plp-product-title'] > div > h1")
    private ExtendedWebElement pageTitle;

    @FindBy(css = "div[data-testid='plp-product-grid-item']")
    private List<ExtendedWebElement> products;

    @FindBy(css = "div[data-testid='plp-desktop-sort-button']")
    private ExtendedWebElement sortingContainer;

    @FindBy(css = "header[data-testid='plp-filters-component-desktop']")
    private ExtendedWebElement filtersContainer;

    public CategoryPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ProductPageBase clickFirstProduct() {
        products.get(0).click();
        return initPage(getDriver(), ProductPageBase.class);
    }

    @Override
    public String getPageTitle() {
        return pageTitle.getText();
    }

    @Override
    public boolean areAllProductsPresent() {
        if (products.isEmpty()) {
            return false;
        }
        for (ExtendedWebElement product : products) {
            if (!product.isElementPresent()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean areFiltersVisible() {
        return filtersContainer.isVisible();
    }

    @Override
    public boolean isSortingVisible() {
        return sortingContainer.isVisible();
    }
}