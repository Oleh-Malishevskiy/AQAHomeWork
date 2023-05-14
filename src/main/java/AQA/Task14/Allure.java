package AQA.Task14;

import io.qameta.allure.Attachment;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static AQA.Task12.WebDriverHelper.driver;

public class Allure implements ITestListener {
//    Add Allure to your framework
//    Attach screenshot and DOM to the report
    private final Logger LOGGER = Logger.getLogger(this.getClass());
    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
        LOGGER.info(result.getName());
        MakeScreenShot();
    }



    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
        LOGGER.info(result.getName());

    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        LOGGER.info(result.getName());

    }
    @Attachment(value="Page screen", type = "image/png")
    private byte[] MakeScreenShot(){
            LOGGER.error("makeScreenShot");
            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
