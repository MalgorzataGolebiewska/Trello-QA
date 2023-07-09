package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(xpath = "//a[contains(text(), 'Log in')]")
    private WebElement logInButton;

    @FindBy(xpath = "//div/h1[text()='Trello brings all your tasks, teammates, and tools together']")
    private WebElement textBlock;

    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public LogInPage openLogInPage() {
        logInButton.click();
        return new LogInPage(driver);
    }

    public WebElement getTextBlock() {
        return textBlock;
    }

}