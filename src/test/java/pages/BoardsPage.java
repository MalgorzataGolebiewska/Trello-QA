package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumHelper;

import javax.swing.text.html.CSS;

public class BoardsPage {

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

    @FindBy(xpath = "//li/a[@title='Selenium test (obecnie aktywna)']")
    private WebElement boardMenu;

    @FindBy(xpath = "//div/button[@title='Zamknij tablicę']")
    private WebElement closeBoardOption;

    @FindBy(xpath = "//div/section/header/h2[@title='Zamknąć Tablicę?']")
    private WebElement closeBoardHeader;

    @FindBy(xpath = "//div/button[@title='Zamknij'")
    private WebElement closeButton;

    @FindBy(xpath = "//div/button[@data='close-board-delete-board-button']")
    private WebElement deleteButton;

    @FindBy(xpath = "//div/button[@data='close-board-delete-board-confirm-button']")
    private WebElement confirmDeleteButton;

    @FindBy(xpath = "//div/ul/li/div[@class='board-tile mod-add']")
    private WebElement createNewBoard;

    @FindBy(xpath = "//*[@id='background-picker']/ul[2]/li[5]")
    private WebElement backgroundColor;

    @FindBy(xpath = "//label/input[@class='create-board-title-input']")
    private WebElement boardTitleInput;

    @FindBy(id = "1688663871281-create-board-select-visibility")
    private WebElement boardVisibilitySelect;

    @FindBy(id ="1688663871281-create-board-select-visibility/div/div/div[1]/div")
    private WebElement privateBoardOption;

    @FindBy(xpath = "//div/form/button[@data='create-board-submit-button']")
    private WebElement createButton;

    private final WebDriver driver;

    public BoardsPage(WebDriver driver) {
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

    public BoardsPage newSeleniumTile(){
        Actions actions = new Actions(driver);
        actions.click(createNewBoard).perform();
        actions.click(backgroundColor).perform();
        actions.sendKeys("Selenium tile").perform();
        actions.click(boardVisibilitySelect).perform();
        actions.click(privateBoardOption).perform();
        actions.click(createButton).perform();
        return this;
    }

}