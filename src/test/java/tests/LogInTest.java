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
        UserData userData = new UserData();
        //when
        LogInPage logInPage = new HomePage(driver)
                .getLogInButton();
        String afterLogInInfo = logInPage.getZalogujDoTrello().getText();
        String emptyUserEmail = logInPage.getUserEmailInput().getText();
        LogInPage logInPagePassword = logInPage.fillEmailInput(userData);
        String loginUsername = logInPagePassword.getUsernameHidden().getText();
        String loginPassword = logInPagePassword.getUserPasswordInput().getText();
        //then
        Assert.assertEquals(afterLogInInfo, "Zaloguj do Trello");
        Assert.assertEquals(emptyUserEmail, "");
        Assert.assertEquals(loginUsername, "automated.testing00@gmail.com");
        Assert.assertEquals(loginPassword, "");
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

}
