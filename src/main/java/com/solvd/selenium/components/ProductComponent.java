package com.solvd.selenium.components;

import java.util.List;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import com.zebrunner.carina.webdriver.locator.Context;

public class ProductComponent extends AbstractUIObject {

    @FindBy(css = "h1[data-testid='product-title']")
    private ExtendedWebElement productName;

    @FindBy(css = "div[data-testid='product-now-price'] > span")
    private ExtendedWebElement productPrice;

    @FindBy(css = "a[data-testid='item-title-review-stars']")
    private ExtendedWebElement reviewsSection;

    @FindBy(css = "button[data-testid^='pdp-thumb']")
    private List<ExtendedWebElement> productImages;

    @FindBy(css = "div[data-testid='item-form-size-control']")
    private ExtendedWebElement sizeSelector;

    @Context(dependsOn = "sizeSelector")
    @FindBy(css = "div[role='combobox']")
    private ExtendedWebElement sizeSelectorCombobox;

    @FindBy(css = "ul[aria-labelledby='size-input-label']")
    private ExtendedWebElement sizeSelectorComboboxList;

    @Context(dependsOn = "sizeSelectorComboboxList")
    @FindBy(css = "li:not(.unavailable):nth-of-type(%d)")
    private ExtendedWebElement availableSizeInComboboxList;

    @Context(dependsOn = "sizeSelector")
    @FindBy(css = "div[role='group']")
    private ExtendedWebElement sizeSelectorGroup;

    @Context(dependsOn = "sizeSelectorGroup")
    @FindBy(css = "button:not(.unavailable):nth-of-type(%d)")
    private ExtendedWebElement availableSizeInGroup;

    @FindBy(css = "[data-testid='item-form-stock-status'] > p")
    private ExtendedWebElement inStock;

    @FindBy(css = "div[data-testid='colour-chips-button-group']")
    private ExtendedWebElement colorSelectorGroup;

    @FindBy(css = "div[data-testid='colour-select']")
    private ExtendedWebElement colorSelectorCombobox;

    @FindBy(css = "button[data-testid='item-form-addToBag-button']")
    private ExtendedWebElement addToBagButton;

    @FindBy(css = "button[data-testid='item-form-favourite-button']")
    private ExtendedWebElement favouriteButton;

    @FindBy(css = "p[data-testid='item-description']")
    private ExtendedWebElement productDescription;

    public ProductComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isProductNamePresent() {
        return productName.isElementPresent();
    }

    public boolean isProductPricePresent() {
        return productPrice.isElementPresent();
    }

    public boolean isReviewsSectionPresent() {
        return reviewsSection.isElementPresent();
    }

    public boolean areAllProductImagesPresent() {
        if (productImages.isEmpty()) {
            return false;
        }
        for (ExtendedWebElement image : productImages) {
            if (!image.isElementPresent()) {
                return false;
            }
        }
        return true;
    }

    public boolean isSizeSelectorPresent() {
        return sizeSelector.isElementPresent();
    }

    public boolean isColorSelectorPresent() {
        return colorSelectorGroup.isElementPresent() || colorSelectorCombobox.isElementPresent();
    }

    public boolean isAddToBagButtonPresent() {
        return addToBagButton.isElementPresent();
    }

    public void selectFirstAvailableSize() {
        selectAvailableSize(1);
    }

    private void selectAvailableSize(int index) {
        if (sizeSelectorCombobox.isVisible()) {
            sizeSelectorCombobox.click();
            sizeSelectorComboboxList.isPresent();
            availableSizeInComboboxList.format(index).click();
            sizeSelectorComboboxList.waitUntilElementDisappear(R.CONFIG.getInt("disappear_timeout"));
        } else if (sizeSelectorGroup.isVisible()) {
            availableSizeInGroup.format(index).click();
            inStock.isElementWithTextPresent("In stock");
        } else {
            throw new IllegalStateException("Size selector is not visible");
        }
    }

    public void clickAddToBag() {
        addToBagButton.click();
    }

    public boolean isFavouriteButtonPresent() {
        return favouriteButton.isElementPresent();
    }

    public boolean isProductDescriptionPresent() {
        return productDescription.isElementPresent();
    }
}
