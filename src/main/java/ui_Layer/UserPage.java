package ui_Layer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Антон on 10.04.2016.
 */
public class UserPage extends PageFactorySettings {

    @FindBy(xpath = "//div[text()='Licences']")
    private WebElement menuLicences;

    public void clickLicences() {
        menuLicences.click();
    }
}
