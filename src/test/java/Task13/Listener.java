package Task13;

import AQA.Task11.HomePage;
import AQA.Task11.Pages.CartPage;
import AQA.Task11.Pages.ProductDetailPage;
import AQA.Task13.SuiteListener;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Listeners({SuiteListener.class})
public class Listener {
//    Implement custom Test and another Listeners with methods for your variant.
//    Add logging for all overridden listener methods
//    Add video recorder for onFail action (you can use any lib for that)
//    V10. ITestListener method task (3, 6); ISuiteListener, IExecutionListener,IInvoke...(1, 2)
//   3 onTestSuccess() - Logging the test result and add the test result record to table in local DB.
//            onTestFailure() - Log the test result and take a screenshot of the failed test.
//   6 onTestSkipped() - Logging the test result and skip reason to console.
//
//    1 onStart(ISuite suite) - Set up the environment for the test suite or initialise any data required for the test suite.
//    2 onFinish(ISuite suite) - Tear down the environment or clean up any data created during the execution of the test suite. Close browser if need.
//

    private WebDriver driver;
    @BeforeTest
    void setup() {
        //WebDriver webDriverTest = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
        ChromeDriverManager.getInstance().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }
    @Test
    void EndToEnd(){
        HomePage homePage = new HomePage(driver);
        ProductDetailPage productDetailPage = homePage.productDetail();
        List<String> A = new ArrayList<>();
        A = Collections.singletonList(productDetailPage.getProductNamePrice());
        productDetailPage.AddToCartAndIsAdded();

        CartPage cartPage = productDetailPage.ToCart();

        cartPage.ProductNameAndPrice();
        String ProductNameInCart = cartPage.getInCartName();
        String ProductPriceInCart = cartPage.getInCartPrice();
        System.out.println("in cart name and price " + ProductNameInCart + " $" + ProductPriceInCart  + "-- selected from store " + A.get(0));

    }
    @AfterTest
    void closeBrowser(){
        driver.close();
        driver.quit();
    }


}
