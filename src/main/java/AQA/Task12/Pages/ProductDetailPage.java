package AQA.Task12.Pages;

import AQA.Task12.Wrapper.Decorator;
import AQA.Task12.Wrapper.AlertElement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static AQA.Task12.WebDriverHelper.driver;

public class ProductDetailPage {
    //driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/h2"))
    @FindBy(xpath = "//*[@id=\'tbodyid\']/h2")
    WebElement getNameTextLabel;
    //driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/h3"))
    @FindBy(xpath = "//*[@id=\"tbodyid\"]/h3")
    WebElement getPriceTextLabel;
    //By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a")
    @FindBy(xpath = "//*[@id=\"tbodyid\"]/div[2]/div/a")
    WebElement AddToCartButton;
    //By.xpath("//*[@id=\"cartur\"]")
    @FindBy(xpath = "//*[@id=\"cartur\"]")
    WebElement ToCartPage;

    AlertElement alertElement;


    public ProductDetailPage() {
        PageFactory.initElements(new Decorator(driver), this);
    }

    public String getProductNamePrice() throws InterruptedException {
        Thread.sleep(1000);
        String a  = getNameTextLabel.getText();
        String c = getPriceTextLabel.getText();
        List<String>  NamePrice = new ArrayList<>();
        NamePrice.add(a);
        NamePrice.add(c);
        System.out.println(NamePrice.get(0) +"  " + NamePrice.get(1));
        return NamePrice.toString();
    }

    public void AddToCartAndIsAdded() throws InterruptedException {
        Thread.sleep(1000);
        AddToCartButton.click();
        try {

            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.alertIsPresent());
            alertElement.GetTextFromAlert();
            alertElement.AcceptAlert();
            AddToCartButton.click();
            alertElement.closeAlert();
        } catch (Exception e) {
            System.out.println("error: " + e);
        }


    }

    public CartPage ToCart() throws InterruptedException {
        Thread.sleep(1000);
        ToCartPage.click();
        return new CartPage();
    }
}
