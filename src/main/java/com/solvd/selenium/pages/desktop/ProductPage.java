package com.solvd.selenium.pages.desktop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.selenium.pages.common.ProductPageBase;
import com.solvd.selenium.components.ProductComponent;
import com.solvd.selenium.pages.common.BagPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = ProductPageBase.class)
public class ProductPage extends ProductPageBase {

    @FindBy(css = "body")
    private ProductComponent productComponent;

    @FindBy(css = "div[data-testid='header-mini-shopping-bag']")
    private ExtendedWebElement addToBagConfirmation;

    @FindBy(css = "div[data-testid='header-mini-shopping-bag'] > div > div > a[href$='/shoppingbag']")
    private ExtendedWebElement viewBagButton;

    @FindBy(css = "div[data-testid='minibag-adaptive-checkout'] > a")
    private ExtendedWebElement checkoutButton;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ProductComponent getProduct() {
        return productComponent;
    }

    @Override
    public BagPageBase clickViewBagButton() {
        viewBagButton.click();
        return initPage(getDriver(), BagPageBase.class);
    }

    @Override
    public boolean isAddToBagConfirmationPresent() {
        return addToBagConfirmation.isElementPresent();
    }

    @Override
    public boolean isCheckoutButtonPresent() {
        return checkoutButton.isElementPresent();
    }

    @Override
    public void clickCheckoutButton() {
        checkoutButton.click();
    }
}