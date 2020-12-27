package com.wire.helpCenter.utilities;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenShot {

    private final WebDriver webDriver;
    private static final Logger log = LogManager.getLogger(ScreenShot.class.getName());

    public ScreenShot(WebDriver webDriver){this.webDriver = webDriver;}

    public void takeScreenShotAtFailedTest() {
        try {
            System.out.println(webDriver);
            File screenShot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenShot, new File(System.getProperty("user.dir") + "/screenshots/" + instantTime() + ".png"));
        } catch (Exception e) {
            log.error("Failed to take screenshot");
            e.printStackTrace();
        }
    }
    private String instantTime() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH.mm.ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        return dateTimeFormatter.format(localDateTime);
    }
}