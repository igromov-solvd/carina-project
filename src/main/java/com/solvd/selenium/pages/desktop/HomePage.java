package com.solvd.selenium.pages.desktop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.solvd.selenium.components.FooterComponent;
import com.solvd.selenium.components.HeaderComponent;
import com.solvd.selenium.components.StorefrontContentComponent;
import com.solvd.selenium.pages.common.HomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;

import java.lang.invoke.MethodHandles;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(css = "header[dir='ltr']")
    private HeaderComponent headerComponent;

    @FindBy(id = "divStorefrontContentSection")
    private StorefrontContentComponent storefrontContentComponent;

    @FindBy(css = "div[data-testid='footer-container']")
    private FooterComponent footerComponent;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HeaderComponent getHeader() {
        return headerComponent;
    }

    public StorefrontContentComponent getStorefrontContent() {
        return storefrontContentComponent;
    }

    public FooterComponent getFooter() {
        return footerComponent;
    }

}