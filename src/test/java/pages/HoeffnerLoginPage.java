package pages;

import base.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.assertTrue;


public class HoeffnerLoginPage extends AbstractPage {

    public HoeffnerLoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//*[@id=\"responsive\"]/div[16]/div/div/div[2]/div[2]/button")
    WebElement consentAcceptButton;

    @FindBy(id = "email")
    WebElement emailField;

    @FindBy(id = "newsletterFormSubmitBtn")
    WebElement newsletterFormSubmitButton;

    @FindBy(className = "footerNewsletter__confirmation")
    WebElement footerNewsletterConfirmation;

    public void clickConsentAcceptButton() {
        consentAcceptButton.click();
    }

    public void typeNewsletterEmail(String email) {
        emailField.sendKeys(email);
    }

    public void clickNewsletterFormSubmitButton() {
        newsletterFormSubmitButton.click();
    }

    public void checkThatEmailFieldIsVisible() {
        assertTrue(emailField.isDisplayed());
    }

    public void checkThatNewsletterConfirmationIsVisible() {
        assertTrue(footerNewsletterConfirmation.isDisplayed());
    }

    @Override
    protected String getPageUrl() {
        return "https://hoeffner.de/login";
    }
}
