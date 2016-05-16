package ui_Layer;

import core.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static core.Utils.getCurrentURL;

/**
 * Created by Антон on 10.04.2016.
 */
public class LoginPage extends PageFactorySettings {

    @FindBy(xpath = "//input[@id='authNameVal']")
    private WebElement userNameFld;

    @FindBy(xpath = "//input[@id='authPasswordVal']")
    private WebElement passwordFld;

    @FindBy(xpath = "//input[@id='authSubmitButton']")
    private WebElement logInBtn;



    public static LoginPage open() {
        Driver.get().get(System.getProperty("test.LoginPage"));
        Assert.assertEquals(getCurrentURL(), System.getProperty("test.LoginPage"), "Current URL is not as expected");
        return new LoginPage();
    }

    public void setUsername(String nameValue) {
        userNameFld.sendKeys(nameValue);
    }

    public void setPassword(String passwordValue) {
        passwordFld.sendKeys(passwordValue);
    }

    public void logIn(String nameValue, String passwordValue) {
        setUsername(nameValue);
        setPassword(passwordValue);
        logInBtn.click();
    }
}
