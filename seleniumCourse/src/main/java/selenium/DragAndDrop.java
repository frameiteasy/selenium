package selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {
    private static final String WEBDRIVER_PARAM_NAME = "webdriver.chrome.driver";
    private static final String WEBDRIVER_PATH = "C:\\Tools\\chromedriver\\chromedriver85.exe";
    private static final String PAGE_URL = "https://formy-project.herokuapp.com/dragdrop";

    public static void main(String[] args) {

        System.setProperty(WEBDRIVER_PARAM_NAME, WEBDRIVER_PATH);

        WebDriver driver = new ChromeDriver();
        driver.get(PAGE_URL);

        WebElement image = driver.findElement(By.id("image"));
        WebElement box = driver.findElement(By.id("box"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(image, box).build().perform();

        driver.quit();
    }

}
