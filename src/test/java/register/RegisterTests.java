package register;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTests extends BaseTests {

    @Test
    public void registerMaleTest(){
        var registerPage = homePage.clickRegisterBtn();
        registerPage.fillRegisterInfoMale("Adam","Smith","27","7","1995",
                "adamsmith@gmail.com", "adam123","adam123");
        var registerConfirmPage = registerPage.clickConfRegister();

        String resultMsg = registerConfirmPage.getResultMsg();
        String resultMsgText = "Your registration completed";
        Assert.assertEquals(resultMsg,resultMsgText,"Result Message incorrect");

        var homePage = registerConfirmPage.clickContinueBtn();

        String welcomeMsg = homePage.getWelcomeMsg();
        String welcomeMsgText = "Welcome to our store";
        Assert.assertEquals(welcomeMsg,welcomeMsgText,"You're not on HomePage");
    }

    @Test
    public void registerFemaleTest(){
        var registerPage = homePage.clickRegisterBtn();
        registerPage.fillRegisterInfoFeMale("Monica","Smith","20","7","1995",
                "monicasmith@gmail.com","monica123","monica123");
        var registerConfirmPage = registerPage.clickConfRegister();

        String resultMsg = registerConfirmPage.getResultMsg();
        String resultMsgText = "Your registration completed";
        Assert.assertEquals(resultMsg,resultMsgText,"Result Message incorrect");

        var homePage = registerConfirmPage.clickContinueBtn();

        String welcomeMsg = homePage.getWelcomeMsg();
        String welcomeMsgText = "Welcome to our store";
        Assert.assertEquals(welcomeMsg,welcomeMsgText,"You're not on HomePage");
    }
}
