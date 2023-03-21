package wishlist;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WishListTests extends BaseTests {

    @Test
    public void testAddingItemAndCheckingCount(){
        var productPage = homePage.AddProduct1ToWishBtn();
        productPage.fillInfoAndAddForProduct1();
        productPage.clickAddToWishBtn();

        String successMsg = productPage.successMsgText();
        Assert.assertTrue(successMsg.contains("The product has been added to your"),"Item wasn't successfully Added");

        productPage.closeSuccessMsg();

        String wishItemsQuantity= productPage.getWishItemsQuantity();
        Assert.assertTrue(wishItemsQuantity.contains("1"),"Items count incorrect");
    }
    @Test
    void testAddingItemAndCheckingWishListPage(){
        var productPage = homePage.AddProduct1ToWishBtn();
        productPage.fillInfoAndAddForProduct1();
        productPage.clickAddToWishBtn();
        productPage.closeSuccessMsg();
        var wishListPage = productPage.clickWishListPageBtn();

       String expectedProductName = "Build your own computer";
       String actualProductName = wishListPage.productName();
       Assert.assertTrue(actualProductName.contains(expectedProductName),"Incorrect Product name");

        String expectedProductSpecs = "Processor: 2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]";

        String actualProductSpecs = wishListPage.productSpecifications();
        Assert.assertTrue(actualProductSpecs.contains(expectedProductSpecs),"Incorrect Product specifications");

        String expectedProductQty = "1";
        String actualProductQty = wishListPage.quantityNumber();
        Assert.assertTrue(actualProductQty.contains(expectedProductQty),"Incorrect Product quantity");

        String expectedProductPrice = "$1,455.00";
        String actualProductPrice = wishListPage.productPrice();
        Assert.assertTrue(actualProductPrice.contains(expectedProductPrice),"Incorrect Product price");

        String expectedProductTotalPrice = "$1,455.00";
        String actualProductTotalPrice = wishListPage.totalPrice();
        Assert.assertTrue(actualProductTotalPrice.contains(expectedProductTotalPrice),"Incorrect Product total price");
    }
}
