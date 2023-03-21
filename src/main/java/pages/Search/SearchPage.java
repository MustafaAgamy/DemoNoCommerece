package pages.Search;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Product.ProductPage;

import java.time.Duration;
import java.util.List;
import java.util.Locale;

public class SearchPage {
    private WebDriver driver;
    private final By productsTitle = By.xpath("//h2[@class='product-title']");
    private final By searchBar = By.xpath("//input[@id='q']");
    private final By productLink = By.xpath("//h2[@class='product-title']//a");

    public SearchPage(WebDriver driver){
        this.driver = driver;
    }

    /**
     * @Steps to search for item
     * And Confirm the results contain the searched word
     * if you want more advanced search with tags use method 2 in your test
     */
    public boolean searchResultsIfContainTheWord(){
        boolean visible = true;
        String searched = findElement(searchBar).getAttribute("value");
        List<WebElement> searchResults = findElements(productsTitle);
        for(int i = 0; i < searchResults.size(); i++){
            if(!searchResults.get(i).getText().toLowerCase(Locale.ROOT).contains(searched.toLowerCase())){
                visible = false;
                break;
            }
        }
        return visible;
    }

    /**
     * @Steps to search for item
     * And Confirm the results contain the searched word
     * And if the result doesn't contain the word
     * You can compare the tags at the product page
     */
    public ProductPage searchResultsIfNotContainTheWord(){
        String searched = findElement(searchBar).getAttribute("value");
        List<WebElement> searchResults = findElements(productsTitle);
        List <WebElement> productsLinks = findElements(productLink);
        for(int i = 0; i < searchResults.size(); i++){
            if(!searchResults.get(i).getText().toLowerCase(Locale.ROOT).contains(searched.toLowerCase())){
                String clickLink = Keys.chord(Keys.CONTROL, Keys.ENTER);
                productsLinks.get(i).sendKeys(clickLink);
            }
        }
        return new ProductPage(driver);
    }

    public WebElement findElement(By by){
        var webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
    public List<WebElement> findElements(By by){
        var webDriverWait = new WebDriverWait(driver,Duration.ofSeconds(10));
        return webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }
}
