package com.saucedemo.test.pages;

import com.saucedemo.test.Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutStepTwoPage extends BaseTest {
    @FindBy(css = "#finish")
    WebElement finishBtnEl;

    public CheckoutStepTwoPage(){
        PageFactory.initElements(driver, this);
    }
    public CheckoutComplete clickFinishBtn(){
        finishBtnEl.isDisplayed();
        finishBtnEl.click();
        return new CheckoutComplete();
    }
    public boolean isDisplayedFinishBtn(){
        return finishBtnEl.isDisplayed();
    }
}
