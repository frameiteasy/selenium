package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserHomePage {

    private WebElement logOutLink;

    public UserHomePage(WebDriver driver){
        waitForMyHomePage(driver);
        this.logOutLink = driver.findElement(By.linkText(FakeStoreSelectors.LOGOUT_SELECTOR));
    }

    public WebElement getLogOutLink() {
        return logOutLink;
    }

    private void waitForMyHomePage(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(FakeStoreSelectors.LOGOUT_SELECTOR)));
    }
}
