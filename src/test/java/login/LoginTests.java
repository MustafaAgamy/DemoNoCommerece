package login;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTests {

    @Test
    public void loginMaleTest(){
        var loginPage = homePage.clickLoginBtn();

        String resultTitle = loginPage.getPageMsg();
        String pageTitle = "Welcome, Please Sign In!";
        Assert.assertEquals(resultTitle,pageTitle,"PageTitle is incorrect");

        loginPage.fillLoginInfo("adamsmith@gmail.com","adam123");
        var homePage = loginPage.clickConfLoginBtn();

        String welcomeMsg = homePage.getWelcomeMsg();
        String welcomeMsgText = "Welcome to our store";
        Assert.assertEquals(welcomeMsg,welcomeMsgText,"You're not on HomePage");

        homePage.clickLogoutBtn();
        Assert.assertEquals(welcomeMsg,welcomeMsgText,"You're not on HomePage");
    }

    @Test
    public void loginFemaleTest(){
        var loginPage = homePage.clickLoginBtn();

        String resultTitle = loginPage.getPageMsg();
        String pageTitle = "Welcome, Please Sign In!";
        Assert.assertEquals(resultTitle,pageTitle,"PageTitle is incorrect");

        loginPage.fillLoginInfo("monicasmith@gmail.com","monica123");
        var homePage = loginPage.clickConfLoginBtn();

        String welcomeMsg = homePage.getWelcomeMsg();
        String welcomeMsgText = "Welcome to our store";
        Assert.assertEquals(welcomeMsg,welcomeMsgText,"You're not on HomePage");

        homePage.clickLogoutBtn();
        Assert.assertEquals(welcomeMsg,welcomeMsgText,"You're not on HomePage");
    }
}
