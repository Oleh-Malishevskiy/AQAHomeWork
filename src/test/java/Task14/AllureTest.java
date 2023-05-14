package Task14;
import AQA.Task12.HomePage;
import AQA.Task12.Pages.CartPage;
import AQA.Task12.Pages.ProductDetailPage;
import AQA.Task12.WebDriverHelper;
import AQA.Task14.Allure;
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
@Listeners({Allure.class})
public class AllureTest {
//    Add Allure to your framework
//    Attach screenshot and DOM to the report




    @BeforeTest
    void setup() {
        //WebDriver webDriverTest = new ChromeDriver();
        WebDriverHelper.setupDriver();

    }
    @Test
    void EndToEnd() throws InterruptedException {
        HomePage homePage = new HomePage();
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
        WebDriverHelper.close();

    }


}
