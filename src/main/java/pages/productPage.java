package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import java.util.List;

public class productPage {
    private final WebDriver driver;

    @FindBy(className = "inventory_item_name")
    List<WebElement> allProductsName;

    @FindBy(css = ".title")
    private WebElement getTitle;

    @FindBy(css = ".select_container")
    private WebElement clickFilter;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    public productPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verifyTitle() {
        waitForElement(getTitle);
        Assert.assertEquals(getTitle.getText(), "Products");
    }

    public void clickFilterBtn() {
        waitForElement(clickFilter);
        clickFilter.click();
    }

    public void clickLoginButton() {
        waitForElement(loginButton);
        loginButton.click();
    }

    private void waitForElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void selectProductByName(String productName) {
        for (WebElement product : allProductsName) {
            if (product.getText().equals(productName)) {
                System.out.println("Selecting product: " + productName);
                try {
                    product.click();
                } catch (StaleElementReferenceException | ElementNotInteractableException e) {
                    System.out.println("Failed to click on product: " + productName);
                }
                break;
            }
        }
    }
}
