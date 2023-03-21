package base;

import com.google.common.io.Files;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class BaseTests {
    private WebDriver driver;
    protected HomePage homePage;

    /** THIS IS THE BASE_TEST FOR THE TEST CLASSES MAKE SURE TO INHERIT IN YOUR TEST CLASSES **
     * @setUp to initialize the Driver
     * @goHome to navigate to the url (change depending on your test)
     * @tearDown to Close the Driver
     * @ChromeOptions is Added for Fixing a recent bug with the latest Chrome version
     */

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driver = new ChromeDriver(getChromeOptions());
        driver.manage().window().maximize();
        goHome();
    }

    @BeforeMethod
    public void goHome(){
        driver.navigate().to("https://demo.nopcommerce.com/");
        homePage =new HomePage(driver);
    }

    @AfterMethod
    public void recordFailure(ITestResult result){

        if(ITestResult.FAILURE == result.getStatus()){
            var camera = (TakesScreenshot)driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot,new File("reports/screenshots" + result.getName() + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }



    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        return options;
    }


}
