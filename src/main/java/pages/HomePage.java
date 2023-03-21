package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.FollowUs.FollowUsPage;
import pages.Login.LoginPage;
import pages.Product.ProductPage;
import pages.Register.RegisterPage;
import pages.Search.SearchPage;
import pages.Sliders.SlidersPage;

import java.time.Duration;


public class HomePage {
    private WebDriver driver;
    private final By registerBtn = By.className("ico-register");
    private final By welcomeMsg = By.xpath("//div[@class=\"topic-block-title\"]//h2");
    private final By loginBtn = By.className("ico-login");
    private final By logoutBtn = By.className("ico-logout");
    private final By searchBar = By.id("small-searchterms");
    private final By searchBtn = By.xpath("//button[@type='submit']");
    private final By addToWishBtn1 = By.xpath("//div[@data-productid='1']//button[@title='Add to wishlist']");
    private final By addToWishBtn2 = By.xpath("//div[@data-productid='4']//button[@title='Add to wishlist']");
    private final By addToWishBtn3 = By.xpath("//div[@data-productid='18']//button[@title='Add to wishlist']");
    private final By addToWishBtn4 = By.xpath("//div[@data-productid='43']//button[@title='Add to wishlist']");
    private final By addToCartBtn1 = By.xpath("//div[@data-productid='1']//button[contains(@class,'add-to-cart')]");
    private final By addToCartBtn2 = By.xpath("//div[@data-productid='4']//button[contains(@class,'add-to-cart')]");
    private final By addToCartBtn3 = By.xpath("//div[@data-productid='18']//button[contains(@class,'add-to-cart')]");
    private final By addToCartBtn4 = By.xpath("//div[@data-productid='43']//button[contains(@class,'add-to-cart')]");
    private final By faceBookBtn = By.xpath("//li[@class='facebook']//a[@target='_blank']");
    private final By twitterBtn = By.xpath("//li[@class='twitter']//a[@target='_blank']");
    private final By youTubeBtn = By.xpath("//li[@class='youtube']//a[@target='_blank']");


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public RegisterPage clickRegisterBtn() {
        findElement(registerBtn).click();
        return new RegisterPage(driver);

    }

    public String getWelcomeMsg() {
        return findElement(welcomeMsg).getText();
    }

    public LoginPage clickLoginBtn() {
        findElement(loginBtn).click();
        return new LoginPage(driver);
    }

    public void clickLogoutBtn() {
        findElement(logoutBtn).click();
    }

    public void searchInput(String input) {
        findElement(searchBar).sendKeys(input);

    }

    public SearchPage clickSearchBtn() {
        findElement(searchBtn).click();
        return new SearchPage(driver);
    }
    public ProductPage AddProduct1ToWishBtn() {
        findElement(addToWishBtn1).click();
        return new ProductPage(driver);
    }
    public ProductPage AddProduct1ToCartBtn() {
        findElement(addToCartBtn1).click();
        return new ProductPage(driver);
    }
    public FollowUsPage clickFaceBookBtn(){
        findElement(faceBookBtn).click();
        return new FollowUsPage(driver);
    }
    public FollowUsPage clickTwitterBtn(){
        findElement(twitterBtn).click();
        return new FollowUsPage(driver);
    }
    public FollowUsPage clickYouTubeBtn(){
        findElement(youTubeBtn).click();
        return new FollowUsPage(driver);
    }

    public SlidersPage switchToSliders(){
        return new SlidersPage(driver);
    }


    public WebElement findElement(By by) {
        var webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
