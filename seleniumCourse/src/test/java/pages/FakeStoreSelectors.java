package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FakeStoreSelectors {

    public static final String LOGIN_USERNAME_SELECTOR = "[id=username]";
    public static final String LOGIN_PASSWORD_SELECTOR = "input[id='password']";
    public static final String REMEMBERME_SELECTOR = "input#rememberme";
    public static final String LOGIN_BUTTON_SELECTOR = "button[type='submit'][name='login']"; //"button[class='woocommerce-button button woocommerce-form-login__submit']"
    public static final String FORGOTTEN_PASSWORD_SELECTOR ="a[href='https://fakestore.testelka.pl/moje-konto/zapomniane-haslo/']";
    public static final String EMAIL_REGISTRATION_SELECTOR = "input[id='reg_email']";
    public static final String PASSWORD_REGISTRATION_SELECTOR = "input[id='reg_password']";
    public static final String REGISTER_BUTTON_SELECTOR = "button[name='register']";
    public static final String CATEGORY_SELECTOR = "a[href='https://fakestore.testelka.pl/product-category/wspinaczka/']";
    public static final String LOGOUT_SELECTOR = "Wyloguj";
    public static final String SHOP_SELECTOR = "a[href=\'https://fakestore.testelka.pl/shop/\']"; //#menu-item-198 > a -->po ID rodzica i dziecko tagu a
    public static final String WSPINACZKA_PHOTO_SELECTOR = "img[alt='Yoga i pilates']"; //#main > ul > li.product-category.product.last > a > h2 -->po ID rodzica i dziecko tagu a dla napisu pod
    public static final String WINDSURFING_MAINPAGE_SELECTOR = "Windsurfing";
    public static final String WINDSURFING_EGIPT_SELECTOR = "a[data-product_id = '386']";
    public static final String WINDSURFING_GREECE_SELECTOR = "a[data-product_id = '391']";



}



