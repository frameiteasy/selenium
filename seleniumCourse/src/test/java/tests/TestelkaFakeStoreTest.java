package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class TestelkaFakeStoreTest {

    private static final String WEBDRIVER_PARAM_NAME = "webdriver.chrome.driver";
    private static final String WEBDRIVER_PATH = "C:\\Tools\\chromedriver\\chromedriver85.exe";
    private static final String PAGE_URL = "https://fakestore.testelka.pl/moje-konto/";

    private WebDriver driver;

    @Before
    public void setup(){
        System.setProperty(WEBDRIVER_PARAM_NAME, WEBDRIVER_PATH);
        driver = new ChromeDriver();
        Assert.assertNotNull(driver);
        driver.get(PAGE_URL);
       }

    @Test
    public void confirmWebTitleTest(){
        String fakeStoreWebTitle = "Moje konto – FakeStore";
        Assert.assertEquals("The web tiltle is not " + fakeStoreWebTitle, fakeStoreWebTitle, driver.getTitle());
    }


    @After
    public void close(){
        driver.quit();
    }

}
