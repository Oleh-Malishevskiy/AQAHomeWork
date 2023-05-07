package AQA.Task12.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import static AQA.Task12.WebDriverHelper.driver;
import java.time.Duration;

public class CartPage {
    @FindBy(xpath = "//*[@id=\"tbodyid\"]/tr[1]/td[2]")
    WebElement getName;
    @FindBy(xpath = "//*[@id=\"tbodyid\"]/tr[1]/td[3]")
    WebElement getPrice;
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public CartPage() {
        PageFactory.initElements(driver, this);
    }

    private String price;

    public String getInCartName() {
        return name;
    }

    public String getInCartPrice() {
        return price;
    }

    public void ProductNameAndPrice() throws InterruptedException {
        Thread.sleep(1000);
        setName(String.valueOf(getName.getText()));
        setPrice(String.valueOf(getPrice.getText()));
    }
}
