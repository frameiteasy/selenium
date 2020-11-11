package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FakeStoreMojeKontoPage {

    private WebElement username;

    public FakeStoreMojeKontoPage(WebDriver driver) {
        this.username = driver.findElement(By.cssSelector(FakeStoreSelectors.USERNAME_SELECTOR));
    }

    public WebElement getUsername(){
        return this.username;
    }

    public void setUsername(WebElement username) {
        this.username = username;
    }
}
