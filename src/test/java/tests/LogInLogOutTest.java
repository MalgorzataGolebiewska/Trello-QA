package tests;

import models.UserData;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BoardsPage;
import pages.HomePage;
import pages.LogInPage;
import pages.LogOutPage;

public class LogInLogOutTest extends BaseTest {

    @Test
    public void logInTest() {
        //given
        UserData userData = new UserData();
        //when
        LogInPage logInPage = new HomePage(driver)
                .openLogInPage();
        String afterLogInInfo = logInPage.getLogInToTrello().getText();
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
        BoardsPage loggedUserTrelloPage = new HomePage(driver)
                .openLogInPage()
                .fillUserLogIn(userData);
        //then
        Assert.assertEquals(loggedUserTrelloPage.getHeaderName().getText(), "TWOJE PRZESTRZENIE ROBOCZE");
    }

    @Test
    public void logOutTest() {
        //given
        UserData userData = new UserData();
        //when
        LogOutPage logOutUser = new HomePage(driver)
                .openLogInPage()
                .fillUserLogIn(userData)
                .openLogOutPage();
        String logOutHeader = logOutUser.getLogOutHeader().getText();
        HomePage homePage = logOutUser.logOutToHomePage();
        String textBlock = homePage.getTextBlock().getText();
        //then
        Assert.assertEquals(logOutHeader, "Wyloguj się z konta Atlassian");
        Assert.assertEquals(textBlock, "Trello brings all your tasks, teammates, and tools together");
    }

}
