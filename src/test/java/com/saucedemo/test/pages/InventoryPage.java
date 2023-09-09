package com.saucedemo.test.pages;

import com.saucedemo.test.Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage extends BaseTest {
    @FindBy(css = ".title")
    WebElement productsTextEl;

    public InventoryPage(){
        PageFactory.initElements(driver, this);
    }

    public boolean isDisplayedProductText(){
        return productsTextEl.isDisplayed();
    }
}
