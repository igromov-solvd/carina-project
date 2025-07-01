package com.solvd.selenium.pages.common;

import org.openqa.selenium.WebDriver;
import com.zebrunner.carina.webdriver.gui.AbstractPage;

public abstract class ProductPageBase extends AbstractPage {

    public ProductPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract ShoppingBagPageBase clickViewBagButton();

    public abstract void selectFirstAvailableSize();

    public abstract boolean isAddToBagConfirmationVisible();

    public abstract boolean isProductNameVisible();

    public abstract boolean isProductPriceVisible();

    public abstract boolean isProductDescriptionVisible();

    public abstract boolean areProductImagesVisible();

    public abstract boolean isSizeSelectionVisible();

    public abstract boolean isColorSelectionVisible();

    public abstract boolean isAddToBagButtonVisible();

    public abstract boolean isFavouriteButtonVisible();

    public abstract boolean hasReviewsSection();

    public abstract void clickAddToBag();

    public abstract boolean isCheckoutButtonVisible();

    public abstract void clickCheckoutButton();
}
