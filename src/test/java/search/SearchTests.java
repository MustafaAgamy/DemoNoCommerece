package search;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
public class SearchTests extends BaseTests {

    @Test
    public void searchTestWithContainedWord(){
        String search = "bracelet";
        homePage.searchInput(search);
        var searchPage = homePage.clickSearchBtn();
        Assert.assertTrue(searchPage.searchResultsIfContainTheWord(),"Incorrect search results");
    }

    @Test
    public void searchTestWithContainedWordAndTags(){
        String search = "book";
        homePage.searchInput(search);
        var searchPage = homePage.clickSearchBtn();
        var productPage = searchPage.searchResultsIfNotContainTheWord();
        Assert.assertTrue(productPage.switchToTabAndCompareProductsTags("computer","laptop","book"),
                "Incorrect search results");
    }
}
