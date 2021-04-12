package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShopMainPage {
    private WebElement windsurfingProductButton;

    public ShopMainPage(WebDriver driver){
        this.windsurfingProductButton = driver.findElement(By.linkText(FakeStoreSelectors.WINDSURFING_MAINPAGE_SELECTOR));
    }
    public WebElement getWindsurfingProductButton() {
        return this.windsurfingProductButton;
    }
}
