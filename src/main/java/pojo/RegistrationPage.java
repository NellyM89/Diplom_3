package pojo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import settings.Base;

public class RegistrationPage extends Base {

    //имя
    private final By nameInput = By.xpath(".//label[text() = 'Имя']/../input");
    //email
    private final By emailInput = By.xpath(".//label[text() = 'Email']/../input");
    //password
    private final By passwordInput = By.cssSelector("input[name='Пароль']");
    //button
    private final By registrationButton = By.xpath(".//button[text() = 'Зарегистрироваться']");

    private final By warningMessage = By.className("input__error");

    private final By loginButton = By.cssSelector("a[href='/login']");


    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void fillName(String name) {
        driver.findElement(nameInput).sendKeys(name);
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

    public void clickRegistrationButton() {
        driver.findElement(registrationButton).click();
    }

    public String getWarningMessage() {
        return driver.findElement(warningMessage).getText();
    }

}
