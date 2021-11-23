package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractChromeWebDriverTest {

    protected WebDriver driver;

    public AbstractChromeWebDriverTest() {
        super();
    }

    @Before
    public void beforeTest() {
        //Download the web driver executable
        WebDriverManager.chromedriver().setup();

        //Create a instance of your web driver - chrome
        driver = new ChromeDriver();
    }

    @After
    public void afterTest() {
        driver.quit();
    }

    protected void switchToTab(int tabIndex) {
        driver.switchTo().window(getActiveTabs().get(tabIndex));
    }

    protected List<String> getActiveTabs() {
        return new ArrayList<>(driver.getWindowHandles());
    }

    public void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}