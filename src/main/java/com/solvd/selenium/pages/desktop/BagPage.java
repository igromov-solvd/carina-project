package com.solvd.selenium.pages.desktop;

import java.lang.invoke.MethodHandles;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.solvd.selenium.components.BagItemComponent;
import com.solvd.selenium.pages.common.BagPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = BagPageBase.class)
public class BagPage extends BagPageBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(css = "div[id='items'] > div")
    private List<BagItemComponent> bagItemComponents;

    @FindBy(css = "div.sb-subtitle > span")
    private ExtendedWebElement emptyBagMessage;

    @FindBy(css = "div.bag-empty > button")
    private ExtendedWebElement continueShoppingButton;

    @FindBy(css = "div.sbm-page-header div.sbm-order-total-price.sbm-summary-price-value")
    private ExtendedWebElement totalPrice;

    public BagPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public int getBagItemCount() {
        return bagItemComponents.size();
    }

    @Override
    public BagItemComponent getBagItem(int index) {
        return bagItemComponents.get(index);
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
    public void waitForTotalPriceChanged(Double expectedNewValue) {
        waitUntil(driver -> {
            String priceText = totalPrice.getText().replace("£", "");
            try {
                double currentValue = Double.parseDouble(priceText);
                return Double.compare(currentValue, expectedNewValue) == 0;
            } catch (Exception e) {
                LOGGER.warn("Failed to parse total price: {}", priceText, e);
                return false;
            }
        }, DEFAULT_EXPLICIT_TIMEOUT);
    }
}