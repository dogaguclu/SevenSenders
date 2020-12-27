package com.wire.helpCenter.base;

import com.wire.helpCenter.pages.*;
import com.wire.helpCenter.utilities.*;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;

import static org.testng.ITestResult.FAILURE;

public class BaseTest {
    private final PropertyLoader propertyLoader = new PropertyLoader();

    protected HomePage homePage;
    protected HelpCenterPage helpCenterPage;
    protected HelpCenterSearchResultPage helpCenterSearchResultPage;
    protected GuestsPage guestsPage;
    private ScreenShot screenShot;
    private static WebDriver webDriver;
    protected static String websiteUrl;

    @Parameters({"browser"})
    @BeforeMethod
    public void testPreparation(@Optional("CHROME") Browsers browser) {

        setWebDriver(browser);

        homePage = new HomePage(webDriver);
        screenShot = new ScreenShot(webDriver);

        LogUtil.testStartedLog(getClass().getSimpleName());
        websiteUrl = propertyLoader.getWebsiteUrl();
        homePage.openPage();
    }

    @AfterMethod()
    public void takeScreenShotOfFailedTests(ITestResult iTestResult) {
        if (iTestResult.getStatus() == FAILURE) {
            screenShot.takeScreenShotAtFailedTest();
        }
    }

    @AfterMethod(alwaysRun = true, dependsOnMethods = "takeScreenShotOfFailedTests")
    public void closeWebDriver() {
        if (webDriver != null) {
            webDriver.quit();
            LogUtil.testEndedLog(getClass().getSimpleName());
        }
    }

    private void setWebDriver(Browsers browser) {
        try {
            webDriver = WebDriverFactory.setBrowser(browser);
            LogUtil.log("Browser is " + browser);
            webDriver.manage().window().maximize();
        } catch (Exception e) {
            LogUtil.errorLog("Browser could no be set, please check testng.xml file");
            e.printStackTrace();
        }
    }
}
