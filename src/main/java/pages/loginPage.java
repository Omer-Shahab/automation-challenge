package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class loginPage {
    private final WebDriver driver;

    @FindBy(id = "user-name")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(css = "h3[data-test='error']")
    private WebElement getErrorMessage;


    public loginPage(WebDriver driver) {
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username) {
        waitForElement(usernameField);
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        waitForElement(passwordField);
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        waitForElement(loginButton);
        loginButton.click();
    }
    public void verifyErrorMessage() {
        waitForElement(getErrorMessage);
        Assert.assertTrue(getErrorMessage.isDisplayed(),"Username is invalid");
    }

    private void waitForElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
