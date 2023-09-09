package com.saucedemo.test.testCases;

import com.saucedemo.test.Base.BaseTest;
import com.saucedemo.test.pages.InventoryItemPage;
import com.saucedemo.test.pages.InventoryPage;
import com.saucedemo.test.pages.LogInPage;
import com.saucedemo.test.util.General;
import org.testng.Assert;
import org.testng.annotations.*;

public class InventoryItemTest extends BaseTest {
    LogInPage logInPage;
    InventoryPage inventoryPage;
    InventoryItemPage inventoryItemPage;

    public InventoryItemTest() {
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
    public void removeBtnShouldBeVisible() {
        inventoryItemPage = inventoryPage
                .clickProductDetailsLink()
                .clickAddToCartBtn();

        Assert.assertTrue(inventoryItemPage.checkRemoveBtn());
    }

    @Test
    public void shoppingCartShouldDisplay(){
        inventoryItemPage = inventoryPage
                .clickProductDetailsLink()
                .clickAddToCartBtn();

        Assert.assertTrue(inventoryItemPage.isDisplayShoppingCartBadge());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
