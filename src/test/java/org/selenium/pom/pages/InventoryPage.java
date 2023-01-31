package org.selenium.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.selenium.pom.base.BasePage;

public class InventoryPage extends BasePage {

    @FindBy(id = "add-to-cart-sauce-labs-backpack") private WebElement addItemButton;
    @FindBy(id = "remove-sauce-labs-backpack") private WebElement removeItemButton;
    @FindBy(id = "item_4_img_link") private WebElement itemImage;
    @FindBy(xpath = "//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[1]") private WebElement productNameField;

    public InventoryPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isItemAdded() { return removeItemButton.isDisplayed(); }

    public boolean isItemRemoved() { return addItemButton.isDisplayed();}

    public String getProductName(){ return productNameField.getText(); }

    public InventoryPage addItem(){
        addItemButton.click();
        return this;
    }

    public InventoryPage removeItem(){
        removeItemButton.click();
        return this;
    }

    public InventoryPage addItemByImage(){
        itemImage.click();
        return this;
    }
}
