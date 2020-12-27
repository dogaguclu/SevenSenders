package com.wire.helpCenter.pages;

import com.wire.helpCenter.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HelpCenterPage extends BasePage {

    @CacheLookup
    @FindBy(id = "query")
    private WebElement searchBox;
    @FindBy(css = "h1")
    private WebElement helpCenterTitle;
    @FindBy(css = "[title*='Getting Started']")
    private WebElement gettingStartedTopic;
    @FindBy(css = "[title*='Team Management']")
    private WebElement teamManagementTopic;
    @FindBy(css = "[title*='Profile & Settings']")
    private WebElement profileAndSettingsTopic;
    @FindBy(css = "[title*='Using Wire']")
    private WebElement usingWireTopic;
    @FindBy(css = "[title*='Guests']")
    private WebElement guestsTopic;
    @FindBy(css = "[title*='Conferencing']")
    private WebElement conferencingTopic;
    @FindBy(css = "[title*='Privacy & Security']")
    private WebElement privacyTopic;

    public HelpCenterPage(WebDriver webDriver){ super(webDriver); PageFactory.initElements(webDriver, this);}

    public HelpCenterSearchResultPage makeASearch(String text) {
        searchBox.click();
        searchBox.sendKeys(text);
        searchBox.submit();
        return new HelpCenterSearchResultPage(webDriver);
    }

    public GuestsPage clickOnGuestsTopic(){
        waitUntilElementVisible(guestsTopic);
        guestsTopic.click();
        return new GuestsPage(webDriver);
    }

    public WebElement getSearchBox(){
        waitUntilElementVisible(searchBox);
        return searchBox;
    }

    public WebElement getHelpCenterTitle(){ return helpCenterTitle; }

    public WebElement getGettingStartedTopic(){
        return gettingStartedTopic;
    }

    public WebElement getTeamManagementTopic(){
        return teamManagementTopic;
    }

    public WebElement getProfileAndSettingsTopic(){
        return profileAndSettingsTopic;
    }

    public WebElement getUsingWireTopic(){
        return usingWireTopic;
    }

    public WebElement getGuestsTopic(){
        return guestsTopic;
    }

    public WebElement getConferencingTopic(){
        return conferencingTopic;
    }

    public WebElement getPrivacyTopic(){
        return privacyTopic;
    }
}