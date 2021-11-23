package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {

    protected WebDriver webDriver;

    public AbstractPage(WebDriver webDriver) {
        webDriver.get(getPageUrl());
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    protected abstract String getPageUrl();
}
