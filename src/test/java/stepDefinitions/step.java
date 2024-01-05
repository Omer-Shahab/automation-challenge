package stepDefinitions;

import pages.*;
import configiration.configReader;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class step {
    WebDriver driver;
    private pages.loginPage login;
    private pages.productPage product;
    private pages.productDetailsPage productDetails;
    private pages.confirmationPage confirmation;
    private pages.checkoutPage checkout;
    private pages.cartPage cart;

    @Given("User open the browser and navigate to sourcedemo")
    public void userOpenTheBrowserAndNavigateToSourcedemo() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get(configReader.getUrl());
    }

    @When("User is on login page")
    public void userRedirectToLoginPage() {
        login = new loginPage(driver);
        product = new productPage(driver);
        productDetails = new productDetailsPage(driver);
        confirmation = new confirmationPage(driver);
        checkout = new checkoutPage(driver);
        cart = new cartPage(driver);
    }

    @Then("User enters valid username {string} and password {string}")
    public void userEntersValidUsernameAndPassword(String username, String password) {
        login.enterUsername(username);
        login.enterPassword(password);
    }

    @And("Clicks on Login Button")
    public void userClicksOnTheLoginButton() {
        login.clickLoginButton();
    }

    @Then("User is navigated to home page")
    public void verifyUserNavigateToHomePage() {
        product.verifyTitle();
    }

    @Then("User is not able to navigated to product page")
    public void userIsNotAbleToNavigatedToProductPage() {
        login.verifyErrorMessage();
    }

    @And("Close the browser")
    public void closeTheBrowser() {
        driver.quit();
    }

    @And("User add the product to the cart")
    public void userAddTheProductToTheCart() {
        productDetails.clickAddToCartButton();
    }

    @And("User select a product named {string}")
    public void userSelectAProductNamed(String productName) {
        product.selectProductByName(productName);
    }

    @When("User go to the cart")
    public void userGoToTheCart() {
        cart.setCartButton();
    }

    @And("User proceed to checkout")
    public void userProceedToCheckout() {
        cart.clickCheckoutButton();
    }

    @And("User enter the following checkout information:")
    public void userEnterTheFollowingCheckoutInformation(io.cucumber.datatable.DataTable dataTable) {
        checkout.enterFirstName("MyName");
        checkout.enterLastName("testing");
        checkout.enterZipCode("123456");
    }

    @And("User continue with the checkout")
    public void userContinueWithTheCheckout() {
        checkout.clickContinueButton();
    }

    @And("User complete the order")
    public void userCompleteTheOrder() {
        checkout.clickFinishButton();
    }

    @Then("User should see a confirmation message {string}")
    public void userShouldSeeAConfirmationMessage(String expectedMessage) {
        String actualMessage = confirmation.getCompleteMessage();

    }
}
