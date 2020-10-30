package pages;


import data.FormPageAdapter;
import data.FormPageDTO;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class FormPage {
    public static void submitForm(WebDriver driver, FormPageDTO testCase, FormPageAdapter testCaseAdapter){

        driver.findElement(By.id("first-name")).sendKeys(testCase.getFirstName());
        driver.findElement(By.id("last-name")).sendKeys(testCase.getLastName());
        driver.findElement(By.id("job-title")).sendKeys(testCase.getJobTitle());
        driver.findElement(By.id(testCaseAdapter.getEducation(testCase.getEducation()))).click();
        driver.findElement(By.id(testCaseAdapter.getSex(testCase.getSex()))).click();
        driver.findElement(By.cssSelector(testCaseAdapter.getExperience(testCase.getExperience()))).click();
        driver.findElement(By.id("datepicker")).sendKeys(testCaseAdapter.getSubmitDate(testCase.getSubmitDate()));
        driver.findElement(By.id("datepicker")).sendKeys(Keys.RETURN);
        driver.findElement(By.cssSelector(".btn.btn-lg.btn-primary")).click();
    }
}
