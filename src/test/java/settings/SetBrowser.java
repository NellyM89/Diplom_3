package settings;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pojo.HomePage;

public class SetBrowser {


    private final String url = "https://stellarburgers.nomoreparties.site/";
    private final String chromeBrowser = "Chrome";
    private final String yandexBrowser = "Yandex";
    protected WebDriver driver;
    protected HomePage mainPage;

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        selectBrowser(yandexBrowser);//selectBrowser(chromeBrowser); для запуска в chrome
        mainPage = new HomePage(driver);
        driver.get(url);
        driver.manage().window().maximize();

    }

    public void selectBrowser(String browser) {
        if (browser.equals(chromeBrowser)) {
            driver = new ChromeDriver();
        } else if (browser.equals(yandexBrowser)) {
            System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\yandex_browser\\yandexdriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.setBinary("C:\\Users\\Sergey\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
            driver = new ChromeDriver(options);
        }
    }

    @After
    public void tearDown() {

        driver.quit();
    }

}
