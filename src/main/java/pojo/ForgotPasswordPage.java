package pojo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import settings.Base;

public class ForgotPasswordPage extends Base {


    private final By loginLink = By.cssSelector("a[href='/login']");

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }

    public void clickLoginLink() {
        driver.findElement(loginLink).click();
    }

}
