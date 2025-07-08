package com.solvd.selenium.pages.common;

import org.openqa.selenium.WebDriver;
import com.zebrunner.carina.webdriver.gui.AbstractPage;

public abstract class ShoppingBagPageBase extends AbstractPage {

    public ShoppingBagPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isFirstItemPresent();

    public abstract boolean isFirstItemPricePresent();

    public abstract boolean isFirstItemQuantityPresent();

    public abstract boolean isFirstItemRemoveButtonPresent();

    public abstract void clickFirstItemRemoveButton();

    public abstract boolean isEmptyBagMessagePresent();

    public abstract String getEmptyBagMessageText();

    public abstract boolean isContinueShoppingButtonPresent();

    public abstract void clickContinueShopping();

    public abstract int getQuantity();

    public abstract void clickOnQuantityCountPlus();

    public abstract double getProductPrice();

    public abstract void waitForTotalPriceChanged(Double expectedNewValue);
}
