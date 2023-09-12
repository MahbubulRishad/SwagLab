package com.saucedemo.test.testCases;

import com.saucedemo.test.Base.BaseTest;
import com.saucedemo.test.pages.CheckoutComplete;
import com.saucedemo.test.pages.CheckoutStepTwoPage;
import com.saucedemo.test.pages.InventoryPage;
import com.saucedemo.test.pages.LogInPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckoutStepTwoTest extends BaseTest {
    LogInPage logInPage;
    InventoryPage inventoryPage;
    CheckoutStepTwoPage checkoutStepTwoPage;
    CheckoutComplete checkoutComplete;

    public CheckoutStepTwoTest(){
        super();
    }

    @BeforeMethod
    public void init(){
        setUpBrowser();
        logInPage = new LogInPage();
        inventoryPage = logInPage.login(getUserName(), getPassword());
    }

    @Test
    public void orderShouldBeSuccessful(){
        checkoutComplete = inventoryPage
                .clickProductDetailsLink()
                .clickAddToCartBtn()
                .clickShoppingCartBox()
                .clickCheckoutBtn()
                .fillFirstName(getFirstName())
                .fillLastName(getLastName())
                .fillPostalCode(getPostalCode())
                .clickContinueBtn()
                .clickFinishBtn();

        Assert.assertTrue(checkoutComplete.orderSuccessText());
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
