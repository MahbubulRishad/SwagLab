package com.saucedemo.test.pages;

import com.saucedemo.test.Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutStepOnePage extends BaseTest {
    @FindBy(css = "#first-name")
    WebElement inputFirstNameEl;

    @FindBy(css = "#last-name")
    WebElement inputLastNameEl;

    @FindBy(css = "#postal-code")
    WebElement inputPostalCodeEl;

    @FindBy(css = "#continue")
    WebElement continueBtnEl;

    public CheckoutStepOnePage(){
        PageFactory.initElements(driver, this);
    }
    public boolean isDisplayFirstNameInputField(){
        return inputFirstNameEl.isDisplayed();
    }

    public CheckoutStepOnePage fillFirstName(String inputFirstName){
        inputFirstNameEl.isDisplayed();
        inputFirstNameEl.clear();
        inputFirstNameEl.sendKeys(inputFirstName);
        return this;
    }

    public CheckoutStepOnePage fillLastName(String inputLastName){
        inputLastNameEl.isDisplayed();
        inputLastNameEl.clear();
        inputLastNameEl.sendKeys(inputLastName);
        return this;
    }

    public CheckoutStepOnePage fillPostalCode(String postalCode){
        inputPostalCodeEl.isDisplayed();
        inputPostalCodeEl.clear();
        inputPostalCodeEl.sendKeys(postalCode);
        return this;
    }

    public CheckoutStepTwoPage clickContinueBtn(){
        continueBtnEl.isDisplayed();
        continueBtnEl.click();
        return new CheckoutStepTwoPage();
    }
}
