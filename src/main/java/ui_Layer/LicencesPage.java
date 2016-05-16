package ui_Layer;

import core.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Factory;

import java.util.List;

import static core.Utils.getCurrentURL;
import static core.Utils.waitSleep;

/**
 * Created by Антон on 10.04.2016.
 */
public class LicencesPage extends PageFactorySettings {

    @FindBy(xpath = "//button[@ng-click='toggleSearch()']")
    private WebElement openSearchOption;

    @FindBy(xpath = "//input[@id='search-input']")
    private WebElement searchFiled;

    @FindBy(xpath = "//div[@class='ui-grid-row ng-scope ui-grid-row-selected']//div[4]/div")
    private WebElement nameColumn;

    @FindBy(xpath = "//div[@data-title='Add']")
    private WebElement addLicenceBtn;

    @FindBy(xpath = "//span[@class='select2-chosen ng-binding']")
    private WebElement selectVehicleLink;

    @FindBy(xpath = "//input[@aria-label='Choose a vehicle']")
    private WebElement inputVehicleField;

    @FindBy(xpath = "//div[@ng-bind='item.displayName']")
    private List<WebElement> vehicleList;

    @FindBy(xpath = "(//input[@id='lnumber'])[2]")
    private WebElement licenceNfield;

    @FindBy(xpath = ".//*[@id='purchaseDate']")
    private WebElement dateField;

    @FindBy(xpath = ".//*[@id='purchaseTime']")
    private WebElement timeField;

    @FindBy(xpath = ".//*[@id='minKm']")
    private WebElement minDistanceField;

    @FindBy(xpath = ".//*[@id='maxKm']")
    private WebElement maxDistanceField;

    @FindBy(xpath = ".//*[@id='notes']")
    private WebElement notesField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitBtn;

    @FindBy(xpath = "//div[@class='alert alert-container-top-right']")
    private WebElement messageContainer;

    @FindBy(xpath = "//strong[@ng-bind='title']")
    private WebElement title;

    @FindBy(xpath = "//span[@ng-bind-html='content']")
    private WebElement content;


    private WebDriverWait wait = new WebDriverWait(Driver.get(), 35);

    public static LicencesPage open() {
        Driver.get().get(System.getProperty("test.licencesPage"));
        System.out.println(getCurrentURL());
        Assert.assertEquals(getCurrentURL(), System.getProperty("test.licencesPage"), "Current URL is not as expected");
        return new LicencesPage();
    }

    public void searchLicences(String searchValue) {
        wait.until(ExpectedConditions.elementToBeClickable(openSearchOption));
        openSearchOption.click();
        wait.until(ExpectedConditions.visibilityOf(searchFiled)).sendKeys(searchValue);
        waitSleep(500);
    }

    public String getLicenceName() {
      return nameColumn.getText();
    }

    public void checkSearchResult(String expLicenseName) {
        Assert.assertEquals(getLicenceName(), expLicenseName, "Name was not as expected");
    }

    public void clickAddLicenceBtn() {
        wait.until(ExpectedConditions.visibilityOf(addLicenceBtn)).click();
    }

    public void clickSelectVehicle() {
        wait.until(ExpectedConditions.visibilityOf(selectVehicleLink)).click();
    }

    public void choseVehicle(String vehicleValue) {
        wait.until(ExpectedConditions.visibilityOf(inputVehicleField));
        inputVehicleField.sendKeys(vehicleValue);
        waitSleep(5000);
        for (WebElement element : vehicleList) {
            if (element.getText().equals(vehicleValue)) {
                element.click();
            }
        }
    }

    public void fillLicenceForm(String licenceN, String dateValue, String timeValue, String minDistValue, String maxDistVlaue, String notesValue) {
        wait.until(ExpectedConditions.visibilityOf(licenceNfield));
        licenceNfield.sendKeys(licenceN);
        dateField.sendKeys(dateValue);
        timeField.sendKeys(timeValue);
        minDistanceField.sendKeys(minDistValue);
        maxDistanceField.sendKeys(maxDistVlaue);
        notesField.sendKeys(notesValue);
        submitBtn.click();
    }

    public String getSuccessfullMessageCreated() {
        wait.until(ExpectedConditions.visibilityOf(messageContainer));
        String titleText = title.getText();
        String contentText = content.getText();
        return titleText + " " + contentText;
    }

    public void checkLicenceCreated() {
        Assert.assertEquals(getSuccessfullMessageCreated(), "Licence was successfully added.", "Licence was not created");
        System.out.println(getSuccessfullMessageCreated());
    }

}
