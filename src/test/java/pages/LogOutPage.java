package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOutPage {

    @FindBy(xpath = "//div/h5[text()='Wyloguj się z konta Atlassian']")
    private WebElement logOutHeader;

    @FindBy(id = "logout-submit")
    private WebElement logOutSubmitButton;

    private final WebDriver driver;
    public LogOutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getLogOutHeader() {
        return logOutHeader;
    }

    public HomePage logOutToHomePage(){
        logOutSubmitButton.click();
        return new HomePage(driver);
    }
}
