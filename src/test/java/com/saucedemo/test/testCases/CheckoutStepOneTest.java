package com.saucedemo.test.testCases;

import com.saucedemo.test.Base.BaseTest;
import com.saucedemo.test.pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckoutStepOneTest extends BaseTest {
    LogInPage logInPage;
    InventoryPage inventoryPage;
    InventoryItemPage inventoryItemPage;
    CheckoutStepOnePage checkoutStepOnePage;
    CheckoutStepTwoPage checkoutStepTwoPage;

    public CheckoutStepOneTest() {
        super();
    }

    @BeforeMethod
    public void init() {
        setUpBrowser();
        logInPage = new LogInPage();
        inventoryPage = logInPage.login(getUserName(), getPassword());
    }

    @Test
    public void inputFieldsShouldBeFilledAndContinueOrder(){
        checkoutStepTwoPage = inventoryPage
                .clickProductDetailsLink()
                .clickShoppingCartBox()
                .clickCheckoutBtn()
                .fillFirstName(getFirstName())
                .fillLastName(getLastName())
                .fillPostalCode(getPostalCode())
                .clickContinueBtn();

        Assert.assertTrue(checkoutStepTwoPage.isDisplayedFinishBtn());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
