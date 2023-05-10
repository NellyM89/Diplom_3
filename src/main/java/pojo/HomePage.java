package pojo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import settings.Base;

import java.time.Duration;

public class HomePage extends Base {

    //login
    private final By loginButton = By.xpath(".//button[text() = 'Войти в аккаунт']");
    private final By createOrderButton = By.xpath(".//button[text() = 'Оформить заказ']");
    private final By accountButton = By.cssSelector("a[href='/account']");
    private final By bunSectionButton = By.xpath(".//span[text() = 'Булки']/..");
    private final By sauceSectionButton = By.xpath(".//span[text() = 'Соусы']/..");
    private final By fillingSectionButton = By.xpath(".//span[text() = 'Начинки']/..");
    private final By burgerConstructorHeader = By.xpath(".//h1[text() = 'Соберите бургер']");


    public HomePage(WebDriver driver) {
        super(driver);
    }


    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public String getTextCreateOrderButton() {
        return driver.findElement(createOrderButton).getText();
    }

    public void clickAccountButton() {
        driver.findElement(accountButton).click();
    }

    public void clickBunSectionButton() {
        driver.findElement(bunSectionButton).click();
    }

    public void clickSauceSectionButton() {
        driver.findElement(sauceSectionButton).click();
    }

    public void clickFillingSectionButton() {
        driver.findElement(fillingSectionButton).click();
    }

    public String getBunSectionClass() {
        WebElement element = driver.findElement(bunSectionButton);
        return element.getAttribute("class");
    }

    public String getSauceSectionClass() {
        WebElement element = driver.findElement(sauceSectionButton);
        return element.getAttribute("class");
    }

    public String getFillingSectionClass() {
        WebElement element = driver.findElement(fillingSectionButton);
        return element.getAttribute("class");
    }

    public void waitUnitPageLoaded(int time) {
        new WebDriverWait(driver, Duration.ofSeconds(time))
                .until(ExpectedConditions.visibilityOfElementLocated(burgerConstructorHeader));
    }

}
