package tests;

import models.UserData;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LogInPage;
import pages.LoggedUserTrelloPage;

public class LogInTest extends BaseTest {

    @Test
    public void logInTest() {
        //given
        //when
        LogInPage logInPage = new HomePage(driver)
                .getLogInButton();
        //then
        Assert.assertEquals(logInPage.getZalogujDoTrello().getText(), "Zaloguj do Trello");
    }

    @Test
    public void logInPageTest() {
        //given
        UserData userData = new UserData();
        //when
        LoggedUserTrelloPage loggedUserTrelloPage = new HomePage(driver)
                .getLogInButton()
                .fillUserLogIn(userData);
        //then
        Assert.assertEquals(loggedUserTrelloPage.getHeaderName().getText(), "TWOJE PRZESTRZENIE ROBOCZE");
    }

    @Test
    public void emptyEmailInputTest() {
        LogInPage logInPageEmail = new HomePage(driver)
                .getLogInButton();

        Assert.assertEquals(logInPageEmail.getUserEmailInput().getText(), "");

    }

    @Test
    public void emptyPasswordInputTest() {
        //given
        UserData userData = new UserData();
        //when
        LogInPage logInPagePassword = new HomePage(driver)
                .getLogInButton()
                .fillEmailInput(userData);

        Assert.assertEquals(logInPagePassword.getUsernameHidden().getText(), "automated.testing00@gmail.com");
        Assert.assertEquals(logInPagePassword.getUserPasswordInput().getText(), "");
    }

}
