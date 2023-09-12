package com.saucedemo.test.pages;

import com.saucedemo.test.Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutComplete extends BaseTest {
    @FindBy(css = ".complete-header")
    WebElement orderSuccessTextEl;

    @FindBy(css = "#back-to-products")
    WebElement backToHomeBtnEl;

    public CheckoutComplete(){
        PageFactory.initElements(driver, this);
    }
    public boolean orderSuccessText(){
        return orderSuccessTextEl.isDisplayed();
    }
}
