package pojo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import settings.Base;

import java.time.Duration;

public class LoginPage extends Base {

    private final By header = By.xpath(".//h2[text() = 'Вход']");
    private final By emailInput = By.cssSelector("input[name='name']");

    private final By passwordInput = By.cssSelector("input[name='Пароль']");
    private final By loginButton = By.xpath(".//button[text() = 'Войти']");
    private final By registrationLink = By.cssSelector("a[href='/register']");
    private final By forgotPasswordLink = By.cssSelector("a[href='/forgot-password']");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void fillEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void fillPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void clickRegistrationLink() {
        driver.findElement(registrationLink).click();
    }

    public void clickForgotPasswordLink() {
        driver.findElement(forgotPasswordLink).click();
    }

    public String getHeaderText() {
        return driver.findElement(header).getText();
    }

    public void waitUnitPageLoaded(int time) {
        new WebDriverWait(driver, Duration.ofSeconds(time))
                .until(ExpectedConditions.visibilityOfElementLocated(header));
    }

}
