package com.wire.helpCenter.pages;

import com.wire.helpCenter.base.BasePage;
import com.wire.helpCenter.utilities.LogUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class HomePage extends BasePage {

    @FindBy(css = "a > .css-jfas2n")
    private WebElement logo;
    @FindBy(css = ".css-1mxn9bb > div:nth-of-type(4) > a:nth-of-type(2)")
    private WebElement faq;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public void openPage(){
        webDriver.get(websiteUrl);
        waitUntilElementVisible(logo);
        LogUtil.log(websiteUrl + " is opened.");
    }

    public HelpCenterPage clickFaqLink() {
        scrollTo(faq);
        faq.click();
        return new HelpCenterPage(webDriver);
    }

    public boolean isHomePageVisible() {
        waitUntilElementVisible(logo);
        return logo.isDisplayed();
    }

    public List<String> titleAndUrl(){
        return List.of(webDriver.getTitle(), webDriver.getCurrentUrl());
    }

}