package com.solvd.selenium.pages.common;

import org.openqa.selenium.WebDriver;

import com.solvd.selenium.components.BagItemComponent;
import com.zebrunner.carina.webdriver.gui.AbstractPage;

public abstract class BagPageBase extends AbstractPage {

    public BagPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract int getBagItemCount();

    public abstract BagItemComponent getBagItem(int index);

    public abstract boolean isEmptyBagMessagePresent();

    public abstract String getEmptyBagMessageText();

    public abstract boolean isContinueShoppingButtonPresent();

    public abstract void clickContinueShopping();

    public abstract void waitForTotalPriceChanged(Double expectedNewValue);
}
