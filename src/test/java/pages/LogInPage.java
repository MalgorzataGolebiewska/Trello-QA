package pages;

import models.UserData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumHelper;

public class LogInPage {

    @FindBy(xpath = "//h1[text()='Zaloguj do Trello']")
    private WebElement logInToTrello;

    @FindBy(id = "user")
    private WebElement userEmailInput;

    @FindBy(id = "login")
    private WebElement logInEmailButton;

    @FindBy(id = "password")
    private WebElement userPasswordInput;

    @FindBy(id = "login-submit")
    private WebElement submitButton;

    @FindBy(xpath = "//div[@class='css-8l7mlw']")
    private WebElement usernameHidden;

    private final WebDriver driver;

    public LogInPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getLogInToTrello() {
        return logInToTrello;
    }

    public WebElement getUserEmailInput() {
        return userEmailInput;
    }

    public WebElement getUsernameHidden() {
        return usernameHidden;
    }

    public WebElement getUserPasswordInput() {
        SeleniumHelper.waitForElementToBeVisible(driver, userPasswordInput);
        return userPasswordInput;
    }

    public LogInPage fillEmailInput(UserData userData) {
        userEmailInput.sendKeys(userData.getEmail());
        logInEmailButton.click();
        return this;
    }

    public BoardsLayout fillUserLogIn(UserData userData) {
        userEmailInput.sendKeys(userData.getEmail());
        logInEmailButton.click();
        getUserPasswordInput().sendKeys(userData.getPassword());
        submitButton.click();
        return new BoardsLayout(driver);
    }

}