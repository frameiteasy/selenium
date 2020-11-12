package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.FakeStoreMojeKontoPage;
import pages.FakeStoreSelectors;
import pages.UserHomePage;

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

    @Test
    public void usernameTest(){
        FakeStoreMojeKontoPage mojeKontoPage = new FakeStoreMojeKontoPage(driver);
        Assert.assertNotNull(mojeKontoPage);
        Assert.assertNotNull(mojeKontoPage.getUsername());

        String usernameValue = "Jola";
        mojeKontoPage.getUsername().sendKeys(usernameValue);

        //sleep is not necessary
        try {
            Thread.sleep(0);
        } catch (InterruptedException e) {
            System.out.println("assert Error");
            e.printStackTrace();
        }

        Assert.assertEquals("The name is not " + usernameValue, usernameValue, driver.findElement(By.cssSelector(FakeStoreSelectors.LOGIN_USERNAME_SELECTOR))
                .getAttribute("value"));
    }

    @Test
    public void correctLoginTest(){
        FakeStoreMojeKontoPage mojeKontoPage = new FakeStoreMojeKontoPage(driver);
        Assert.assertNotNull(mojeKontoPage);


        Assert.assertNotNull(mojeKontoPage.getUsername());
        Assert.assertNotNull(mojeKontoPage.getLoginPassword());
        Assert.assertNotNull(mojeKontoPage.getRememberMeCheckbox());
        Assert.assertNotNull(mojeKontoPage.getLoginButton());

        String usernameLogin = "testjsm";
        //String usernameEmail = "testJSM@test.com";
        //String usernameLogin = "Jola";
        mojeKontoPage.getUsername().sendKeys(usernameLogin);
        String correctLoginPassword = "testJSM@123test";
        // String wrongLoginPassword = "123qaz";
        mojeKontoPage.getLoginPassword().sendKeys(correctLoginPassword);
        mojeKontoPage.getRememberMeCheckbox().click();
        //TODO add an assertion for checkbox


        Assert.assertEquals("The username is not " + usernameLogin, usernameLogin, driver.findElement(By.cssSelector(FakeStoreSelectors.LOGIN_USERNAME_SELECTOR))
                .getAttribute("value"));
        Assert.assertEquals("The password is not " + correctLoginPassword, correctLoginPassword, driver.findElement(By.cssSelector(FakeStoreSelectors.LOGIN_PASSWORD_SELECTOR)).
                getAttribute("value"));

        mojeKontoPage.getLoginButton().click();

       UserHomePage myHomePage = new UserHomePage(driver);
       Assert.assertNotNull(myHomePage);

        String expectedLogOutText = "Wyloguj się";
        String actualLogOutText = myHomePage.getLogOutLink().getText();
        Assert.assertEquals("The My Home Page title is not " + expectedLogOutText, expectedLogOutText, actualLogOutText);

    }

    @After
    public void close(){
        driver.quit();
    }

}
