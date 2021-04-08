package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Autocomplete {
    private static final String WEBDRIVER_PARAM_NAME = "webdriver.chrome.driver";
    private static final String WEBDRIVER_PATH = "C:\\Tools\\chromedriver\\chromedriver.exe";
    private static final String PAGE_URL = "https://formy-project.herokuapp.com/autocomplete";

    public static void main(String[] args) throws InterruptedException {

        System.setProperty(WEBDRIVER_PARAM_NAME, WEBDRIVER_PATH);

        WebDriver driver = new ChromeDriver();
        driver.get(PAGE_URL);

        WebElement address = driver.findElement(By.id("autocomplete"));
        address.click();
        address.sendKeys("1026 York Street, Vallejo, Kalifornia");

        Thread.sleep(1000);

        WebElement selectedAddress = driver.findElement(By.className("pac-item"));
        selectedAddress.click();

             driver.quit();

    }
}
