package tests;

import data.FormPageAdapter;
import data.FormPageDTO;
import data.TestCasesCollection;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ConfirmationPage;
import pages.FormPage;

public class WebFormTest {

    private static final int MAX_NUMBER_OF_TESTS = 5;

    private static final String WEBDRIVER_PARAM_NAME = "webdriver.chrome.driver";
    private static final String WEBDRIVER_PATH = "C:\\Tools\\chromedriver\\chromedriver85.exe";
    private static final String PAGE_URL = "https://formy-project.herokuapp.com/form";
    private WebDriver driver;
    private FormPageAdapter testCasesAdapter;
    private TestCasesCollection firstCollection;

    @Before
    public void setup(){
        System.setProperty(WEBDRIVER_PARAM_NAME, WEBDRIVER_PATH);
        driver = new ChromeDriver();
        driver.get(PAGE_URL);

        testCasesAdapter = new FormPageAdapter();

        firstCollection = new TestCasesCollection(MAX_NUMBER_OF_TESTS);
    }

    @Test
    public void webFormTest(){
        Assert.assertNotNull(driver);
        Assert.assertNotNull(testCasesAdapter);
        Assert.assertNotNull(firstCollection);
        Assert.assertNotEquals(0, firstCollection.getTestCasesList().size());

        int index = 0;
        //składnia pętli for dla kolekcji
        for(FormPageDTO testCase : firstCollection.getTestCasesList() ){
            index++;
            System.out.println(index + ": " + testCase.toString());
            FormPage.submitForm(driver, testCase, testCasesAdapter);
            ConfirmationPage.waitForAlert(driver);
            String expectedAlertText = "The form was successfully submitted!";
            String actualAlertText = ConfirmationPage.getAlertBannerText(driver);

            Assert.assertEquals(expectedAlertText, actualAlertText);
            driver.get(PAGE_URL);
        }
    }

    @After
    public void close(){
        driver.quit();
    }

}
