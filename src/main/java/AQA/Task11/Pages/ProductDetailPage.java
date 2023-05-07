package AQA.Task11.Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static AQA.Task12.WebDriverHelper.driver;

public class ProductDetailPage {
    private WebDriver driver;
    public ProductDetailPage(WebDriver driver) {
        this.driver =driver;
    }

    public String getProductNamePrice() {
        WebElement ProductName = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(driver -> driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/h2")));
        WebElement ProductPrice = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(driver -> driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/h3")));

        String a = ProductName.getText();
        String c = ProductPrice.getText();
        List<String>  NamePrice = new ArrayList<>();
        NamePrice.add(a);
        NamePrice.add(c);
        System.out.println(NamePrice.get(0) +"  " + NamePrice.get(1));
        return NamePrice.toString();
    }

    public void AddToCartAndIsAdded() {
        WebElement ToCart = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a")));
        ToCart.click();
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            System.out.println(alert.getText());
            Assert.assertTrue(alert.getText().contains("Product added"));
            alert.accept();
        } catch (Exception e) {
            System.out.println("error: " + e);
        }
    }

    public CartPage ToCart() {
        WebElement CartButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"cartur\"]")));
        CartButton.click();
        return new CartPage(driver);
    }
}
