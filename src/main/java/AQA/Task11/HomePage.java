package AQA.Task11;

import AQA.Task11.Pages.ProductDetailPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    public static final String URL = "https://www.demoblaze.com";
    public HomePage(WebDriver driver) {
        this.driver = driver;
        if(!URL.equals(driver.getCurrentUrl())){
            driver.get(URL);
        }
    }

    public ProductDetailPage productDetail() {
        WebElement ProductButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tbodyid\"]/div[1]/div/div/h4/a")));
        ProductButton.click();
        return new ProductDetailPage(driver);
    }
}
