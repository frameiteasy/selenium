package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.FakeStoreMainPage;
import pages.ShopMainPage;
import pages.WindsurfingMainPage;

import java.util.concurrent.TimeUnit;

public class FakeStoreCartTests {


    private static final String WEBDRIVER_PARAM_NAME = "webdriver.chrome.driver";
    private static final String WEBDRIVER_PATH = "C:\\Tools\\chromedriver\\chromedriver.exe";
    private static final String PAGE_URL = "https://fakestore.testelka.pl/";

    private WebDriver driver;

   //czemu lepiej @BeforeEach i @AfterEach

    @Before
    public void setupTest(){
        System.setProperty(WEBDRIVER_PARAM_NAME, WEBDRIVER_PATH);
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");
        //options.addArguments("--window-size=1400,600");
        //driver = new ChromeDriver(options);
        driver = new ChromeDriver();
        Assert.assertNotNull(driver);

        //driver.manage().window().setSize(new Dimension(1295, 760));
        //driver.manage().window().setPosition(new Point(10,40));
        //driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.get(PAGE_URL);
        driver.findElement(By.cssSelector("a[class*='dismiss-link']")).click();

    }

    @After
    public void closeTest(){
        driver.quit();
    }

    @Test
    public void addingItemsToCartTest(){
        String mainPageTitle ="FakeStore – Sklep do nauki testowania";
        Assert.assertEquals("The title is not " + mainPageTitle, mainPageTitle, driver.getTitle());

        FakeStoreMainPage mainPage = new FakeStoreMainPage(driver);
        mainPage.getShopButton().click();

        String expectedShopMainPageTitle = "Produkty – FakeStore";
        Assert.assertEquals("The page title is not "+expectedShopMainPageTitle, expectedShopMainPageTitle, driver.getTitle());

        /*
        it is not working and I don't know why - need to be investigated
        WebElement windsurfingCategory = driver.findElement(By.cssSelector("li[class='product-category product first']>a"));
        TODO        probably xpath would be better
         */

        ShopMainPage shopMainPage = new ShopMainPage(driver);
        shopMainPage.getWindsurfingProductButton().click();

        String expectedWindsurfingMainPageTitle = "Windsurfing – FakeStore";
        Assert.assertEquals("The page is not " + expectedWindsurfingMainPageTitle, expectedWindsurfingMainPageTitle, driver.getTitle());

        WindsurfingMainPage windsurfingMainPage = new WindsurfingMainPage(driver);

        WebElement actualValueInCart = driver.findElement(By.cssSelector("a>span[class='woocommerce-Price-amount amount']"));
        String actualTotalAmountInCart = actualValueInCart.getText();

        String expectedTotalAmountInCart = "0,00 zł";
        Assert.assertEquals("The total amount in the cart is not " + expectedTotalAmountInCart, expectedTotalAmountInCart, actualTotalAmountInCart);

        windsurfingMainPage.getEgiptTrip().click();

        expectedTotalAmountInCart = "3 400,00 zł";

        /*
       this wait checking also the price correctness so the assertion is not longer necessary
         */
        WebDriverWait wait = new WebDriverWait(driver, 5);
        Boolean isPriceCorrected = wait.until(ExpectedConditions.textToBe(By.cssSelector("a>span[class='woocommerce-Price-amount amount']"), expectedTotalAmountInCart));

        windsurfingMainPage.getGreeceTrip().click();
        expectedTotalAmountInCart = "6 600,00 zł";

        isPriceCorrected = wait.until(ExpectedConditions.textToBe(By.cssSelector("a>span[class='woocommerce-Price-amount amount']"), expectedTotalAmountInCart));



    }





}
