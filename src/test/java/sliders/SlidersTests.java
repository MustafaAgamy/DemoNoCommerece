package sliders;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SlidersTests extends BaseTests {

    @Test
    public void testSliders() throws InterruptedException {
        var slidersPage = homePage.switchToSliders();
        slidersPage.clickOnSliderSwitchAndCheckActivity();
        Assert.assertTrue(slidersPage.clickOnSliderSwitchAndCheckActivity(),"Assertion fail");
    }


}
