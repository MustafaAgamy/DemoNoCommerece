package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActionsPage {


    /**
     * @Info This page contains actions you can use in your pages
     * If you want to include it in your pages do one of the following:
     * 1- make the methods static
     * 2- make page classes extend it
     */
    protected WebElement find(WebDriver driver, By locator){
        return driver.findElement(locator);
    }
    protected String getText(WebDriver driver, By locator){
        return driver.findElement(locator).getText();
    }

    protected void click(WebDriver driver, By locator){

        find(driver, locator).click();
    }

    protected void clearInput(WebDriver driver, By locator){
        find(driver,locator).clear();
    }

    protected void type(WebDriver driver, By locator, String value){
        find(driver, locator).sendKeys(value);
    }

}
