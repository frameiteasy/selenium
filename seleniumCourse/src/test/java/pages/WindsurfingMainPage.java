package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WindsurfingMainPage {

    private WebElement egiptTrip;
    private WebElement greeceTrip;

    public WindsurfingMainPage(WebDriver driver){
        this.egiptTrip = driver.findElement(By.cssSelector(FakeStoreSelectors.WINDSURFING_EGIPT_SELECTOR));
        this.greeceTrip = driver.findElement(By.cssSelector(FakeStoreSelectors.WINDSURFING_GREECE_SELECTOR));
    }
    public WebElement getEgiptTrip(){
        return this.egiptTrip;
    }

    public WebElement getGreeceTrip() {
        return greeceTrip;
    }
}
