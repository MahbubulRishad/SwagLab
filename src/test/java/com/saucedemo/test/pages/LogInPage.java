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

    @FindBy(css = "h3[data-test=\"error\"]")
    WebElement loginFailErrorTextEl;

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

    public InventoryPage login(String userName, String password) {
        fillUserName(userName);
        fillPassword(password);
        clickLogInBtn();
        return new InventoryPage();
    }

    public LogInPage login(String userName){
        fillUserName(userName);
        clickLogInBtn();
        return this;
    }

    public boolean hasErrorMessageDisplayed(){
        return loginFailErrorTextEl.isDisplayed();
    }
}
