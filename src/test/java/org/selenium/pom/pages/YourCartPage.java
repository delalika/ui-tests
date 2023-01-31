package org.selenium.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.selenium.pom.base.BasePage;

public class YourCartPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a") WebElement yourCartButton;
    @FindBy(id = "item_4_title_link") WebElement productNameField;
    @FindBy(id = "checkout") WebElement checkoutButton;

    public YourCartPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getProductName(){ return productNameField.getText(); }

    public YourCartPage navigateToYourCart(){
        yourCartButton.click();
        return this;
    }

    public YourCartPage checkout(){
        checkoutButton.click();
        return this;
    }
}
