package tests;

import net.bytebuddy.asm.Advice;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.FakeStoreMojeKontoPage;
import pages.FakeStoreSelectors;
import pages.FakeStoreXpaths;
import pages.UserHomePage;

public class FakeStoreFirstTests {

    private static final String WEBDRIVER_PARAM_NAME = "webdriver.chrome.driver";
    private static final String WEBDRIVER_PATH = "C:\\Tools\\chromedriver\\chromedriver.exe";
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

        //WebDriverWait wait = new WebDriverWait(driver, 5);
        //wait.until(ExpectedConditions.elementToBeClickable(mojeKontoPage.getRememberMeCheckbox()));

        mojeKontoPage.getRememberMeCheckbox().sendKeys(Keys.SPACE);
        //TODO add an assertion for checkbox


        Assert.assertEquals("The username is not " + usernameLogin, usernameLogin, driver.findElement(By.cssSelector(FakeStoreSelectors.LOGIN_USERNAME_SELECTOR))
                .getAttribute("value"));
        Assert.assertEquals("The password is not " + correctLoginPassword, correctLoginPassword, driver.findElement(By.cssSelector(FakeStoreSelectors.LOGIN_PASSWORD_SELECTOR)).
                getAttribute("value"));

        mojeKontoPage.getLoginButton().click();

       UserHomePage myHomePage = new UserHomePage(driver);
       Assert.assertNotNull(myHomePage);

        String expectedLogOutText = "Wyloguj";
        String actualLogOutText = myHomePage.getLogOutLink().getText();
        Assert.assertEquals("The My Home Page title is not " + expectedLogOutText, expectedLogOutText, actualLogOutText);

    }

    @Test
    public void correctLoginByXpathTest(){

        String username = "testjsm";
        String correctPassword = "testJSM@123test";

        WebElement userNameField = driver.findElement(By.xpath(FakeStoreXpaths.LOGIN_USERNAME_XPATH));
        userNameField.sendKeys(username);

        Assert.assertEquals("The username is not "+ username, username, driver.findElement(By.xpath(FakeStoreXpaths.LOGIN_USERNAME_XPATH)).getAttribute("value"));

        WebElement passwordField = driver.findElement(By.xpath(FakeStoreXpaths.LOGIN_PASSWORD_XPATH));
        passwordField.sendKeys(correctPassword);

        Assert.assertEquals("The password is not " + correctPassword, correctPassword, driver.findElement(By.xpath(FakeStoreXpaths.LOGIN_PASSWORD_XPATH)).getAttribute("value"));

        WebElement loginButton = driver.findElement(By.xpath(FakeStoreXpaths.LOGIN_BUTTON_PATH));
        loginButton.sendKeys(Keys.ENTER);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(FakeStoreSelectors.LOGOUT_SELECTOR)));

        String expectedLogOutText = "Wyloguj się";
        String actualLogOutText = driver.findElement(By.linkText(FakeStoreSelectors.LOGOUT_SELECTOR)).getText();
        Assert.assertEquals("There is no " + expectedLogOutText + " on this page", expectedLogOutText, actualLogOutText);


    }

    @After
    public void close(){
        driver.quit();
    }

}
