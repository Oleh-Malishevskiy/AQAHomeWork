package AQA.Task13;


import AQA.Task6_7.LogTask13;
import AQA.Task6_7.UserService;
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
        UserService userService = new UserService();
        LogTask13 logTask13 = new LogTask13(a);
        userService.saveLogG(logTask13);
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
