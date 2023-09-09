package com.saucedemo.test.pages;

import com.saucedemo.test.Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BaseTest {
    @FindBy(css = "#checkout")
    WebElement checkoutBtnEl;

    @FindBy(css = ".header_secondary_container .title")
    WebElement yourCartTextEl;

    public CartPage() {
        PageFactory.initElements(driver, this);
    }

    public boolean isDisplayYourCartTextEl(){
        return yourCartTextEl.isDisplayed();
    }

    public CheckoutStepOnePage clickCheckoutBtn() {
        checkoutBtnEl.isDisplayed();
        checkoutBtnEl.click();
        return new CheckoutStepOnePage();
    }
}
