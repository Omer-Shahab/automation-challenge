package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class productDetailsPage {
    private final WebDriver driver;
    @FindBy(css = "inventory_details_name")
    private WebElement productTitleLabel;
    @FindBy(css = "inventory_details_container")
    private WebElement getDescription;
    @FindBy(css ="button[id^='add-to-cart']")
    private WebElement addToCartButton;

    public productDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void getProductTitle() {
        waitForElement(getDescription);
        Assert.assertTrue(getDescription.isDisplayed(), "Descriptive");
    }

    public void clickAddToCartButton() {
        waitForElementToBeClickable(addToCartButton);
        addToCartButton.click();
    }

    private void waitForElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

private void waitForElementToBeClickable(WebElement element) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.elementToBeClickable(element));
}

}
