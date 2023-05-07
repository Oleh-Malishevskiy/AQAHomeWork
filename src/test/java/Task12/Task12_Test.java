package Task12;

import AQA.Task12.HomePage;
import AQA.Task12.Pages.CartPage;
import AQA.Task12.Pages.ProductDetailPage;
import AQA.Task12.WebDriverHelper;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task12_Test {
//    Implement PageFactory for a few pages.
//    Implement Wrapper for common WebElements (choose your wariant).
//    Implement methods for your web element with console logging. Choose your wariant with specific methods
//    v10
//    Alerts:
//    acceptAlert - accepts an alert dialog
//    dismissAlert - dismisses an alert dialog
//    getTextFromAlert - retrieves the text message from an alert dialog



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
