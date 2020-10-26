package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import pages.ConfirmationPage;
import pages.FormPage;

public class WebForm {
    private static final String WEBDRIVER_PARAM_NAME = "webdriver.chrome.driver";
    private static final String WEBDRIVER_PATH = "C:\\Tools\\chromedriver\\chromedriver85.exe";
    private static final String PAGE_URL = "https://formy-project.herokuapp.com/form";

    public static void main(String[] args) {

        System.setProperty(WEBDRIVER_PARAM_NAME, WEBDRIVER_PATH);

        WebDriver driver = new ChromeDriver();
        driver.get(PAGE_URL);

        FormPage.submitForm(driver);

        ConfirmationPage.waitForAlert(driver);

        String expectedAlertText = "The form was successfully submitted!";
        String actualAlertText = ConfirmationPage.getAlertBannerText(driver);

        driver.quit();

        Assert.assertEquals(expectedAlertText, actualAlertText);
        //Assert.assertEquals(wrongAlertText, alertText);

    }
}
