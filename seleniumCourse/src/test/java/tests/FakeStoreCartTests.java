package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.FakeStoreMainPage;
import pages.ShopMainPage;

public class FakeStoreCartTests {


    private static final String WEBDRIVER_PARAM_NAME = "webdriver.chrome.driver";
    private static final String WEBDRIVER_PATH = "C:\\Tools\\chromedriver\\chromedriver.exe";
    private static final String PAGE_URL = "https://fakestore.testelka.pl/";

    private WebDriver driver;

   //czemu lepiej @BeforeEach i @AfterEach

    @Before
    public void setupTest(){
        System.setProperty(WEBDRIVER_PARAM_NAME, WEBDRIVER_PATH);
        driver = new ChromeDriver();
        Assert.assertNotNull(driver);
        driver.get(PAGE_URL);
        driver.manage().window().setSize(new Dimension(1295, 760));
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

//        WebDriverWait wait= new WebDriverWait(driver, 5);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(FakeStoreSelectors.WINDSURFING_PHOTO_SELECTOR)));

        //shopMainPage.getWindsurfingProductButton().click();

        //dodać asercję czy jestem na następnej stronie

//        WindsurfingPage windsurfingMainPage = new WindsurfingPage(driver);
//        windsurfingMainPage.getEgiptTrip().click();
//        //dodać wait
//        windsurfingMainPage.getEgiptTrip().click();
//        //dodać wait




    }





}
