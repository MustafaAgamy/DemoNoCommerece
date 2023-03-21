package pages.Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private final By pageMsg = By.xpath("//div[@class=\"page-title\"]//h1");
    private final By emailField = By.id("Email");
    private final By passwordField =By.id("Password");
    private final By confLoginBtn = By.xpath("//button[@class=\"button-1 login-button\"]");


    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public String getPageMsg(){
        return findElement(pageMsg).getText();
    }

    public void fillLoginInfo(String email, String password){
        findElement(emailField).sendKeys(email);
        findElement(passwordField).sendKeys(password);
    }

    public HomePage clickConfLoginBtn(){
        findElement(confLoginBtn).click();
        return new HomePage(driver);
    }

    public WebElement findElement(By by){
        var webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

}
