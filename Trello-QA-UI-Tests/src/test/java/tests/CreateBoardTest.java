package tests;

import models.UserData;
import org.testng.annotations.Test;
import pages.BoardsPage;
import pages.HomePage;
import pages.SeleniumTilePage;

public class CreateBoardTest extends BaseTest{

    @Test
    public void createNewBoardTest(){

        UserData userData = new UserData();

        BoardsPage newBoard = new HomePage(driver)
                .openLogInPage()
                .fillUserLogIn(userData)
                .createNewSeleniumTile();
    }
}
