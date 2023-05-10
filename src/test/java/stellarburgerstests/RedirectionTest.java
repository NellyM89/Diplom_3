package stellarburgerstests;

import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import pojo.AccountProfilePage;
import pojo.LoginPage;
import settings.SetBrowser;
import static org.hamcrest.CoreMatchers.containsString;

public class RedirectionTest extends SetBrowser {

    public final String createOrderButtonText = "Оформить заказ";
    public final String profileLinkText = "Профиль";
    public final String userTestLogin = "testemail456@gmail.com";
    public final String userTestPassword = "1234567";

    @Test
    @DisplayName("Проверка перехода с личного кабинета на главную страницу при клике на логотип")
    public void clickLogoExpectedRedirectToMainPageTest() {
        mainPage.clickAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillEmail(userTestLogin);
        loginPage.fillPassword(userTestPassword);
        loginPage.clickLoginButton();
        mainPage.waitUnitPageLoaded(8);
        mainPage.clickAccountButton();
        AccountProfilePage accountProfilePage = new AccountProfilePage(driver);
        accountProfilePage.waitUnitPageLoaded(8);
        accountProfilePage.clickLogoLink();
        mainPage.waitUnitPageLoaded(8);
        MatcherAssert.assertThat(mainPage.getTextCreateOrderButton(), containsString(createOrderButtonText));
    }

    @Test
    @DisplayName("Проверка перехода с личного кабинета на главную страницу при клике на ссылку \"Конструктор\" ")
    public void clickConstructorExpectedRedirectToMainPageTest() {
        mainPage.clickAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillEmail(userTestLogin);
        loginPage.fillPassword(userTestPassword);
        loginPage.clickLoginButton();
        mainPage.waitUnitPageLoaded(8);
        mainPage.clickAccountButton();
        AccountProfilePage accountProfilePage = new AccountProfilePage(driver);
        accountProfilePage.waitUnitPageLoaded(10);
        accountProfilePage.clickConstructorLink();
        mainPage.waitUnitPageLoaded(20);
        MatcherAssert.assertThat(mainPage.getTextCreateOrderButton(), containsString(createOrderButtonText));
    }

    @Test
    @DisplayName("Проверка перехода на страницу личного кабинета при клике на кнопку \"Личный кабинет\" ")
    public void redirectToAccountProfileExpectedAccountProfileOpenedTest() {
        mainPage.clickAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillEmail(userTestLogin);
        loginPage.fillPassword(userTestPassword);
        loginPage.clickLoginButton();
        mainPage.waitUnitPageLoaded(8);
        mainPage.clickAccountButton();
        AccountProfilePage accountProfilePage = new AccountProfilePage(driver);
        accountProfilePage.waitUnitPageLoaded(100);
        MatcherAssert.assertThat(accountProfilePage.getProfileText(), containsString(profileLinkText));
    }
}
