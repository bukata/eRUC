package core;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Utils {

    private WebDriverWait wait = new WebDriverWait(Driver.get(), 35);

    public static boolean isElementPresent(By locator) {
        Driver.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        List<WebElement> elements = Driver.get().findElements(locator);
        Driver.get().manage().timeouts().implicitlyWait(Integer.parseInt(System.getProperty("test.timeout")), TimeUnit.SECONDS);
        return elements.size() > 0 && elements.get(0).isDisplayed();
    }

    public static String getCurrentURL() {
        return Driver.get().getCurrentUrl();
    }

    public static void clickJS(WebElement someButton) {
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].click();", someButton);
    }


    public static void setTextJS(WebElement someField, String someText) {
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].value='" + someText + "';", someField);
    }

    public static void viewElementJS(WebElement element) {
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].scrollIntoView(true);", element);
        WebElement wait  = (new WebDriverWait(Driver.get(), 35)).until(ExpectedConditions.visibilityOf(element));
    }


    public static void waitSleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ignore) {
        }
    }

    public static String genRandomNum(int digitquantity){
        int min = 0;
        int max = 0;

        Random r = new Random();
        switch (digitquantity){
            case (1):
                min = 1;
                max = 9;
                break;
            case (2):
                min = 11;
                max = 99;
                break;
            case (3):
                min = 101;
                max = 999;
                break;
            case (4):
                min = 1001;
                max = 9999;
                break;
            case (5):
                min = 10001;
                max = 99999;
                break;
            case (6):
                min = 100001;
                max = 999999;
                break;
            case (7):
                min = 1000001;
                max = 9999999;
                break;
            case (8):
                min = 10000001;
                max = 99999999;
                break;
            case (9):
                min = 100000001;
                max = 999999999;
                break;
        }
        int random = r.nextInt((max - min) + 1) + min;
        return  String.valueOf(random);

    }



}

