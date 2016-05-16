package core;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTestSettings {

    @BeforeClass
    protected void init() {
        Driver.init();
    }


    @AfterClass
    protected void cleanup() {
        Driver.tearDown();
    }
}
