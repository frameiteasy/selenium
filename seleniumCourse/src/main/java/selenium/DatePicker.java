package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePicker {

    private static final String WEBDRIVER_PARAM_NAME = "webdriver.chrome.driver";
    private static final String WEBDRIVER_PATH = "C:\\Tools\\chromedriver\\chromedriver85.exe";
    private static final String PAGE_URL = "https://formy-project.herokuapp.com/datepicker";

    public static void main(String[] args) {

        System.setProperty(WEBDRIVER_PARAM_NAME, WEBDRIVER_PATH);

        WebDriver driver = new ChromeDriver();
        driver.get(PAGE_URL);

        //1st method
        WebElement datePickerField = driver.findElement(By.id("datepicker"));
        datePickerField.click();
        datePickerField.sendKeys("01/24/1999");
        datePickerField.sendKeys(Keys.RETURN);

        //TODO 2nd method

        driver.quit();
    }

}
