package stellarburgerstests;

import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import pojo.ForgotPasswordPage;
import pojo.LoginPage;
import pojo.RegistrationPage;
import settings.SetBrowser;
import static org.hamcrest.CoreMatchers.containsString;

public class LoginTest extends SetBrowser {

    public final String createOrderButtonText = "Оформить заказ";
    public final String userTestLogin = "nellytest24@gmail.com";
    public final String userTestPassword = "Nm01234567.";

    @Test
    @DisplayName("Проверка входа по кнопке «Войти в аккаунт»")
    public void loginUsingAccountProfileButtonShouldLogUserInTest() {
        mainPage.clickAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillEmail(userTestLogin);
        loginPage.fillPassword(userTestPassword);
        loginPage.clickLoginButton();
        mainPage.waitUnitPageLoaded(8);
        MatcherAssert.assertThat(mainPage.getTextCreateOrderButton(), containsString(createOrderButtonText));
    }

    @Test
    @DisplayName("Проверка входа через кнопку в форме регистрации")
    public void loginUsingButtonOnRegistrationPageShouldLogUserInTest() {
        mainPage.clickAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegistrationLink();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.clickLoginButton();
        loginPage.fillEmail(userTestLogin);
        loginPage.fillPassword(userTestPassword);
        loginPage.clickLoginButton();
        mainPage.waitUnitPageLoaded(8);
        MatcherAssert.assertThat(mainPage.getTextCreateOrderButton(), containsString(createOrderButtonText));
    }

    @Test
    @DisplayName("Проверка входа через кнопку в форме восстановления пароля")
    public void loginUsingButtonOnForgotPasswordPageShouldLogUserInTest() {
        mainPage.clickAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickForgotPasswordLink();
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        forgotPasswordPage.clickLoginLink();
        loginPage.fillEmail(userTestLogin);
        loginPage.fillPassword(userTestPassword);
        loginPage.clickLoginButton();
        mainPage.waitUnitPageLoaded(8);
        MatcherAssert.assertThat(mainPage.getTextCreateOrderButton(), containsString(createOrderButtonText));
    }

}
