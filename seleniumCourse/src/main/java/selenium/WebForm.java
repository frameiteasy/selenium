package selenium;
import data.FormPageAdapter;
import data.FormPageDTO;
import data.TestCasesCollection;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;
import pages.ConfirmationPage;
import pages.FormPage;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WebForm {
    private static final String WEBDRIVER_PARAM_NAME = "webdriver.chrome.driver";
    private static final String WEBDRIVER_PATH = "C:\\Tools\\chromedriver\\chromedriver85.exe";
    private static final String PAGE_URL = "https://formy-project.herokuapp.com/form";

    public static void main(String[] args) {

        System.setProperty(WEBDRIVER_PARAM_NAME, WEBDRIVER_PATH);

        WebDriver driver = new ChromeDriver();
        driver.get(PAGE_URL);

        FormPageAdapter testCasesAdapter = new FormPageAdapter();

        TestCasesCollection firstCollection = new TestCasesCollection();

        for(FormPageDTO testCase : firstCollection.getTestCasesList() ){
            System.out.println("First name: " + testCase.getFirstName() + " Last name: " + testCase.getLastName() );
            FormPage.submitForm(driver, testCase, testCasesAdapter);
            ConfirmationPage.waitForAlert(driver);
            String expectedAlertText = "The form was successfully submitted!";
            String actualAlertText = ConfirmationPage.getAlertBannerText(driver);

            Assert.assertEquals(expectedAlertText, actualAlertText);
            driver.get(PAGE_URL);
        }

        driver.quit();
    }
}
