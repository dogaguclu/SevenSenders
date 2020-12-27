package com.wire.helpCenter;

import com.wire.helpCenter.base.BaseTest;
import com.wire.helpCenter.utilities.RetryOnFail;
import jdk.jfr.Description;
import org.junit.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class HelpCenterTest extends BaseTest {

    @Parameters({"searchText","resultText","mainPageTitle","hcTitle"})
    @Test(priority = 1, groups = "home", retryAnalyzer = RetryOnFail.class)
    public void userSearchesAKeywordOnFAQPage (@Optional("Invite a guest") String searchText, String resultText, String mainPageTitle, String hcTitle) {
        Assert.assertTrue(homePage.isHomePageVisible());
        Assert.assertEquals(homePage.titleAndUrl(), List.of(mainPageTitle,websiteUrl));

        helpCenterPage = homePage.clickFaqLink();
        Assert.assertTrue(helpCenterPage.getSearchBox().isDisplayed());
        Assert.assertEquals(helpCenterPage.getHelpCenterTitle().getText(), hcTitle);

        helpCenterSearchResultPage = helpCenterPage.makeASearch(searchText);
        Assert.assertTrue(helpCenterSearchResultPage.getResultsText().isDisplayed());
        Assert.assertTrue(helpCenterSearchResultPage.getNumberOfResults() > 0);
        Assert.assertEquals(helpCenterSearchResultPage.getResultsText().getText(), resultText+" \""+searchText+"\"");
    }

    @Parameters({"mainPageTitle", "guestsPageText", "title"})
    @Test(priority = 2, description = "User browse through an FAQ topic", enabled = true, retryAnalyzer = RetryOnFail.class)
    public void userBrowsThroughAnFAQTopic (String mainPageTitle, String guestsPageText, String title) {
        Assert.assertTrue(homePage.isHomePageVisible());
        Assert.assertEquals(homePage.titleAndUrl(), List.of(mainPageTitle,websiteUrl));

        helpCenterPage = homePage.clickFaqLink();
        Assert.assertTrue(helpCenterPage.getSearchBox().isDisplayed());
        Assert.assertTrue(helpCenterPage.getGettingStartedTopic().isDisplayed());
        Assert.assertTrue(helpCenterPage.getTeamManagementTopic().isDisplayed());
        Assert.assertTrue(helpCenterPage.getProfileAndSettingsTopic().isDisplayed());
        Assert.assertTrue(helpCenterPage.getUsingWireTopic().isDisplayed());
        Assert.assertTrue(helpCenterPage.getGuestsTopic().isDisplayed());
        Assert.assertTrue(helpCenterPage.getConferencingTopic().isDisplayed());
        Assert.assertTrue(helpCenterPage.getPrivacyTopic().isDisplayed());

        guestsPage = helpCenterPage.clickOnGuestsTopic();
        Assert.assertTrue(guestsPage.getTitle().isDisplayed());
        Assert.assertEquals(guestsPage.getTitle().getText(), title);
        Assert.assertEquals(guestsPage.getText().getText(), guestsPageText);
    }

    @Parameters({"searchTextNoResult","mainPageTitle"})
    @Test(priority = 3, description = "User searches a keyword that returns no result", retryAnalyzer = RetryOnFail.class)
    public void userSearchesAKeywordOnFAQPageThatReturnsNoResult (@Optional("Price") String searchTextNoResult, String mainPageTitle) throws InterruptedException {

        Assert.assertTrue(homePage.isHomePageVisible());
        Assert.assertEquals(homePage.titleAndUrl(), List.of(mainPageTitle,websiteUrl));

        helpCenterPage = homePage.clickFaqLink();
        Assert.assertTrue(helpCenterPage.getSearchBox().isDisplayed());

        helpCenterSearchResultPage = helpCenterPage.makeASearch(searchTextNoResult);
        Assert.assertEquals(helpCenterSearchResultPage.getNumberOfResults(), 0);
        Assert.assertEquals(helpCenterSearchResultPage.getResultsText().getText(), "No results for \""+searchTextNoResult+"\"");
    }
}




