package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumHelper;

public class SeleniumTilePage {

    @FindBy(xpath = "//div/h1[text()='Selenium test']")
    private WebElement boardName;

    @FindBy(xpath = "//div/button[text()='Prywatna']")
    private WebElement accesOption;

    @FindBy(xpath = "//div/form/a[@class='open-add-list js-open-add-list']")
    private WebElement newListButton;

    @FindBy(xpath = "//div/textarea[text()='Second Test']")
    private WebElement secondTestList;

    @FindBy(xpath = "//div/textarea[text()='First Test']")
    private WebElement firstTestList;

    @FindBy(xpath = "//div/textarea[text()='Third Test']")
    private WebElement thirdTestList;

    @FindBy(xpath = "//div[@class='list-card-details js-card-details']/span[text()='Card First']")
    private WebElement firstCard;

    @FindBy(xpath = "//div[@class='list-card-details js-card-details']/span[text()='Card Second']")
    private WebElement secondCard;

    @FindBy(xpath = "//div[@class='list-card-details js-card-details']/span[text()='Card Third']")
    private WebElement thirdCard;

    @FindBy(xpath = "//div[@class='list-card-details js-card-details']/span[text()='Card Fourth']")
    private WebElement fourthCard;

    @FindBy(xpath = "//div[@class='list-card-details js-card-details']/span[text()='Card Fifth']")
    private WebElement fifthCard;

    @FindBy(xpath = "//div[@class='list-card-details js-card-details']/span[text()='Card Sixth']")
    private WebElement sixthCard;

    @FindBy(xpath = "//div/a[@class='list-header-extras-menu js-open-list-menu icon-sm icon-overflow-menu-horizontal']")
    private WebElement listMenuIcon;

    @FindBy(xpath = "//ul/li/a[@class='js-close-list']")
    private WebElement closeListOption;

    private final WebDriver driver;

    public SeleniumTilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getBoardName() {
        SeleniumHelper.waitForElementToBeVisible(driver, boardName);
        return boardName;
    }

    public WebElement getAccesOption() {
        return accesOption;
    }

    public ListPage addNewListButton() {
        newListButton.click();
        return new ListPage(driver);
    }

    public WebElement getAddNewListText() {
        return newListButton;
    }

    public WebElement toSecondTestList() {
        SeleniumHelper.waitForClickable(secondTestList, driver);
        return secondTestList;
    }

    public WebElement getFirstCard() {
        SeleniumHelper.waitForClickable(firstCard, driver);
        return firstCard;
    }

    public WebElement toFirstTestList() {
        SeleniumHelper.waitForClickable(firstTestList, driver);
        return firstTestList;
    }

    public WebElement toThirdTestList() {
        SeleniumHelper.waitForClickable(thirdTestList, driver);
        return thirdTestList;
    }

    public WebElement getSecondCard() {
        SeleniumHelper.waitForClickable(secondCard, driver);
        return secondCard;
    }

    public WebElement getThirdCard() {
        SeleniumHelper.waitForClickable(thirdCard, driver);
        return thirdCard;
    }

    public WebElement getFourthCard() {
        SeleniumHelper.waitForClickable(fourthCard, driver);
        return fourthCard;
    }

    public WebElement getFifthCard() {
        SeleniumHelper.waitForClickable(fifthCard, driver);
        return fifthCard;
    }

    public WebElement getSixthCard() {
        SeleniumHelper.waitForClickable(sixthCard, driver);
        return sixthCard;
    }

    public SeleniumTilePage refreshSeleniumTilePage() {
        driver.navigate().refresh();
        return this;
    }

    public SeleniumTilePage firstActionPerformTest() {

        Actions actions = new Actions(driver);
        actions.moveToElement(getFirstCard());
        actions.clickAndHold();
        actions.moveToElement(toSecondTestList());
        actions.release().perform();

        actions.moveToElement(getThirdCard());
        actions.clickAndHold();
        actions.moveToElement(toThirdTestList());
        actions.release().perform();

        actions.moveToElement(getSixthCard());
        actions.clickAndHold();
        actions.moveToElement(toSecondTestList());
        actions.release().perform();

        actions.moveToElement(getFifthCard());
        actions.clickAndHold();
        actions.moveToElement(toSecondTestList());
        actions.release().perform();
        return this;
    }

    public SeleniumTilePage closeFirstList() {
        SeleniumHelper.waitForClickable(listMenuIcon, driver);
        Actions actions = new Actions(driver);
        actions.click(firstTestList).perform();
        actions.click(listMenuIcon).perform();
        actions.click(closeListOption).perform();
        return new SeleniumTilePage(driver);
    }

    public SeleniumTilePage closeSecondList() {
        SeleniumHelper.waitForClickable(listMenuIcon, driver);
        Actions actions = new Actions(driver);
        actions.click(secondTestList).perform();
        actions.click(listMenuIcon).perform();
        actions.click(closeListOption).perform();
        return new SeleniumTilePage(driver);
    }

    public SeleniumTilePage closeThirdList() {
        SeleniumHelper.waitForClickable(listMenuIcon, driver);
        Actions actions = new Actions(driver);
        actions.click(thirdTestList).perform();
        actions.click(listMenuIcon).perform();
        actions.click(closeListOption).perform();
        return new SeleniumTilePage(driver);
    }

}
