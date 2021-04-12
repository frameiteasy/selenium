package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FakeStoreMainPage {

    private WebElement shopButton;

    public FakeStoreMainPage(WebDriver driver) {
        this.shopButton = driver.findElement(By.cssSelector(FakeStoreSelectors.SHOP_SELECTOR));
    }

    public WebElement getShopButton() {
        return shopButton;
    }
}
