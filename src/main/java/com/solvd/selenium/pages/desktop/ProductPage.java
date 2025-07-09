package com.solvd.selenium.pages.desktop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import com.solvd.selenium.pages.common.ProductPageBase;
import com.solvd.selenium.pages.common.BagPageBase;
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

    @FindBy(css = "div[data-testid='header-mini-shopping-bag'] > div > div > a[href$='/shoppingbag']")
    private ExtendedWebElement viewBagButton;

    @FindBy(css = "div[data-testid='minibag-adaptive-checkout'] > a")
    private ExtendedWebElement checkoutButton;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public BagPageBase clickViewBagButton() {
        viewBagButton.click();
        return initPage(getDriver(), BagPageBase.class);
    }

    @Override
    public boolean isProductNamePresent() {
        return productName.isElementPresent();
    }

    @Override
    public boolean isProductPricePresent() {
        return productPrice.isElementPresent();
    }

    @Override
    public boolean isProductDescriptionPresent() {
        return productDescription.isElementPresent();
    }

    @Override
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

    @Override
    public boolean isSizeSelectorPresent() {
        return sizeSelector.isElementPresent();
    }

    @Override
    public boolean isColorSelectorPresent() {
        return colorSelector.isElementPresent();
    }

    @Override
    public boolean isAddToBagButtonPresent() {
        return addToBagButton.isElementPresent();
    }

    @Override
    public boolean isFavouriteButtonPresent() {
        return favouriteButton.isElementPresent();
    }

    @Override
    public boolean isReviewsSectionPresent() {
        return reviewsSection.isElementPresent();
    }

    @Override
    public void selectFirstAvailableSize() {
        waitForJSToLoad();
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