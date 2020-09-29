package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class ScrollToElement {
    private static final String WEBDRIVER_PARAM_NAME = "webdriver.chrome.driver";
    private static final String WEBDRIVER_PATH = "C:\\Tools\\chromedriver\\chromedriver85.exe";
    private static final String PAGE_URL = "https://formy-project.herokuapp.com/scroll";

    public static void main(String[] args){

        System.setProperty(WEBDRIVER_PARAM_NAME, WEBDRIVER_PATH);

        WebDriver driver = new ChromeDriver();
        driver.get(PAGE_URL);

        Actions actions = new Actions(driver);
        //public Actions(WebDriver driver); konstruktor w klasie Actions

        WebElement nameField = driver.findElement(By.id("name"));
        //nameField.click();
        actions.moveToElement(nameField);
        nameField.sendKeys("Jola M");

        WebElement dateField = driver.findElement(By.id("date"));
        //dateField.click();
        actions.moveToElement(dateField);
        dateField.sendKeys("12/31/2020");

        driver.quit();
    }

}
