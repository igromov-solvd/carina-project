package com.solvd.selenium.pages.desktop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import com.solvd.selenium.pages.common.ProductPageBase;
import com.solvd.selenium.pages.common.ShoppingBagPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.Context;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.factory.DeviceType;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = ProductPageBase.class)
public class ProductPage extends ProductPageBase {

    @FindBy(css = "h1[data-testid='product-title']")
    private ExtendedWebElement productName;

    @FindBy(css = "div[data-testid='product-now-price'] > span")
    private ExtendedWebElement productPrice;

    @FindBy(css = "p[data-testid='item-description']")
    private ExtendedWebElement productDescription;

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
    @FindBy(xpath = "li[not(contains(., 'unavailable'))][1]")
    private ExtendedWebElement firstAvailableSizeInComboboxList;

    @Context(dependsOn = "sizeSelector")
    @FindBy(css = "div[role='group']")
    private ExtendedWebElement sizeSelectorGroup;

    @Context(dependsOn = "sizeSelectorGroup")
    @FindBy(css = "button:not(.unavailable):first-of-type")
    private ExtendedWebElement firstAvailableSizeInGroup;

    @FindBy(css = "[data-testid='item-form-stock-status'] > p")
    private ExtendedWebElement inStock;

    @FindBy(css = "div[data-testid='colour-chips-button-group']")
    private ExtendedWebElement colorSelector;

    @FindBy(css = "button[data-testid='item-form-addToBag-button']")
    private ExtendedWebElement addToBagButton;

    @FindBy(css = "button[data-testid='item-form-favourite-button']")
    private ExtendedWebElement favouriteButton;

    @FindBy(css = "a[data-testid='item-title-review-stars']")
    private ExtendedWebElement reviewsSection;

    @FindBy(css = "div[data-testid='header-mini-shopping-bag']")
    private ExtendedWebElement addToBagConfirmation;

    @FindBy(css = "div[data-testid='header-mini-shopping-bag'] > div > div > a[href='https://www.next.co.uk/shoppingbag']")
    private ExtendedWebElement viewBagButton;

    @FindBy(css = "div[data-testid='minibag-adaptive-checkout'] > a")
    private ExtendedWebElement checkoutButton;

    public ProductPage(WebDriver driver) {
        super(driver);
        // waitForPageLoad();
    }

    @Override
    public ShoppingBagPageBase clickViewBagButton() {
        viewBagButton.click();
        return initPage(getDriver(), ShoppingBagPageBase.class);
    }

    @Override
    public boolean isProductNameVisible() {
        return productName.isVisible();
    }

    @Override
    public boolean isProductPriceVisible() {
        return productPrice.isVisible();
    }

    @Override
    public boolean isProductDescriptionVisible() {
        return productDescription.isVisible();
    }

    @Override
    public boolean areProductImagesVisible() {
        return !productImages.isEmpty() && productImages.get(0).isDisplayed();
    }

    @Override
    public boolean isSizeSelectionVisible() {
        return sizeSelector.isVisible();
    }

    @Override
    public boolean isColorSelectionVisible() {
        return colorSelector.isVisible();
    }

    @Override
    public boolean isAddToBagButtonVisible() {
        return addToBagButton.isVisible();
    }

    @Override
    public boolean isFavouriteButtonVisible() {
        return favouriteButton.isVisible();
    }

    @Override
    public boolean hasReviewsSection() {
        return reviewsSection.isVisible();
    }

    @Override
    public void selectFirstAvailableSize() {
        if (sizeSelectorCombobox.isVisible()) {
            sizeSelectorCombobox.click();
            sizeSelectorComboboxList.isPresent();
            firstAvailableSizeInComboboxList.click();
            sizeSelectorComboboxList.waitUntilElementDisappear(R.CONFIG.getInt("disappear_timeout"));
        } else if (sizeSelectorGroup.isVisible()) {
            firstAvailableSizeInGroup.click();
            inStock.isElementWithTextPresent("In stock");
        } else {
            throw new IllegalStateException("Size selector is not visible");
        }
    }

    @Override
    public void clickAddToBag() {
        addToBagButton.click();
    }

    @Override
    public boolean isAddToBagConfirmationVisible() {
        return addToBagConfirmation.isVisible();
    }

    @Override
    public boolean isCheckoutButtonVisible() {
        return checkoutButton.isVisible();
    }

    @Override
    public void clickCheckoutButton() {
        checkoutButton.click();
    }
}