package com.wire.helpCenter.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;

import static org.testng.ITestResult.*;

public class LogUtil  {

    protected static final Logger log = LogManager.getLogger(LogUtil.class.getName());

    public static void testResultLog (ITestResult scenario){//Keeping code here to show a possible usage

        switch (scenario.getStatus()){
            case SUCCESS:
                log.info("Test scenario " + scenario.getMethod().getMethodName()+ " Succeeded");
                break;
            case FAILURE:
                log.error("Test scenario " + scenario.getMethod().getMethodName() + " Failed!");
                break;
            case SKIP:
                log.warn( "Test scenario " + scenario.getMethod().getMethodName() + " Skipped!");
        }
    }

    public static void testStartedLog(String className){
        log.info(className + " started");
    }

    public static void testEndedLog(String className){
        log.info(className + " ended");
        log.info("Closing browser at the end of the test");
    }
    public static void log(String text) {
        log.info(text);
    }

    public static void errorLog(String text) {
        log.error(text);
    }
}
