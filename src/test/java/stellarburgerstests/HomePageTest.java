package stellarburgerstests;

import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import settings.SetBrowser;
import static org.hamcrest.CoreMatchers.containsString;

public class HomePageTest extends SetBrowser {

    private final String indicatorClass = "tab_tab_type_current__2BEPc";

    @Test
    @DisplayName("Проверка перехода из раздела Булочки в раздел Соусы")
    public void switchToSauceSectionAfterClickingSauceSectionButtonTest() {
        mainPage.waitUnitPageLoaded(8);
        mainPage.clickSauceSectionButton();
        MatcherAssert.assertThat(mainPage.getSauceSectionClass(), containsString(indicatorClass));
    }

    @Test
    @DisplayName("Проверка перехода из раздела Булочки в раздел Начинки")
    public void switchToFillingSectionAfterClickingFillingSectionButtonTest() {
        mainPage.waitUnitPageLoaded(8);
        mainPage.clickFillingSectionButton();
        MatcherAssert.assertThat(mainPage.getFillingSectionClass(), containsString(indicatorClass));
    }

    @Test
    @DisplayName("Проверка перехода из раздела Начинка в раздел Булочки")
    public void switchToBunSectionAfterClickingBunSectionButtonTest() {
        mainPage.waitUnitPageLoaded(8);
        mainPage.clickFillingSectionButton();
        mainPage.clickBunSectionButton();
        MatcherAssert.assertThat(mainPage.getBunSectionClass(), containsString(indicatorClass));
    }

}
