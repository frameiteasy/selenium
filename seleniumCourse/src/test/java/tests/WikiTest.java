package tests;

import data.FormPageAdapter;
import data.FormPageDTO;
import data.TestCasesCollection;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ConfirmationPage;
import pages.FormPage;

import java.util.Set;

public class WikiTest {

    private static final String WEBDRIVER_PARAM_NAME = "webdriver.chrome.driver";
    private static final String WEBDRIVER_PATH = "C:\\Tools\\chromedriver\\chromedriver85.exe";
    private static final String PAGE_URL = "https://en.wikipedia.org/wiki/Main_Page";

    private WebDriver driver;

    @Before
    public void setup(){
        System.setProperty(WEBDRIVER_PARAM_NAME, WEBDRIVER_PATH);
        driver = new ChromeDriver();
        Assert.assertNotNull(driver);
        driver.get(PAGE_URL);
        Assert.assertNotNull(driver.manage().getCookies());
    }

    @Test
    public void confirmWebTitleTest(){
        String wikiWebTitle = "Wikipedia, the free encyclopedia";
        Assert.assertEquals("The web tiltle is not " + wikiWebTitle, wikiWebTitle, driver.getTitle());
    }

    @Test
    public void getCookiesTest(){
        Set<Cookie> cookies = driver.manage().getCookies();
        Assert.assertNotEquals("Cookies object is not not null", 0, cookies.size());
        Assert.assertEquals("Cookies number is not 3", 3, cookies.size());
    }

    @Test
    public void addingAndDeletingCookieTest(){
        Cookie newCookie = new Cookie("testCookie", "valueForNewCookie");
        driver.manage().addCookie(newCookie);
        Assert.assertEquals("Cookie's name is not "+ newCookie.getName(), newCookie.getName(), driver.manage().getCookieNamed("testCookie").getName());
        Assert.assertEquals("Cookies number is not 4", 4, driver.manage().getCookies().size());
        driver.manage().deleteCookieNamed("testCookie");
        Assert.assertEquals("Cookies number is not 3", 3, driver.manage().getCookies().size());
    }

    @After
    public void close(){
        driver.quit();
    }

}
