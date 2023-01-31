package org.selenium.pom.tests;

import org.selenium.pom.base.BaseTest;
import org.selenium.pom.objects.User;
import org.selenium.pom.pages.InventoryPage;
import org.selenium.pom.pages.LoginPage;
import org.selenium.pom.utils.ConfigLoader;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;


public class AddItemTestCase extends BaseTest {
    @Test
    public void addItemAndRemoveItemTest(){
        User user = new User(ConfigLoader.getInstance().getUsername(), ConfigLoader.getInstance().getPassword());
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.load();
        loginPage.doLogin(user.getUsername(), user.getPassword());
        InventoryPage inventoryPage = new InventoryPage(getDriver());
        inventoryPage.addItem();
        assertTrue(inventoryPage.isItemAdded());
        inventoryPage.removeItem();
        assertTrue(inventoryPage.isItemRemoved());
    }
}
