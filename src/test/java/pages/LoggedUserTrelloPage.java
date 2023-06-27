package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumHelper;

public class LoggedUserTrelloPage {

    @FindBy(xpath = "//h3[text()='TWOJE PRZESTRZENIE ROBOCZE']")
    private WebElement headerName;

    @FindBy(xpath = "//div/span[@title='automated test (automatedtesting00)']")
    private WebElement userButtonMenu;

    @FindBy(xpath = "//li/button/span[text()='Wyloguj']")
    private WebElement logOutButton;

    @FindBy(xpath = "//div[@title='Selenium test']")
    private WebElement seleniumTestTile;

    @FindBy(xpath = "//div[@class='board-tile mod-add']")
    private WebElement addNewBoardTile;

    private final WebDriver driver;

    public LoggedUserTrelloPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getHeaderName() {
        return headerName;
    }

    public LogOutPage openLogOutPage() {
        SeleniumHelper.waitForElementToBeVisible(driver, userButtonMenu);
        userButtonMenu.click();
        logOutButton.click();
        return new LogOutPage(driver);
    }

    public SeleniumTilePage openSeleniumTile() {
        seleniumTestTile.click();
        return new SeleniumTilePage(driver);
    }

    public WebElement getAddNewBoardTile() {
        return addNewBoardTile;
    }
}
