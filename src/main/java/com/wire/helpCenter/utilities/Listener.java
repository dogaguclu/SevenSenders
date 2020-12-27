package com.wire.helpCenter.utilities;

import com.wire.helpCenter.base.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener extends BaseTest implements ITestListener {
    protected static final Logger log = LogManager.getLogger(Listener.class.getName());

    @Override
    public void onTestStart(ITestResult iTestResult) {
        log.info("Test case: "+ iTestResult.getName() + " Started.");
        System.out.println("Test case: "+ iTestResult.getName() + " Started.");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        testResult(iTestResult);
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        testResult(iTestResult);
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        testResult(iTestResult);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {
        log.info("Test name "+ iTestContext.getName()+ " is started");
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        log.info("Test name "+ iTestContext.getName() + " is finished.");
    }

    private void testResult(ITestResult iTestResult){
        String result;
        switch(iTestResult.getStatus()){
            case 1:
                result = "Passed";
                log.info(String.format("Test case: %s %s%s", iTestResult.getMethod().getMethodName(), result, System.lineSeparator()));
                System.out.printf("Test case: %s %s%s%n", iTestResult.getMethod().getMethodName(), result, System.lineSeparator());
                break;
            case 2:
                result = "Failed";
                log.error(String.format("Test case: %s %s%s", iTestResult.getMethod().getMethodName(), result, System.lineSeparator()));
                System.out.printf("Test case: %s %s%s%n", iTestResult.getMethod().getMethodName(), result, System.lineSeparator());
                break;
            case 3:
                result = "Skipped";
                log.warn(String.format("Test case: %s %s%s", iTestResult.getMethod().getMethodName(), result, System.lineSeparator()));
                System.out.printf("Test case: %s %s%s%n", iTestResult.getMethod().getMethodName(), result, System.lineSeparator());
                break;
        }
    }
}
