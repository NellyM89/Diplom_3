package settings;

import org.openqa.selenium.WebDriver;

public abstract class Base {

    protected final WebDriver driver;


    public Base(WebDriver driver) {

        this.driver = driver;
    }

}