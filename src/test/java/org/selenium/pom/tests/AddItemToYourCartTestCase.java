package org.selenium.pom.tests;

import org.selenium.pom.base.BaseTest;
import org.selenium.pom.objects.User;
import org.selenium.pom.pages.InventoryPage;
import org.selenium.pom.pages.LoginPage;
import org.selenium.pom.pages.YourCartPage;
import org.selenium.pom.utils.ConfigLoader;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AddItemToYourCartTestCase extends BaseTest {
    @Test
    public void addItemToYourCartTest(){
        User user = new User(ConfigLoader.getInstance().getUsername(), ConfigLoader.getInstance().getPassword());
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.load();
        loginPage.doLogin(user.getUsername(), user.getPassword());

        InventoryPage inventoryPage = new InventoryPage(getDriver());
        String productName = "Sauce Labs Backpack";
        inventoryPage.
                addItemByImage().
                addItem();
        assertTrue(inventoryPage.isItemAdded());
        assertEquals(inventoryPage.getProductName(), productName);

        YourCartPage yourCartPage = new YourCartPage(getDriver());
        yourCartPage.navigateToYourCart();
        assertEquals(yourCartPage.getProductName(), productName);
    }
}
