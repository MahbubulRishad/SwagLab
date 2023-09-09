package com.saucedemo.test.pages;

import com.saucedemo.test.Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutStepOnePage extends BaseTest {
    @FindBy(css = "#first-name")
    WebElement inputFirstNameEl;

    public CheckoutStepOnePage(){
        PageFactory.initElements(driver, this);
    }
    public boolean isDisplayFirstNameInputField(){
        return inputFirstNameEl.isDisplayed();
    }
}
