package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropDown {
    private static final String WEBDRIVER_PARAM_NAME = "webdriver.chrome.driver";
    private static final String WEBDRIVER_PATH = "C:\\Tools\\chromedriver\\chromedriver85.exe";
    private static final String PAGE_URL = "https://formy-project.herokuapp.com/dropdown";

    public static void main(String[] args) throws InterruptedException {

        System.setProperty(WEBDRIVER_PARAM_NAME, WEBDRIVER_PATH);

        WebDriver driver = new ChromeDriver();
        driver.get(PAGE_URL);

        WebElement dropDownMenuButton = driver.findElement(By.id("dropdownMenuButton"));
        dropDownMenuButton.click();

        Thread.sleep(1000);

/*        WebElement autocopleteItem = driver.findElement(By.id("autocomplete"));
        autocopleteItem.click();*/

        //TODO WebElement modalItem = driver.findElement(By.cssSelector("a[href*='modal']"));

        WebElement modalItem = driver.findElement(By.xpath("/html/body/div/div/div/a[11]"));
        modalItem.click();

        driver.quit();
    }

}
