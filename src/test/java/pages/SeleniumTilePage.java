package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumHelper;

public class SeleniumTilePage {

    @FindBy(xpath = "//div/h1[text()='Selenium test']")
    private WebElement boardName;
    //*[@id="content"]/div/div[1]/div[1]/div/div/span[1]/div[2]/h1
    @FindBy(xpath = "//div/button[text()='Prywatna']")
    private WebElement accesOption;

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
}
