package tests;

import models.UserData;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ListPage;
import pages.SeleniumTilePage;

public class BoardsTest extends BaseTest {

    @Test
    public void boardsTest() {
        //given
        UserData userData = new UserData();
        //when
        SeleniumTilePage seleniumTilePage = new HomePage(driver)
                .openLogInPage()
                .fillUserLogIn(userData)
                .openSeleniumTile();
        //then
        Assert.assertEquals(seleniumTilePage.getBoardName().getText(), "Selenium test");
        Assert.assertEquals(seleniumTilePage.getAccessOption().getText(), "Prywatna");
    }

    @Test
    public void emptyInputTest() {
        //given
        UserData userData = new UserData();
        //when
        ListPage emptyInput = new HomePage(driver)
                .openLogInPage()
                .fillUserLogIn(userData)
                .openSeleniumTile()
                .createNewList();
        //then
        Assert.assertEquals(emptyInput.getListNameInput().getText(), "");
    }

    @Test
    public void firstListTest() {
        //given
        UserData userData = new UserData();
        //when
        ListPage listPage = new HomePage(driver)
                .openLogInPage()
                .fillUserLogIn(userData)
                .openSeleniumTile()
                .createNewList()
                .addThreeLists();
        //then
        Assert.assertEquals(listPage.getNameFirstTestList().getText(), "First Test");
        Assert.assertEquals(listPage.getNameSecondTestList().getText(), "Second Test");
        Assert.assertEquals(listPage.getNameThirdTestList().getText(), "Third Test");
    }

    @Test
    public void dragAndDropCards() {
        //given
        UserData userData = new UserData();
        //when
        SeleniumTilePage moveCard = new HomePage(driver)
                .openLogInPage()
                .fillUserLogIn(userData)
                .openSeleniumTile()
                .createNewList()
                .addThreeLists()
                .refreshPageToListPage()
                .addSixCards()
                .backToSeleniumTilePage()
                .firstActionPerformTest();
        //then
        Assert.assertEquals(moveCard.getFirstCard().getText(), "Card First");
        Assert.assertEquals(moveCard.getSecondCard().getText(), "Card Second");
        Assert.assertEquals(moveCard.getThirdCard().getText(), "Card Third");
        Assert.assertEquals(moveCard.getFourthCard().getText(), "Card Fourth");
        Assert.assertEquals(moveCard.getFifthCard().getText(), "Card Fifth");
        Assert.assertEquals(moveCard.getSixthCard().getText(), "Card Sixth");
    }

    @Test
    public void closeLists() {
        //given
        UserData userData = new UserData();
        //when
        SeleniumTilePage closeLists = new HomePage(driver)
                .openLogInPage()
                .fillUserLogIn(userData)
                .openSeleniumTile()
                .createNewList()
                .addThreeLists()
                .refreshPageToListPage()
                .addSixCards()
                .backToSeleniumTilePage()
                .firstActionPerformTest()
                .closeFirstList()
                .closeSecondList()
                .closeThirdList();
        //then
        Assert.assertEquals(closeLists.getAddNewListText().getText(), "Dodaj listę");
    }
}
