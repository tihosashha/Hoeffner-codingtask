package pages;

import base.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OutlookMailPage extends AbstractPage {

    public OutlookMailPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "/html/body/header/div/aside/div/nav/ul/li[2]/a")
    WebElement authorizationButton;

    @FindBy(id = "i0116")
    WebElement emailField;

    @FindBy(id = "idSIButton9")
    WebElement furtherButton;

    @FindBy(id = "i0118")
    WebElement passwordField;

    @FindBy(id = "idSIButton9")
    WebElement loginButton;

    @FindBy(id = "idSIButton9")
    WebElement stayLoggedInDenyButton;

    @FindBy(id = "Pivot26-Tab1")
    WebElement otherLettersTab;

    @FindBy(xpath = "//span[text()=\"Höffner\"]")
    WebElement openLetterHoeffer;

    @FindBy(xpath = "//*[@title=\"Jetzt Anmeldung abschließen\"]")
    WebElement linkHoeffnerButton;

    public void clickOnTheAuthorizationButton() {
        authorizationButton.click();
    }

    public void inputEmail(String email) {
        emailField.sendKeys(email);
    }

    public void clickOnTheFurtherButton() {
        furtherButton.click();
    }

    public void inputPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickOnTheLoginButton() {
        loginButton.click();
    }

    public void acceptConfirmationNotLoggingOut() {
        stayLoggedInDenyButton.click();
    }

    public void openHoeffnerLetter() {
        openLetterHoeffer.click();
    }

    public void openHoeffnerLinkInTheMassage() {
        linkHoeffnerButton.click();
    }

    public void clickOpenOtherLettersTab() {
        otherLettersTab.click();
    }

    @Override
    protected String getPageUrl() {
        return "https://outlook.live.com/owa/";
    }
}
