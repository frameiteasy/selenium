package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FakeStoreMojeKontoPage {

    private WebElement username;
    private WebElement loginPassword;
    private WebElement rememberMeCheckbox;
    private WebElement loginButton;
    private WebElement forgottenPassLink;
    private WebElement emailRegistration;
    private WebElement registrationPassword;
    private WebElement registerButton;
    private WebElement secondCategory;

    public FakeStoreMojeKontoPage(WebDriver driver) {
        this.username = driver.findElement(By.cssSelector(FakeStoreSelectors.LOGIN_USERNAME_SELECTOR));
        this.loginPassword = driver.findElement(By.cssSelector(FakeStoreSelectors.LOGIN_PASSWORD_SELECTOR));
        this.rememberMeCheckbox = driver.findElement(By.cssSelector(FakeStoreSelectors.REMEMBERME_SELECTOR));
        this.loginButton = driver.findElement(By.cssSelector(FakeStoreSelectors.LOGIN_BUTTON_SELECTOR));
        this.forgottenPassLink = driver.findElement(By.cssSelector(FakeStoreSelectors.FORGOTTEN_PASSWORD_SELECTOR));
        this.emailRegistration = driver.findElement(By.cssSelector(FakeStoreSelectors.EMAIL_REGISTRATION_SELECTOR));
        this.registrationPassword = driver.findElement(By.cssSelector(FakeStoreSelectors.PASSWORD_REGISTRATION_SELECTOR));
        this.registerButton = driver.findElement(By.cssSelector(FakeStoreSelectors.REGISTER_BUTTON_SELECTOR));
        this.secondCategory = driver.findElement(By.cssSelector(FakeStoreSelectors.CATEGORY_SELECTOR));

    }

    public WebElement getUsername(){
        return this.username;
    }

    public WebElement getLoginPassword() {
        return loginPassword;
    }

    public WebElement getRememberMeCheckbox() {
        return rememberMeCheckbox;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getForgottenPassLink() {
        return forgottenPassLink;
    }

    public WebElement getEmailRegistration() {
        return emailRegistration;
    }

    public WebElement getRegistrationPassword() {
        return registrationPassword;
    }

    public WebElement getRegisterButton() {
        return registerButton;
    }

    public WebElement getSecondCategory() {
        return secondCategory;
    }

    public void setUsername(WebElement username) {
        this.username = username;
    }
}
