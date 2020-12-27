package com.wire.helpCenter.pages;

import com.wire.helpCenter.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GuestsPage extends BasePage {

    @FindBy(css = ".welcome-message")
    private WebElement title;
    @FindBy(css = "a[title='Guest access']")
    private WebElement text;


    public GuestsPage(WebDriver webDriver){
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public WebElement getTitle(){
        waitUntilElementVisible(title);
        return title;
    }

    public WebElement getText(){
        waitUntilElementVisible(text);
        return text;
    }
}
