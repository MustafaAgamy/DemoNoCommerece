package pages.FollowUs;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FollowUsPage {
    private WebDriver driver;

    public FollowUsPage(WebDriver driver){
        this.driver = driver;
    }


    /**
     * @Steps to open the follow us links
     * And Confirm the right links are opened in a new tabs
     * Notice that one of the follow options is broken if you want to include it
     * You must know that the Assertion for it will fail
     * That's why it's not included here
     */
    public List<String > getWindowsTitles(){
        List<String> pagesTitles = new ArrayList<>();
        var mainWindow = driver.getWindowHandle();
        var newWindows = driver.getWindowHandles();
        Iterator<String> iterator = newWindows.iterator();
            for (int i = 0; i < newWindows.size(); i++){
                String newWindow = iterator.next();
                if(!mainWindow.equals(newWindow)){

                String pageTitle = driver.switchTo().window(newWindow).getTitle();
                pagesTitles.add(pageTitle);
            }
        }
            return pagesTitles;
    }
}
