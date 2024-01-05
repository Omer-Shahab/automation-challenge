package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class cartPage {
    private final WebDriver driver;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;
    @FindBy(css = "div[id='shopping_cart_container']")
    private WebElement cartButton;


    public cartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickCheckoutButton() {
        waitForElementToBeClickable(checkoutButton);
        checkoutButton.click();
    }

    public void setCartButton() {
        waitForElementToBeClickable(cartButton);
        cartButton.click();
    }

private void waitForElementToBeClickable(WebElement element) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.elementToBeClickable(element));
}

}
