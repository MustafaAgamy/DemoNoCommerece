package pages.Register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage{
    private WebDriver driver;
    private final By genderMale = By.id("gender-male");
    private final By genderFemale = By.id("gender-female");
    private final By firstNameField = By.id("FirstName");
    private final By lastNameField = By.id("LastName");
    private final By birthDayField = By.name("DateOfBirthDay");
    private final By birthMonthField = By.name("DateOfBirthMonth");
    private final By birthYearField = By.name("DateOfBirthYear");
    private final By emailField = By.id("Email");
    private final By passwordField = By.id("Password");
    private final By confPasswordField = By.id("ConfirmPassword");
    private final By confRegisterBtn = By.id("register-button");


    public RegisterPage(WebDriver driver){
        this.driver = driver;
    }

    public void fillRegisterInfoMale(String firstName, String lastName, String day, String month, String year,
                                     String email,String password, String confPassword){

        findElement(genderMale).click();
        findElement(firstNameField).sendKeys(firstName);
        findElement(lastNameField).sendKeys(lastName);
        selectBirthInfo(day, month, year);
        findElement(emailField).sendKeys(email);
        findElement(passwordField).sendKeys(password);
        findElement(confPasswordField).sendKeys(confPassword);

    }

    public void fillRegisterInfoFeMale(String firstName, String lastName, String day, String month, String year,
                                       String email,String password, String confPassword){


        findElement(genderFemale).click();
        findElement(firstNameField).sendKeys(firstName);
        findElement(lastNameField).sendKeys(lastName);
        selectBirthInfo(day, month, year);
        findElement(emailField).sendKeys(email);
        findElement(passwordField).sendKeys(password);
        findElement(confPasswordField).sendKeys(confPassword);

    }

    public void selectBirthInfo(String day, String month, String year){

        WebElement element = findElement(birthDayField);
        Select select = new Select(element);
        select.selectByValue(day);

        element = findElement(birthMonthField);
        select = new Select(element);
        select.selectByValue(month);

        element = findElement(birthYearField);
        select = new Select(element);
        select.selectByValue(year);
    }

    public RegisterConfirmPage clickConfRegister(){
        findElement(confRegisterBtn).click();
        return new RegisterConfirmPage(driver);
    }

    public WebElement findElement(By by){
        var webDriverWait = new WebDriverWait(driver,Duration.ofSeconds(10));
        return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
