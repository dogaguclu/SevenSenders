package com.wire.helpCenter.base;

import com.wire.helpCenter.utilities.PropertyLoader;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver webDriver;
    private PropertyLoader propertyLoader = new PropertyLoader();

    protected static String websiteUrl;

    protected BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        websiteUrl = propertyLoader.getWebsiteUrl();
    }

    protected void waitUntilElementVisible(WebElement webElement) {
        int time_out = propertyLoader.getTimeOut();
        WebDriverWait wait = new WebDriverWait(webDriver, time_out);
        ExpectedCondition<WebElement> condition = ExpectedConditions.visibilityOf(webElement);
        wait.until(condition);
    }

    protected void scrollTo(WebElement webElement){ // Don't have to use scroll to in our case but wanted to show usage
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", webElement);
    }

}