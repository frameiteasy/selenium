package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.FakeStoreMainPage;
import pages.FakeStoreSelectors;
import pages.ShopMainPage;
import pages.WindsurfingMainPage;

import java.util.concurrent.TimeUnit;

public class FakeStoreCartTests {

    private static final String WEBDRIVER_PARAM_NAME = "webdriver.chrome.driver";
    private static final String WEBDRIVER_PATH = "C:\\Tools\\chromedriver\\chromedriver.exe";
    private static final String PAGE_URL = "https://fakestore.testelka.pl/";

    private WebDriver driver; //wartość nullowa, brak przypisanej wartości

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

        compareValues("The title is not \"FakeStore – Sklep do nauki testowania\" ", "FakeStore – Sklep do nauki testowania", driver.getTitle() );

        FakeStoreMainPage mainPage = new FakeStoreMainPage(driver);
        mainPage.getShopButton().click();

        compareValues("The title is not \"Produkty – FakeStore\" ", "Produkty – FakeStore", driver.getTitle() );

        /*
        it is not working and I don't know why - need to be investigated
        WebElement windsurfingCategory = driver.findElement(By.cssSelector("li[class='product-category product first']>a"));
        TODO        probably xpath would be better
         */

        ShopMainPage shopMainPage = new ShopMainPage(driver);
        shopMainPage.getWindsurfingProductButton().click();

        compareValues("The title is not \"Windsurfing – FakeStore\" ", "Windsurfing – FakeStore", driver.getTitle() );

        WindsurfingMainPage windsurfingMainPage = new WindsurfingMainPage(driver); //at this moment 2 WebElement exist: egiptTrip and greeceTrip

        WebElement actualValueInCart = driver.findElement(By.cssSelector("a>span[class='woocommerce-Price-amount amount']"));

        compareValues("The total amount in the cart is not \"0,00 zł\" ", "0,00 zł", actualValueInCart.getText());

        WebDriverWait wait = new WebDriverWait(driver, 5);

        addProducts(windsurfingMainPage, wait);

        //new objects e.g checkCartButton need to be set on
        //WebElement checkCartButton = driver.findElement(By.linkText(FakeStoreSelectors.ZOBACZ_KOSZYK_BUTTON_SELECTOR));
        //checkCartButton.click();
        //different option is by using getter/setter from windsurfingMainPage

        windsurfingMainPage.setCheckCartButton(driver.findElement(By.linkText(FakeStoreSelectors.ZOBACZ_KOSZYK_BUTTON_SELECTOR)));
        windsurfingMainPage.getCheckCartButton().click();

        compareValues("The title is not \"Koszyk – FakeStore\" ", "Koszyk – FakeStore", driver.getTitle() );

        WebElement insertCouponInput = driver.findElement(By.id(FakeStoreSelectors.COUPON_INPUT_SELECTOR));
        String correctCouponValue = "10procent";
        insertCouponInput.sendKeys(correctCouponValue);

        WebElement submitCoupon = driver.findElement(By.cssSelector(FakeStoreSelectors.SUBMIT_BUTTON_SELECTOR));
        submitCoupon.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(FakeStoreSelectors.COUPON_ALERT_SELECTOR)));

        //WebElement alert = driver.findElement(By.cssSelector(FakeStoreSelectors.COUPON_ALERT_SELECTOR));

        WebElement sumInCart = driver.findElement(By.xpath(FakeStoreSelectors.SUM_AFTER_COUPON_SELECTOR));
        String expectedSumInCart = "5 940,00 zł";
        String currentSumInCart = sumInCart.getAttribute("innerHTML");
        System.out.println(currentSumInCart);
    }

    private void compareValues(String message, String expectedValue, String currentValue){
        System.out.println("Comparing values: " + expectedValue + " and " + currentValue);
        Assert.assertEquals(message, expectedValue, currentValue);
    }

    private void addProductToCart(WebElement product){
        product.click();
        System.out.println("Product is added");
    }

    private void addProducts(WindsurfingMainPage page, WebDriverWait wait){
        addProductToCart(page.getEgiptTrip());
        /*
       this wait checking also the price correctness so the assertion is not longer necessary
         */
        Boolean isPriceCorrected = wait.until(ExpectedConditions.textToBe(By.cssSelector("a>span[class='woocommerce-Price-amount amount']"), "3 400,00 zł"));

        addProductToCart(page.getGreeceTrip());

        isPriceCorrected = wait.until(ExpectedConditions.textToBe(By.cssSelector("a>span[class='woocommerce-Price-amount amount']"), "6 600,00 zł"));

    }

}
