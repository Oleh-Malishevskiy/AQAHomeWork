package AQA.Task12.Wrapper;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;

import static AQA.Task12.WebDriverHelper.driver;

public class Element {
    private WebElement element;

    public WebElement getElement() {
        return element;
    }

    public void setElement(WebElement element) {
        this.element = element;
    }

    public Element(WebElement element) {
        this.element = element;
    }


    public void closeAlert() throws InterruptedException {
        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    public void GetTextFromAlert() throws InterruptedException {
        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
    }

    public void AcceptAlert() throws InterruptedException {
        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }
}
