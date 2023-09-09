package com.saucedemo.test.pages;

import com.saucedemo.test.Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage extends BaseTest {
    @FindBy(css = "#user-name")
    WebElement userNameEl;

    @FindBy(css = "#password")
    WebElement passwordEl;

    @FindBy(css = "#login-button")
    WebElement loginBtnEl;

    public LogInPage() {
        PageFactory.initElements(driver, this);
    }

    public LogInPage fillUserName(String userName) {
        userNameEl.isDisplayed();
        userNameEl.clear();
        userNameEl.sendKeys(userName);
        return this;
    }

    public LogInPage fillPassword(String password) {
        passwordEl.isDisplayed();
        passwordEl.clear();
        passwordEl.sendKeys(password);
        return this;
    }

    public InventoryPage clickLogInBtn() {
        loginBtnEl.isDisplayed();
        loginBtnEl.click();
        return new InventoryPage();
    }
}
