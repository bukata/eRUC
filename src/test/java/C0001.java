import core.BaseTestSettings;
import org.testng.annotations.Test;
import ui_Layer.LicencesPage;
import ui_Layer.LoginPage;
import ui_Layer.UserPage;

/**
 * Created by Антон on 10.04.2016.
 */
public class C0001 extends BaseTestSettings {

    private LoginPage loginPage;
    private UserPage userPage;
    private LicencesPage licencesPage;

    @Test
    public void testSearchLicencesName() {
        loginPage = new LoginPage();
        licencesPage = new LicencesPage();
        userPage = new UserPage();
        LoginPage.open();
        loginPage.logIn("QA", "QA2016");
        userPage.clickLicences();
        licencesPage.searchLicences("Brett Armour");
        licencesPage.checkSearchResult("Brett Armour");
    }


}
