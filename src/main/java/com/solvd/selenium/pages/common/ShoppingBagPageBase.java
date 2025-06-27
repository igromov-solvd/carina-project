package com.solvd.selenium.pages.common;

import org.openqa.selenium.WebDriver;
import com.zebrunner.carina.webdriver.gui.AbstractPage;

public abstract class ShoppingBagPageBase extends AbstractPage {

    public ShoppingBagPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isFirstBagItemVisible();

    public abstract boolean isFirstBagItemPriceVisible();

    public abstract boolean isFirstBagItemQuantityVisible();

    public abstract boolean isFirstBagItemRemoveButtonVisible();

    public abstract void clickFirstBagItemRemoveButton();

    public abstract boolean isEmptyBagMessageVisible();

    public abstract String getEmptyBagMessageText();

    public abstract boolean isContinueShoppingVisible();

    public abstract void clickContinueShopping();

    public abstract int getQuantity();

    public abstract void clickOnQuantityCountPlus();

    public abstract double getProductPrice();

    public abstract void waitForTotalPriceChanged(Double expectedNewValue);
}
