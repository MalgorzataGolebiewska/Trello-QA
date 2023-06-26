package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoggedUserTrelloPage {

    @FindBy(xpath = "//h3[text()='TWOJE PRZESTRZENIE ROBOCZE']")
    private WebElement headerName;

    private final WebDriver driver;

    public LoggedUserTrelloPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getHeaderName() {
        return headerName;
    }
}
