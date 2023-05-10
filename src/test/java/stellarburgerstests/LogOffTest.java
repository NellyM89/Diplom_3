package stellarburgerstests;

import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import pojo.AccountProfilePage;
import pojo.LoginPage;
import settings.SetBrowser;
import static org.hamcrest.CoreMatchers.containsString;

public class LogOffTest extends SetBrowser {

    public final String userTestLogin = "nellytest24@gmail.com";
    public final String userTestPassword = "Nm01234567.";
    public final String loginHeaderText = "Вход";


    @Test
    @DisplayName("Выход из аккаунта")
    public void userIsLoggedOffAfterClickingExitButtonTest() {
        mainPage.clickAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillEmail(userTestLogin);
        loginPage.fillPassword(userTestPassword);
        loginPage.clickLoginButton();
        mainPage.waitUnitPageLoaded(8);
        mainPage.clickAccountButton();
        AccountProfilePage accountProfilePage = new AccountProfilePage(driver);
        accountProfilePage.waitUnitPageLoaded(100);
        accountProfilePage.clickExitButton();
        loginPage.waitUnitPageLoaded(8);
        MatcherAssert.assertThat(loginPage.getHeaderText(), containsString(loginHeaderText));
    }

}
