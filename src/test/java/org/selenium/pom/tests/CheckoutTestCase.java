package org.selenium.pom.tests;

import org.selenium.pom.base.BaseTest;
import org.selenium.pom.objects.User;
import org.selenium.pom.objects.YourInformation;
import org.selenium.pom.pages.CheckoutPage;
import org.selenium.pom.pages.InventoryPage;
import org.selenium.pom.pages.LoginPage;
import org.selenium.pom.pages.YourCartPage;
import org.selenium.pom.utils.ConfigLoader;
import org.selenium.pom.utils.JacksonUtils;
import org.testng.annotations.Test;
import java.io.IOException;
import static org.testng.Assert.assertTrue;


public class CheckoutTestCase extends BaseTest {
    @Test
    public void checkoutTest() throws IOException {
        YourInformation yourInformation = JacksonUtils.deserializeJson(
                "yourInformation.json",
                YourInformation.class
        );

        User user = new User(ConfigLoader.getInstance().getUsername(), ConfigLoader.getInstance().getPassword());
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.
                load().
                doLogin(user.getUsername(), user.getPassword());

        InventoryPage inventoryPage = new InventoryPage(getDriver());
        inventoryPage.addItem();
        assertTrue(inventoryPage.isItemAdded());

        YourCartPage yourCartPage = new YourCartPage(getDriver());
        yourCartPage.
                navigateToYourCart().
                checkout();

        CheckoutPage checkoutPage = new CheckoutPage(getDriver());
        checkoutPage.
                setYourInformation(yourInformation).
                placeOrder();
    }
}
