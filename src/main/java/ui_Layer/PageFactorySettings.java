package ui_Layer;

import core.Driver;
import org.openqa.selenium.support.PageFactory;


public abstract class PageFactorySettings {

    protected PageFactorySettings() {
        PageFactory.initElements(Driver.get(), this);}

}
