package pages.Register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;

import java.time.Duration;

public class RegisterConfirmPage {
    private WebDriver driver;
    private final By registerMsg = By.className("result");
    private final By continueBtn = By.xpath("//a[@class=\"button-1 register-continue-button\"]");

    public RegisterConfirmPage(WebDriver driver){
        this.driver = driver;
    }

    public String getResultMsg(){
        return findElement(registerMsg).getText();
    }

    public HomePage clickContinueBtn(){
        findElement(continueBtn).click();
        return new HomePage(driver);
    }

    public WebElement findElement(By by){
        var webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
