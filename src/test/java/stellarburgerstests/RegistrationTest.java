package stellarburgerstests;

import user_data.User;
import user_data.UserGenerator;
import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;
import pojo.LoginPage;
import pojo.RegistrationPage;
import settings.SetBrowser;
import static org.hamcrest.CoreMatchers.containsString;

public class RegistrationTest extends SetBrowser {

    public final String warningMessage = "Некорректный пароль";
    public final String loginHeaderText = "Вход";
    public final String userTestLogin = "testemail456@gmail.com";
    public final String userTestPassword = "12345";
    public final String userTestName = "Nellym";

    public User user;


    @Before
    public void setUp() {
        user = UserGenerator.getValidUser();
    }


    @Test
    @DisplayName("Проверка успешной регистрации")
    public void registerUserExpectedUserRegisteredTest() {
        mainPage.clickLoginButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegistrationLink();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.fillEmail(user.getEmail());
        registrationPage.fillName(user.getName());
        registrationPage.fillPassword(user.getPassword());
        registrationPage.clickRegistrationButton();
        loginPage.waitUnitPageLoaded(100);
        MatcherAssert.assertThat(loginPage.getHeaderText(), containsString(loginHeaderText));

    }

    @Test
    @DisplayName("Проверка ввода некорректного пароля-меньше 6 символов")
    public void passwordContainsFiveCharactersExpectedWarningMessageAppearedTest() {
        mainPage.clickLoginButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegistrationLink();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.fillEmail(userTestLogin);
        registrationPage.fillName(userTestName);
        registrationPage.fillPassword(userTestPassword);
        registrationPage.clickRegistrationButton();
        MatcherAssert.assertThat(registrationPage.getWarningMessage(), containsString(warningMessage));

    }

}
