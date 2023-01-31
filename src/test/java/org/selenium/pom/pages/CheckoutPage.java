package org.selenium.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.objects.YourInformation;

public class CheckoutPage extends BasePage {

    @FindBy(id = "first-name") WebElement firstNameField;
    @FindBy(id = "last-name") WebElement lastNameField;
    @FindBy(id = "postal-code") WebElement zipPostalCodeField;
    @FindBy(id = "continue") WebElement continueButton;

    public CheckoutPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public CheckoutPage enterFirstName(String firstName){
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
        return this;
    }

    public CheckoutPage enterLastName(String lastName){
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
        return this;
    }

    public CheckoutPage enterZipPostalCode(String zipPostalCode){
        zipPostalCodeField.clear();
        zipPostalCodeField.sendKeys(zipPostalCode);
        return this;
    }

    public CheckoutPage setYourInformation(YourInformation yourInformation){
        return  enterFirstName(yourInformation.getFirstName()).
                enterLastName(yourInformation.getLastName()).
                enterZipPostalCode(yourInformation.getZipPostalCode());
    }

    public CheckoutPage placeOrder(){
        continueButton.click();
        return this;
    }
}
