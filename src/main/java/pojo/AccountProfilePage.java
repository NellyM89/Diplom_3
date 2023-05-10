package pojo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import settings.Base;

import java.time.Duration;

public class AccountProfilePage extends Base {
    private final By profileLink = By.xpath(".//a[text() = 'Профиль']");
    private final By exitButton = By.xpath(".//button[text() = 'Выход']");

    private final By logoLink = By.className("AppHeader_header__logo__2D0X2");

    private final By constructorLink = By.className("AppHeader_header__link__3D_hX");

    public AccountProfilePage(WebDriver driver) {
        super(driver);
    }

    public String getProfileText() {
        return driver.findElement(profileLink).getText();
    }

    public void clickExitButton() {
        driver.findElement(exitButton).click();
    }

    public void clickLogoLink() {
        driver.findElement(logoLink).click();
    }

    public void clickConstructorLink() {
        driver.findElement(constructorLink).click();
    }

    public void waitUnitPageLoaded(int time) {
        new WebDriverWait(driver, Duration.ofSeconds(time))
                .until(ExpectedConditions.visibilityOfElementLocated(profileLink));
    }

}
