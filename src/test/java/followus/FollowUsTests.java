package followus;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class FollowUsTests extends BaseTests {

    @Test
    public void followUsTest(){
        var followUsPage = homePage.clickFaceBookBtn();
        homePage.clickTwitterBtn();
        homePage.clickYouTubeBtn();
        String faceBookTitle = "Facebook";
        String twitterTitle = "Twitter";
        String youTubeTitle = "YouTube";
        List<String> pagesTitles = followUsPage.getWindowsTitles();
        Assert.assertTrue(pagesTitles.stream().anyMatch(str -> str.contains(faceBookTitle)),"Facebook page isn't opened");
        Assert.assertTrue(pagesTitles.stream().anyMatch(str -> str.contains(twitterTitle)),"Twitter page isn't opened");
        Assert.assertTrue(pagesTitles.stream().anyMatch(str -> str.contains(youTubeTitle)),"Youtube page isn't opened");
    }
}
