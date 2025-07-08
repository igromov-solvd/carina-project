package com.solvd.selenium.pages.common;

import org.openqa.selenium.WebDriver;
import com.zebrunner.carina.webdriver.gui.AbstractPage;

public abstract class ProductPageBase extends AbstractPage {

    public ProductPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract ShoppingBagPageBase clickViewBagButton();

    public abstract void selectFirstAvailableSize();

    public abstract boolean isAddToBagConfirmationPresent();

    public abstract boolean isProductNamePresent();

    public abstract boolean isProductPricePresent();

    public abstract boolean isProductDescriptionPresent();

    public abstract boolean areAllProductImagesPresent();

    public abstract boolean isSizeSelectorPresent();

    public abstract boolean isColorSelectorPresent();

    public abstract boolean isAddToBagButtonPresent();

    public abstract boolean isFavouriteButtonPresent();

    public abstract boolean isReviewsSectionPresent();

    public abstract void clickAddToBag();

    public abstract boolean isCheckoutButtonPresent();

    public abstract void clickCheckoutButton();
}
