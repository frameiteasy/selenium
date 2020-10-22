package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

public class WebForm {
    private static final String WEBDRIVER_PARAM_NAME = "webdriver.chrome.driver";
    private static final String WEBDRIVER_PATH = "C:\\Tools\\chromedriver\\chromedriver85.exe";
    private static final String PAGE_URL = "https://formy-project.herokuapp.com/form";

    public static void main(String[] args) {

        System.setProperty(WEBDRIVER_PARAM_NAME, WEBDRIVER_PATH);

        WebDriver driver = new ChromeDriver();
        driver.get(PAGE_URL);

        submitForm(driver);

        waitForAlert(driver);

        String expectedAlertText = "The form was successfully submitted!";
        String actualAlertText = getAlertBannerText(driver);

        driver.quit();


        Assert.assertEquals(expectedAlertText, actualAlertText);
        //Assert.assertEquals(wrongAlertText, alertText);

    }

    public static void submitForm(WebDriver driver){
        driver.findElement(By.id("first-name")).sendKeys("Jola");
        driver.findElement(By.id("last-name")).sendKeys("Szostak-Marciniak");
        driver.findElement(By.id("job-title")).sendKeys("QA Tester");
        driver.findElement(By.id("radio-button-1")).click();
        driver.findElement(By.id("checkbox-2")).click();
        driver.findElement(By.cssSelector("option[value='2']")).click();
        driver.findElement(By.id("datepicker")).sendKeys("10/19/2020");
        driver.findElement(By.id("datepicker")).sendKeys(Keys.RETURN);
        driver.findElement(By.cssSelector(".btn.btn-lg.btn-primary")).click();
    }
    public static void waitForAlert(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert.alert-success")));

    }
    public static String getAlertBannerText(WebDriver driver){
        return driver.findElement(By.cssSelector(".alert.alert-success")).getText();

    }

}
