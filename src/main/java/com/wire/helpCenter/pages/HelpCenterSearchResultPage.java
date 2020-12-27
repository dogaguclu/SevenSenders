package com.wire.helpCenter.pages;

import com.wire.helpCenter.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HelpCenterSearchResultPage extends BasePage {

    @FindBy(className = "search-result-link")
    private List<WebElement> searchResults;
    @FindBy (className = "page-header-description")
    private WebElement resultsText;

    public HelpCenterSearchResultPage(WebDriver webDriver){
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public WebElement getResultsText(){
        waitUntilElementVisible(resultsText);
        return resultsText; }

    public int getNumberOfResults(){ return searchResults.size(); }

}
