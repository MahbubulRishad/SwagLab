package com.saucedemo.test.testCases;

import com.saucedemo.test.Base.BaseTest;
import com.saucedemo.test.pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {
    LogInPage logInPage;
    InventoryPage inventoryPage;
    InventoryItemPage inventoryItemPage;
    CartPage cartPage;
    CheckoutStepOnePage checkoutStepOnePage;

    public CartTest() {
        super();
    }

    @BeforeMethod
    public void init() {
        setUpBrowser();
        logInPage = new LogInPage();
        inventoryPage = logInPage
                .login(getUserName(), getPassword());
    }

    @Test
    public void checkYourCartDetailsShouldSuccessful() {
        cartPage = inventoryPage
                .clickProductDetailsLink()
                .clickAddToCartBtn()
                .clickShoppingCartBox();

        Assert.assertTrue(cartPage.isDisplayYourCartTextEl());
    }

    @Test
    public void checkoutBtnShouldProperlyWork(){
        checkoutStepOnePage = inventoryPage
                .clickProductDetailsLink()
                .clickAddToCartBtn()
                .clickShoppingCartBox()
                .clickCheckoutBtn();

        Assert.assertTrue(checkoutStepOnePage.isDisplayFirstNameInputField());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
