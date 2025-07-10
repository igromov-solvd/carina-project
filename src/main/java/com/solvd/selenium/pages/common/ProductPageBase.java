package com.solvd.selenium.pages.common;

import org.openqa.selenium.WebDriver;

import com.solvd.selenium.components.ProductComponent;
import com.zebrunner.carina.webdriver.gui.AbstractPage;

public abstract class ProductPageBase extends AbstractPage {

    public ProductPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract ProductComponent getProduct();

    public abstract BagPageBase clickViewBagButton();

    public abstract boolean isAddToBagConfirmationPresent();

    public abstract boolean isCheckoutButtonPresent();

    public abstract void clickCheckoutButton();
}
