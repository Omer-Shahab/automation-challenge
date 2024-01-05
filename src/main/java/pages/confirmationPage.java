package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class confirmationPage {
    private final WebDriver driver;

    @FindBy(css = "h2[class='complete-header']")
    private WebElement completeMessageLabel;

    public confirmationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getCompleteMessage() {
        waitForElement(completeMessageLabel);
        return completeMessageLabel.getText();
    }


// LOGGER.info("Verifying 'Add New' employee page loaded");
    private void waitForElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

}
