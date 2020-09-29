package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SwitchToActiveWindow {
    private static final String WEBDRIVER_PARAM_NAME = "webdriver.chrome.driver";
    private static final String WEBDRIVER_PATH = "C:\\Tools\\chromedriver\\chromedriver85.exe";
    private static final String PAGE_URL = "https://formy-project.herokuapp.com/switch-window";

    public static void main(String[] args) {

        System.setProperty(WEBDRIVER_PARAM_NAME, WEBDRIVER_PATH);

        WebDriver driver = new ChromeDriver();
        driver.get(PAGE_URL);

        WebElement newTabButton = driver.findElement(By.id("new-tab-button"));
        newTabButton.click();

        String originalTab = driver.getWindowHandle();

        System.out.println("Number of Tabs: " + driver.getWindowHandles().size());

        int loopNumber = 0;

        for(String tabName: driver.getWindowHandles()){
            loopNumber++;
            System.out.println("Start loop number " + loopNumber);
            System.out.println("switch to tab name: " + tabName);
            driver.switchTo().window(tabName);
            System.out.println("I am here: " + driver.getWindowHandle());
        }
        driver.switchTo().window(originalTab);
        System.out.println("I am in original tab: " + driver.getWindowHandle());

        driver.quit();
    }

}
