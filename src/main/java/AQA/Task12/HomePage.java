package AQA.Task12;

import AQA.Task12.Pages.ProductDetailPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static AQA.Task12.WebDriverHelper.driver;

public class HomePage {
    @FindBy(xpath = "//*[@id=\"tbodyid\"]/div[1]/div/div/h4/a")
    WebElement toProductDetail;

    public static final String URL = "https://www.demoblaze.com";
    public HomePage() {
        if(!URL.equals(driver.getCurrentUrl())){
            driver.get(URL);
        }
        PageFactory.initElements(driver,this);
    }

    public ProductDetailPage productDetail() throws InterruptedException {
        Thread.sleep(1000);
        toProductDetail.click();
        return new ProductDetailPage();
    }
}
