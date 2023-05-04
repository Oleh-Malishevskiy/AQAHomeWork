package Task11;

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
import java.util.UUID;

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

        driver.get("https://www.demoblaze.com");

        WebElement ProductButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tbodyid\"]/div[1]/div/div/h4/a")));
        ProductButton.click();
        //*[@id="tbodyid"]/h2
        WebElement ProductName = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(driver -> driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/h2")));
        WebElement ProductPrice = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(driver -> driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/h3")));

        String a = ProductName.getText();
        String c = ProductPrice.getText();
        System.out.println(a+"  " + c);
        WebElement ToCart = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a")));
        ToCart.click();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            System.out.println(alert.getText());
            alert.accept();
            Assert.assertTrue(alert.getText().contains("Product added"));
        } catch (Exception e) {
            //exception handling
        }
        WebElement CartButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"cartur\"]")));
        CartButton.click();
        WebElement ProductNameInCart = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(driver -> driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/tr[1]/td[2]")));
        WebElement ProductPriceInCart = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(driver -> driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/tr[1]/td[3]")));
        System.out.println("in cart name " + ProductNameInCart.getText() + "-- selected from store " + a);
        System.out.println("in cart price " + ProductPriceInCart.getText() + "-- selected from store " + c);

    }
    @AfterTest
    void closeBrowser(){
        driver.close();
        driver.quit();
    }


}
