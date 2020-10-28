package selenium;
import data.FormPageAdapter;
import data.FormPageDTO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;
import pages.ConfirmationPage;
import pages.FormPage;

import java.util.Date;

public class WebForm {
    private static final String WEBDRIVER_PARAM_NAME = "webdriver.chrome.driver";
    private static final String WEBDRIVER_PATH = "C:\\Tools\\chromedriver\\chromedriver85.exe";
    private static final String PAGE_URL = "https://formy-project.herokuapp.com/form";

    public static void main(String[] args) {

        System.setProperty(WEBDRIVER_PARAM_NAME, WEBDRIVER_PATH);

        WebDriver driver = new ChromeDriver();
        driver.get(PAGE_URL);
        //TODO 1. transformacja daty
        // 2. utworzyć kolekcję objektów typu FormPageDTO

        FormPageDTO testCasesDTO = new FormPageDTO("Jola", "Szostak-Marciniak", "QA Tester", "High School", "Female", 7, new Date());

        FormPageAdapter testCasesAdapter = new FormPageAdapter();

        FormPage.submitForm(driver, testCasesDTO, testCasesAdapter);

        ConfirmationPage.waitForAlert(driver);

        String expectedAlertText = "The form was successfully submitted!";
        String actualAlertText = ConfirmationPage.getAlertBannerText(driver);

        driver.quit();

        Assert.assertEquals(expectedAlertText, actualAlertText);
        //Assert.assertEquals(wrongAlertText, alertText);

    }
}
