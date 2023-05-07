package Task11;

import AQA.Task11.HomePage;
import AQA.Task11.Pages.CartPage;
import AQA.Task11.Pages.ProductDetailPage;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EndToEnd {
//    Add a product to the shopping cart Scenario:
    //    Navigate to the product page
    //    Click on the "Add to Cart" button
    //    Verify that the product is added to the shopping cart
    //    Navigate to the shopping cart page
    //    Verify that the product is displayed in the shopping cart
    //    Verify that the total price of the products in the shopping cart is correct

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
