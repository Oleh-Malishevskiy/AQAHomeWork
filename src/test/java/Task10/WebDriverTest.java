package Task10;

import AQA.Task2.Operations;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebDriverTest {
//    Setup ChromeDriver using driver file and properties.
//    Setup ChromeDriver using DriverManager.
//    My first UI test:
//    go to the page from your variant
//    choose any 5 different elements;
//    Use different WebElement methods to communicate with those elements. (one element - at least one interaction)
//    Make a testNG test case to check visibility of your elements.

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
    void MyTest(){
        driver.get("https://demoqa.com/checkbox");
        WebElement PlusButton = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/div/button[1]"));
        PlusButton.click();
        WebElement DropDownButton = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/span/button"));
        System.out.println(DropDownButton.getLocation());
        WebElement Aref = driver.findElement(By.xpath("//*[@id=\"app\"]/header/a"));
        System.out.println(Aref.getClass());
        WebElement CheckBox = driver.findElement(By.xpath("//*[@id=\"tree-node-workspace\"]"));
        System.out.println(CheckBox.getSize());
        WebElement Collapse = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[2]/div"));
        System.out.println(Collapse.getTagName());
        Assert.assertFalse(Collapse.isDisplayed());
    }
    @AfterTest
    void closeBrowser(){
        driver.close();
        driver.quit();
    }
}
