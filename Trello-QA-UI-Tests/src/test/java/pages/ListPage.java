package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

public class ListPage {

    @FindBy(xpath = "//input[@class='list-name-input' and contains(@placeholder,'Wprowadź tytuł listy')]")
    private WebElement listNameInput;

    @FindBy(xpath = "//div/input[@value='Dodaj Listę']")
    private WebElement listAddButton;

    @FindBy(xpath = "//div/div[@data='list-header']")
    private WebElement listHeader;

    @FindBy(xpath = "//div/a[@class='icon-lg icon-close dark-hover js-cancel-edit']")
    private WebElement cencelIcon;

    @FindBy(xpath = "//div/textarea[text()='Second Test']")
    private WebElement nameSecondTestList;

    @FindBy(xpath = "//div/textarea[text()='First Test']")
    private WebElement nameFirstTestList;

    @FindBy(xpath = "//div/textarea[text()='Third Test']")
    private WebElement nameThirdTestList;

    protected final WebDriver driver;

    public ListPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getListNameInput() {
        return listNameInput;
    }

    public ListPage addThreeLists(){
        List<String> listNames = Arrays.asList("First Test", "Second Test", "Third Test");
        for (String listName : listNames) {
            setListName(listName, listName.equals("Third Test"));
        }
        return this;
    }

    private ListPage setListName(String listName, boolean cancel) {

        Actions actions = new Actions(driver);
        actions.click(listNameInput).sendKeys(listName).perform();
        actions.click(listAddButton).perform();
        if (cancel){
            actions.click(cencelIcon).perform();
        }
        return this;
    }

    public WebElement getNameSecondTestList() {
        return nameSecondTestList;
    }

    public WebElement getNameFirstTestList() {
        return nameFirstTestList;
    }

    public WebElement getNameThirdTestList() {
        return nameThirdTestList;
    }

    public CardPage refreshPageToListPage() {
        driver.navigate().refresh();
        return new CardPage(driver);
    }

}