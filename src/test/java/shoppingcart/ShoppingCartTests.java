package shoppingcart;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShoppingCartTests extends BaseTests {

    @Test
    public void testAddingItemAndCheckingCount(){
        var productPage = homePage.AddProduct1ToCartBtn();
        productPage.fillInfoAndAddForProduct1();
        productPage.clickAddToCartBtn();

        String successMsg = productPage.successMsgText();
        Assert.assertTrue(successMsg.contains("The product has been added to your"),"Item wasn't successfully Added");

        productPage.closeSuccessMsg();

        String cartItemsQuantity = productPage.getCartItemsQuantity();
        Assert.assertTrue(cartItemsQuantity.contains("1"),"Items count incorrect");
    }
    @Test
    public void testAddingItemAndCheckingCartPage(){
        var productPage = homePage.AddProduct1ToCartBtn();
        productPage.fillInfoAndAddForProduct1();
        productPage.clickAddToCartBtn();
        productPage.closeSuccessMsg();
        var shoppingCartPage = productPage.clickCartPageBtn();

        String expectedProductName = "Build your own computer";
        String actualProductName = shoppingCartPage.productName();
        Assert.assertTrue(actualProductName.contains(expectedProductName),"Incorrect Product name");

        String expectedProductSpecs = "Processor: 2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]";

        String actualProductSpecs = shoppingCartPage.productSpecifications();
        Assert.assertTrue(actualProductSpecs.contains(expectedProductSpecs),"Incorrect Product specifications");

        String expectedProductQty = "1";
        String actualProductQty = shoppingCartPage.quantityNumber();
        Assert.assertTrue(actualProductQty.contains(expectedProductQty),"Incorrect Product quantity");

        String expectedProductPrice = "$1,455.00";
        String actualProductPrice = shoppingCartPage.productPrice();
        Assert.assertTrue(actualProductPrice.contains(expectedProductPrice),"Incorrect Product price");

        String expectedProductTotalPrice = "$1,455.00";
        String actualProductTotalPrice = shoppingCartPage.totalPrice();
        Assert.assertTrue(actualProductTotalPrice.contains(expectedProductTotalPrice),"Incorrect Product total price");
    }
}
