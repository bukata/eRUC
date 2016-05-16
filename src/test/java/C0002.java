import core.BaseTestSettings;
import org.testng.annotations.Test;
import ui_Layer.LicencesPage;
import ui_Layer.LoginPage;
import ui_Layer.UserPage;

import static core.Utils.genRandomNum;

/**
 * Created by Антон on 08.05.2016.
 */
public class C0002 extends BaseTestSettings {

    private LoginPage loginPage;
    private UserPage userPage;
    private LicencesPage licencesPage;

    String licenceN = genRandomNum(9);

    @Test
    public void addLicence() {
        loginPage = new LoginPage();
        licencesPage = new LicencesPage();
        userPage = new UserPage();
        LoginPage.open();
        loginPage.logIn("QA", "QA2016");
        userPage.clickLicences();
        licencesPage.clickAddLicenceBtn();
        licencesPage.clickSelectVehicle();
        licencesPage.choseVehicle("Brett Armour");
        licencesPage.fillLicenceForm(licenceN, "08/05/2016", "22:26", "300", "500", "autoTest");
        licencesPage.checkLicenceCreated();
    }
}
