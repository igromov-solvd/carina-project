package com.solvd.selenium.components;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import com.zebrunner.carina.webdriver.locator.Context;

public class BagItemComponent extends AbstractUIObject {

    @FindBy(css = "p.sbm-item-description:not([style*='none'])")
    private ExtendedWebElement name;

    @FindBy(css = "span[class='sbm-item-price']")
    private ExtendedWebElement price;

    @FindBy(css = "div.qty-plusminus-control")
    private ExtendedWebElement quantityControl;

    @Context(dependsOn = "quantityControl")
    @FindBy(css = "input")
    private ExtendedWebElement quantityInput;

    @Context(dependsOn = "quantityControl")
    @FindBy(css = "button.qty-plus")
    private ExtendedWebElement quantityPlusButton;

    @Context(dependsOn = "quantityControl")
    @FindBy(css = "button.qty-minus")
    private ExtendedWebElement quantityMinusButton;

    @FindBy(css = "a[class*='DeleteButton']")
    private ExtendedWebElement removeButton;

    public BagItemComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isItemNamePresent() {
        return name.isElementPresent();
    }

    public boolean isItemPricePresent() {
        return price.isElementPresent();
    }

    public String getItemName() {
        return name.getText();
    }

    public double getItemPrice() {
        return Double.parseDouble(price.getText().replace("£", ""));
    }

    public boolean isQuantityControlPresent() {
        return quantityControl.isElementPresent();
    }

    public int getQuantity() {
        return Integer.parseInt(quantityInput.getAttribute("value"));
    }

    public void clickQuantityPlus() {
        quantityPlusButton.click();
    }

    public void clickQuantityMinus() {
        quantityMinusButton.click();
    }

    public boolean isRemoveButtonPresent() {
        return removeButton.isElementPresent();
    }

    public void clickRemoveButton() {
        removeButton.click();
    }

}