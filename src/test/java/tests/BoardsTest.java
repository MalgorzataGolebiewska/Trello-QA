package tests;

import models.UserData;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SeleniumTilePage;

public class BoardsTest extends BaseTest{

    @Test
    public void boardsTest(){
        //given
        UserData userData = new UserData();
        //when
        SeleniumTilePage seleniumTilePage = new HomePage(driver)
                .openLogInPage()
                .fillUserLogIn(userData)
                .openSeleniumTile();

        Assert.assertEquals(seleniumTilePage.getBoardName().getText(),"Selenium test");
        Assert.assertEquals(seleniumTilePage.getAccesOption().getText(),"Prywatna");

    }


}
