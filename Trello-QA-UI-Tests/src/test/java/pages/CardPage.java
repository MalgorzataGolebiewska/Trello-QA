package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumHelper;

import java.util.Arrays;
import java.util.List;

public class CardPage {

    @FindBy(xpath = "//span[@class='js-add-a-card']")
    private WebElement addCardButton;

    @FindBy(xpath = "//div/div[@class='list-card-details u-clearfix']")
    private WebElement nameCard;

    @FindBy(xpath = "//div/input[@value='Dodaj Kartę']")
    private WebElement addCardToList;

    @FindBy(xpath = "//div/a[@class='icon-lg icon-close dark-hover js-cancel-edit']")
    private WebElement cancelIcon;

    protected final WebDriver driver;

    public CardPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public CardPage addSixCards() {

        Actions actions = new Actions(driver);
        actions.click(addCardButton).perform();
        List<String> cardNames = Arrays.asList("Card First", "Card Second", "Card Third", "Card Fourth", "Card Fifth", "Card Sixth");
        for (String cardName : cardNames) {
            addSingleCard(cardName, cardName.equals("Card Sixth"));
        }
        return this;
    }

    public SeleniumTilePage backToSeleniumTilePage() {
        driver.navigate().refresh();
        return new SeleniumTilePage(driver);
    }

    private CardPage addSingleCard(String cardName, boolean refresh) {

        Actions actions = new Actions(driver);
        actions.click(nameCard).sendKeys(cardName).perform();
        actions.click(addCardToList).perform();
        if (refresh) {
            driver.navigate().refresh();
        }
        return this;
    }

}