package com.saucedemo.test.testCases;

import com.saucedemo.test.Base.BaseTest;
import com.saucedemo.test.pages.InventoryPage;
import com.saucedemo.test.pages.LogInPage;
import com.saucedemo.test.util.General;
import org.testng.Assert;
import org.testng.annotations.*;

public class LogInTest extends BaseTest {
    LogInPage logInPage;
    InventoryPage inventoryPage;

    public LogInTest() {
        super();
    }

    @BeforeMethod
    public void init(){
        setUpBrowser();
    }

    @Test
    public void logInShouldFailOnlyUserName(){
        logInPage = new LogInPage();
        logInPage
                .fillUserName(getUserName())
                .clickLogInBtn();

        Assert.assertTrue(logInPage.hasErrorMessageDisplayed());
    }

    @Test
    public void logInShouldFailOnlyPassword(){
        logInPage = new LogInPage();
        logInPage
                .fillPassword(getPassword())
                .clickLogInBtn();

        Assert.assertTrue(logInPage.hasErrorMessageDisplayed());
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

    @AfterMethod
    public void tearDown(){
        General.domStable();
        driver.quit();
    }
}
