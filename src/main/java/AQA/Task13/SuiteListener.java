package AQA.Task13;



import org.testng.*;
import org.apache.log4j.Logger;
public class SuiteListener implements ISuiteListener, IExecutionListener ,ITestListener{
    private final Logger LOGGER = Logger.getLogger(this.getClass());


    @Override
    public void onTestSuccess(ITestResult result) {
        String a;
        LOGGER.info(result);
        a = String.valueOf(result);
        System.out.println(" ---------------------  " + a);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        LOGGER.info(result);
    }

    @Override
    public void onStart(ISuite iSuite) {
        LOGGER.info(iSuite);
    }

    @Override
    public void onFinish(ISuite iSuite) {
        LOGGER.info(iSuite);
    }
}
