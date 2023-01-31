package org.selenium.pom.base;

import org.openqa.selenium.WebDriver;
import org.selenium.pom.factory.DriverManager;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class BaseTest {
    private WebDriver driver;

    private void setDriver(WebDriver driver){
        this.driver = driver;
    }

    protected WebDriver getDriver(){
        return this.driver;
    }

    @Parameters("browser")
    @BeforeMethod
    public void startDriver(String browser){
        browser = System.getProperty("browser", browser);
        setDriver(new DriverManager().initializeDriver(browser));
    }

    @Parameters("browser")
    @AfterMethod
    public void quitDriver(String browser, ITestResult result){
        if (result.getStatus() == ITestResult.FAILURE){
            File testFile = new File("scr" + File.separator + browser + File.separator
                    + result.getTestClass().getRealClass().getSimpleName() + "_" +
                    result.getMethod().getMethodName() + ".png");
            takeScreenshot(testFile);
        }
        getDriver().quit();
    }


    private void takeScreenshot(File testFile){
        Screenshot screenshot = new AShot()
            .shootingStrategy(ShootingStrategies.viewportPasting(100))
                    .takeScreenshot(getDriver());
        try{
            ImageIO.write(screenshot.getImage(), "PNG", testFile);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
