package com.saucedemo.test.testCases;

import com.saucedemo.test.Base.BaseTest;
import com.saucedemo.test.pages.InventoryPage;
import com.saucedemo.test.pages.LogInPage;
import com.saucedemo.test.util.General;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LogInTest extends BaseTest {
    LogInPage logInPage;
    InventoryPage inventoryPage;

    public LogInTest() {
        super();
    }

    @BeforeClass
    public void init(){
        setUpBrowser();
    }

    @Test
    public void logInShouldSuccessful(){
        logInPage = new LogInPage();
        inventoryPage = logInPage
                .fillUserName(getUserName())
                .fillPassword(getPassword())
                .clickLogInBtn();

        Assert.assertTrue(inventoryPage.isDisplayedProductText());
    }

    @AfterClass
    public void tearDown(){
        General.domStable();
        driver.quit();
    }
}
