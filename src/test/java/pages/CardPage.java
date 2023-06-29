package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumHelper;

public class CardPage {

    @FindBy(xpath = "//span[@class='js-add-a-card']")
    private WebElement addCardButton;

    @FindBy(xpath = "//div/div[@class='list-card-details u-clearfix']")
    private WebElement nameCard;

    @FindBy(xpath = "//div/input[@value='Dodaj Kartę']")
    private WebElement addCardToList;

    @FindBy(xpath = "//div/a[@class='icon-lg icon-close dark-hover js-cancel-edit']")
    private WebElement cencelIcon;


    protected final WebDriver driver;

    public CardPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getAddCardButton() {
        SeleniumHelper.waitForClickable(addCardButton, driver);
        return addCardButton;
    }

    public WebElement getNameCard() {
        SeleniumHelper.waitForClickable(nameCard, driver);
        return nameCard;
    }

    public WebElement getAddCardToList() {
        SeleniumHelper.waitForClickable(addCardToList, driver);
        return addCardToList;
    }


    public CardPage firstCardName() {

        Actions actions = new Actions(driver);
        actions.click(addCardButton).perform();
        actions.click(nameCard).sendKeys("Card First").perform();
        actions.click(addCardToList).perform();
        return this;
    }

    public CardPage secondCardName() {

        Actions actions = new Actions(driver);
        actions.click(nameCard).sendKeys("Card Second").perform();
        actions.click(addCardToList).perform();
        return this;
    }

    public CardPage thirdCardName() {

        Actions actions = new Actions(driver);
        actions.click(nameCard).sendKeys("Card Third").perform();
        actions.click(addCardToList).perform();
        return this;
    }

    public CardPage fourthCardName() {

        Actions actions = new Actions(driver);
        actions.click(nameCard).sendKeys("Card Fourth").perform();
        actions.click(addCardToList).perform();
        return this;
    }

    public CardPage fifthCardName() {

        Actions actions = new Actions(driver);
        actions.click(nameCard).sendKeys("Card Fifth").perform();
        actions.click(addCardToList).perform();
        return this;
    }

    public CardPage sixthCardName() {

        Actions actions = new Actions(driver);
        actions.click(nameCard).sendKeys("Card Sixth").perform();
        actions.click(addCardToList).perform();
        driver.navigate().refresh();
        return this;
    }

    public CardPage addSixCard() {

        Actions actions = new Actions(driver);
        actions.click(addCardButton).perform();
        actions.click(nameCard).sendKeys("Card First").perform();
        actions.click(addCardToList).perform();
        actions.click(nameCard).sendKeys("Card Second").perform();
        actions.click(addCardToList).perform();
        actions.click(nameCard).sendKeys("Card Third").perform();
        actions.click(addCardToList).perform();
        actions.click(nameCard).sendKeys("Card Fourth").perform();
        actions.click(addCardToList).perform();
        actions.click(nameCard).sendKeys("Card Fifth").perform();
        actions.click(addCardToList).perform();
        actions.click(nameCard).sendKeys("Card Sixth").perform();
        actions.click(addCardToList).perform();
        return this;
    }

    public SeleniumTilePage backToSeleniumTilePage() {
        driver.navigate().refresh();
        return new SeleniumTilePage(driver);
    }

}