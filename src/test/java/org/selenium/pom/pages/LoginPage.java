package org.selenium.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.selenium.pom.base.BasePage;

public class LoginPage extends BasePage {
    @FindBy(id = "user-name") private WebElement usernameFld;
    @FindBy(id = "password") private WebElement passwordFld;
    @FindBy(id = "login-button") private WebElement loginBtn;

    public LoginPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public LoginPage load(){
        load("/");
        return this;
    }

    public LoginPage doLogin(String username, String password){
        usernameFld.sendKeys(username);
        passwordFld.sendKeys(password);
        loginBtn.click();
        return this;
    }

}
