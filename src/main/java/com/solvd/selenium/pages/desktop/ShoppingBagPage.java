package com.solvd.selenium.pages.desktop;

import java.lang.invoke.MethodHandles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.solvd.selenium.pages.common.ShoppingBagPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = ShoppingBagPageBase.class)
public class ShoppingBagPage extends ShoppingBagPageBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(css = "div[id='items'] > div:first-child")
    private ExtendedWebElement firstItem;

    @FindBy(css = "div[id='items'] > div:first-child span[class='sbm-item-price']")
    private ExtendedWebElement firstItemPrice;

    @FindBy(css = "div[id='items'] > div:first-child div.qty-plusminus-control")
    private ExtendedWebElement firstItemQuantity;

    @FindBy(css = "div[id='items'] > div:first-child a[class*='DeleteButton']")
    private ExtendedWebElement firstItemRemoveButton;

    @FindBy(css = "div.sb-subtitle > span")
    private ExtendedWebElement emptyBagMessage;

    @FindBy(css = "div.bag-empty > button")
    private ExtendedWebElement continueShoppingButton;

    @FindBy(css = "div[id='items'] > div:first-child div.qty-plusminus-control > input")
    private ExtendedWebElement quantityCount;

    @FindBy(css = "div[id='items'] > div:first-child div.qty-plusminus-control > button.qty-plus")
    private ExtendedWebElement quantityCountPlus;

    @FindBy(css = "div.sbm-page-header div.sbm-order-total-price.sbm-summary-price-value")
    private ExtendedWebElement totalPrice;

    public ShoppingBagPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isFirstItemPresent() {
        return firstItem.isElementPresent();
    }

    @Override
    public boolean isFirstItemPricePresent() {
        return firstItemPrice.isElementPresent();
    }

    @Override
    public boolean isFirstItemQuantityPresent() {
        return firstItemQuantity.isElementPresent();
    }

    @Override
    public boolean isFirstItemRemoveButtonPresent() {
        return firstItemRemoveButton.isElementPresent();
    }

    @Override
    public void clickFirstItemRemoveButton() {
        firstItemRemoveButton.click();
    }

    @Override
    public boolean isEmptyBagMessagePresent() {
        return emptyBagMessage.isElementPresent();
    }

    @Override
    public String getEmptyBagMessageText() {
        return emptyBagMessage.getText();
    }

    @Override
    public boolean isContinueShoppingButtonPresent() {
        return continueShoppingButton.isElementPresent();
    }

    @Override
    public void clickContinueShopping() {
        continueShoppingButton.click();
    }

    @Override
    public int getQuantity() {
        return Integer.parseInt(quantityCount.getAttribute("value"));
    }

    @Override
    public void clickOnQuantityCountPlus() {
        quantityCountPlus.click();
    }

    @Override
    public double getProductPrice() {
        return Double.parseDouble(firstItemPrice.getText().replace("£", ""));
    }

    @Override
    public void waitForTotalPriceChanged(Double expectedNewValue) {
        waitUntil(driver -> {
            String priceText = totalPrice.getText().replace("£", "");
            try {
                double currentValue = Double.parseDouble(priceText);
                return Double.compare(currentValue, expectedNewValue) == 0;
            } catch (NumberFormatException e) {
                LOGGER.warn("Failed to parse total price: {}", priceText, e);
                return false;
            }
        }, DEFAULT_EXPLICIT_TIMEOUT);
    }
}
