package com.saucedemo.test.pages;

import com.saucedemo.test.Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryItemPage extends BaseTest {

    @FindBy(css = "#add-to-cart-sauce-labs-backpack")
    WebElement addToCartBtnEl;

    @FindBy(css = "#shopping_cart_container .shopping_cart_link")
    WebElement shoppingCartBoxEl;

    @FindBy(css = "#remove-sauce-labs-backpack")
    WebElement removeBtnEl;

    @FindBy(css = ".shopping_cart_badge")
    WebElement shoppingCartBadgeEl;

    public InventoryItemPage() {
        PageFactory.initElements(driver, this);
    }

    public InventoryItemPage clickAddToCartBtn() {
        addToCartBtnEl.isDisplayed();
        addToCartBtnEl.click();
        return this;
    }

    public CartPage clickShoppingCartBox() {
        shoppingCartBoxEl.isDisplayed();
        shoppingCartBoxEl.click();
        return new CartPage();
    }

    public boolean checkRemoveBtn() {
        return removeBtnEl.isDisplayed();
    }

    public boolean isDisplayShoppingCartBadge() {
        return shoppingCartBadgeEl.isDisplayed();
    }
}
