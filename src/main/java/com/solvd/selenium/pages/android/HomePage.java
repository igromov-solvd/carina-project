package com.solvd.selenium.pages.android;

import org.openqa.selenium.WebDriver;

import com.solvd.selenium.components.FooterComponent;
import com.solvd.selenium.components.HeaderComponent;
import com.solvd.selenium.components.StorefrontContentComponent;
import com.solvd.selenium.pages.common.HomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public HeaderComponent getHeader() {
        // TODO: implement logic
        return null;
    }

    @Override
    public StorefrontContentComponent getStorefrontContent() {
        // TODO: implement logic
        return null;
    }

    @Override
    public FooterComponent getFooter() {
        // TODO: implement logic
        return null;
    }

}
