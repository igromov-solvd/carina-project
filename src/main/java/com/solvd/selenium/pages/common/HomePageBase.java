package com.solvd.selenium.pages.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.solvd.selenium.components.FooterComponent;
import com.solvd.selenium.components.HeaderComponent;
import com.solvd.selenium.components.StorefrontContentComponent;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;

public abstract class HomePageBase extends AbstractPage {

    @FindBy(css = "button#onetrust-accept-btn-handler")
    private ExtendedWebElement acceptCookiesButton;

    public HomePageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
    }

    @Override
    public void open() {
        super.open();
        acceptCookiesButton.clickIfPresent();
    }

    public abstract HeaderComponent getHeader();

    public abstract StorefrontContentComponent getStorefrontContent();

    public abstract FooterComponent getFooter();

}