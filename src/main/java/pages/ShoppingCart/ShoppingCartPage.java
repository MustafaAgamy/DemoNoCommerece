package pages.ShoppingCart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShoppingCartPage {
    private WebDriver driver;
    private final By productName = By.xpath("//td//a[@class='product-name']");
    private final By productSpecs = By.xpath("//td//div[@class='attributes']");
    private final By quantityNumber = By.xpath("//td//input[@class='qty-input']");
    private final By itemPrice = By.xpath("//td//span[@class='product-unit-price']");
    private final By totalPrice =By.xpath("//td//span[@class='product-subtotal']");
    private final By removeItem = By.xpath("//td[@class='remove-from-cart']");
    public ShoppingCartPage(WebDriver driver){
        this.driver = driver;
    }


    public String productName(){
        return findElement(productName).getText();
    }
    public String productSpecifications(){
        return findElement(productSpecs).getText();
    }
    public String quantityNumber(){
        return findElement(quantityNumber).getAttribute("value");
    }
    public String productPrice(){
        return findElement(itemPrice).getText();
    }
    public String totalPrice(){
        return findElement(totalPrice).getText();
    }

    public WebElement findElement(By by){
        var webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
