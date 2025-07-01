package com.solvd.selenium.pages.desktop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.solvd.selenium.pages.common.SearchResultsPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.stream.Collectors;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = SearchResultsPageBase.class)
public class SearchResultsPage extends SearchResultsPageBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(css = "p[data-testid='product_summary_title']")
    private List<ExtendedWebElement> productTitles;

    @FindBy(css = "h1[data-testid='plp-results-title']")
    private ExtendedWebElement pageTitle;

    @FindBy(css = "div[data-testid='plp-desktop-sort-button']")
    private ExtendedWebElement sortingContainer;

    @FindBy(css = "header[data-testid='plp-filters-component-desktop']")
    private ExtendedWebElement filtersContainer;

    @FindBy(css = "p[data-testid='product_summary_was_price'] > span")
    private List<ExtendedWebElement> productPrices;

    @FindBy(css = "img[data-testid^='product_summary_image']")
    private List<ExtendedWebElement> productImages;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public List<String> getProductTitles() {
        waitUntil(ExpectedConditions.visibilityOfAllElements(
                productTitles.stream()
                        .map(ExtendedWebElement::getElement)
                        .collect(Collectors.toList())),
                DEFAULT_EXPLICIT_TIMEOUT);

        List<String> titles = productTitles.stream()
                .map(ExtendedWebElement::getText)
                .filter(text -> !text.trim().isEmpty())
                .collect(Collectors.toList());

        LOGGER.info("Found {} product titles", titles.size());
        return titles;
    }

    @Override
    public void printAllProductTitles() {
        List<String> titles = getProductTitles();
        LOGGER.info("=== PRODUCT SEARCH RESULTS ===");
        LOGGER.info("Total products found: {}", titles.size());
        LOGGER.info("Product titles:");

        for (int i = 0; i < titles.size(); i++) {
            LOGGER.info("{}. {}", (i + 1), titles.get(i));
        }
        LOGGER.info("==============================");
    }

    @Override
    public int getProductCount() {
        return getProductTitles().size();
    }

    @Override
    public String getPageTitleText() {
        return pageTitle.getText();
    }

    @Override
    public boolean areFiltersVisible() {
        return filtersContainer.isVisible();
    }

    @Override
    public boolean isSortingVisible() {
        return sortingContainer.isVisible();
    }

    @Override
    public boolean areProductPricesPresent() {
        return areElementsPresent(productPrices);
    }

    @Override
    public boolean areProductImagesPresent() {
        return areElementsPresent(productImages);
    }

    private boolean areElementsPresent(List<ExtendedWebElement> elements) {
        return elements != null && !elements.isEmpty()
                && elements.stream().allMatch(ExtendedWebElement::isElementPresent);
    }
}