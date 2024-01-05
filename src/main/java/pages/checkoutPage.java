package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class checkoutPage {
    private final WebDriver driver;

    @FindBy(id = "first-name")
    private WebElement firstNameField;

    @FindBy(id = "last-name")
    private WebElement lastNameField;

    @FindBy(id = "postal-code")
    private WebElement zipCodeField;

    @FindBy(css = "input[name='continue']")
    private WebElement continueButton;

    @FindBy(css = "button[id='finish']")
    private WebElement finishButton;

    public checkoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterFirstName(String firstName) {
        waitForElementAndSendKeys(firstNameField, firstName);
    }

    public void enterLastName(String lastName) {
        waitForElementAndSendKeys(lastNameField, lastName);
    }

    public void enterZipCode(String zipCode) {
        waitForElementAndSendKeys(zipCodeField, zipCode);
    }

    public void clickContinueButton() {
        waitForElementAndClick(continueButton);
    }

    public void clickFinishButton() {
        waitForElementAndClick(finishButton);
    }

    private void waitForElementAndSendKeys(WebElement element, String value) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(value);
    }

    private void waitForElementAndClick(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
}
