package AQA.Task11.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    private WebDriver driver;
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    private String price;


    public CartPage(WebDriver driver) {
        this.driver = driver;
    }
    public String getInCartName() {
        return name;
    }

    public String getInCartPrice() {
        return price;
    }

    public void ProductNameAndPrice() {
        WebElement ProductNameInCart = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(driver -> driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/tr[1]/td[2]")));
        WebElement ProductPriceInCart = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(driver -> driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/tr[1]/td[3]")));
        setName(String.valueOf(ProductNameInCart));
        setPrice(String.valueOf(ProductPriceInCart));
    }
}
