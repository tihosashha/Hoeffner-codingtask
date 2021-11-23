package tests;

import base.AbstractChromeWebDriverTest;
import org.junit.Test;
import pages.HoeffnerLoginPage;
import pages.OutlookMailPage;

import static org.junit.Assert.assertTrue;

public class NewLetterSubscriptionTest extends AbstractChromeWebDriverTest {

    private static final String TEST_EMAIL = "hoeffner.test@outlook.com";
    private static final String TEST_PASSWORD = "1qaz2ws3edc";

    private static final String EMAIL_CONFIRMATION_PAGE = "https://www.hoeffner.de/nl-anmeldung-abgeschlossen";

    @Test
    public void testSubscribeToNewsLatter() {
        HoeffnerLoginPage hoffnerLoginPage = new HoeffnerLoginPage(driver);
        // Confirmation of cookie settings
        hoffnerLoginPage.clickConsentAcceptButton();
        //Check that email field is visible
        hoffnerLoginPage.checkThatEmailFieldIsVisible();
        //Entering an email address to subscribe to the newsletter
        long currentTimestamp = System.currentTimeMillis();
        String email = "hoeffner.test+" + currentTimestamp + "@outlook.com";
        hoffnerLoginPage.typeNewsletterEmail(email);
        //Pressing the button "Absenden"
        hoffnerLoginPage.clickNewsletterFormSubmitButton();
        sleep(2);
        //Check that newsletter confirmation visible
        hoffnerLoginPage.checkThatNewsletterConfirmationIsVisible();
    }

    @Test
    public void testNewsOutlookLatter() {
        HoeffnerLoginPage hoeffnerLoginPage = new HoeffnerLoginPage(driver);
        //Confirmation of cookie settings
        hoeffnerLoginPage.clickConsentAcceptButton();
        //Check that email field is visible
        hoeffnerLoginPage.checkThatEmailFieldIsVisible();
        //Entering an email address to subscribe to the newsletter
        hoeffnerLoginPage.typeNewsletterEmail(TEST_EMAIL);
        //Pressing the button "Absenden"
        hoeffnerLoginPage.clickNewsletterFormSubmitButton();
        sleep(1);
        //Opening an outlook mail site
        OutlookMailPage mailOutlook = new OutlookMailPage(driver);
        //Clicking on the "Login" button
        mailOutlook.clickOnTheAuthorizationButton();
        //Enter email
        mailOutlook.inputEmail(TEST_EMAIL);
        //Clicking on the "Next" button
        mailOutlook.clickOnTheFurtherButton();
        sleep(1);
        //Password input
        mailOutlook.inputPassword(TEST_PASSWORD);
        //Pressing the "Login" button
        mailOutlook.clickOnTheLoginButton();
        sleep(1);
        //Accept confirmation "Not logging out"
        mailOutlook.acceptConfirmationNotLoggingOut();
        sleep(3);
        //Opening the list of letters
        mailOutlook.clickOpenOtherLettersTab();
        sleep(1);
        //Open Hoeffner letter
        mailOutlook.openHoeffnerLetter();
        // Click on the button "Jetzt Anmeldung abschließen"
        mailOutlook.openHoeffnerLinkInTheMassage();
        sleep(3);
        //Switch to tab
        switchToTab(1);
        //Checking that the link matches "https://www.hoeffner.de/nl-anmeldung-abgeschlossen"
        assertTrue(driver.getCurrentUrl().contains(EMAIL_CONFIRMATION_PAGE));
    }
}

