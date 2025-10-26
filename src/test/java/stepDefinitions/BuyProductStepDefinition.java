package stepDefinitions;

import dzakyautomation.BaseTest;
import dzakyautomation.StockbitMobileTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ser.Serializers;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BuyProductStepDefinition {
    public AndroidDriver driver;
    public AppiumDriverLocalService service;

    @Given("user is on ecommerce landing page")
    public void user_is_on_ecommerce_landing_page() throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Pixel_3a");
        options.setApp("D:\\Automation Blibli\\appium_1\\src\\test\\rscrs\\mda-1.0.13-15.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Thread.sleep(2000);
    }

    @When("user open product detail page for {string} item")
    public void userOpenProductDetailPageForItem(String productName) {
        driver.findElement(By.xpath(String.format("//androidx.recyclerview.widget.RecyclerView[@content-desc='Displays all products of catalog']/android.view.ViewGroup/android.widget.ImageView[@content-desc='%s']", productName))).click();
    }

    @Then("user select colour {string} for the item")
    public void userSelectColourForTheItem(String colour) {
        driver.findElement(By.xpath(String.format("//android.widget.ImageView[@content-desc='%s color']", colour))).click();
    }

    @And("user increase quantity until {string} pieces")
    public void userIncreaseQuantityUntilPieces(String quantity) {
        driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='Increase item quantity']")).click();
        String realQuantity = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.saucelabs.mydemoapp.android:id/noTV']")).getText();
        System.out.println("Current Quantity: " + realQuantity);
    }

    @And("user add product to the cart")
    public void userAddProductToTheCart() {
        driver.findElement(By.xpath("//android.widget.Button[@content-desc='Tap to add product to cart']")).click();
    }

    @When("user is on cart page")
    public void userIsOnCartPage() {
        driver.findElement(By.xpath("//android.widget.RelativeLayout[@content-desc='View cart']")).click();
    }

    @Then("validate product name in cart page matches with {string}")
    public void validateProductNameInCartPageMatchesWith(String name) {
        String actualProductName = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.saucelabs.mydemoapp.android:id/titleTV']")).getText();
        System.out.println("Current Product Name: " + actualProductName);
        Assert.assertEquals(actualProductName, name, "Product name does not match");
    }

    @And("validate product colour in cart page mathes with {string}")
    public void validateProductColourInCartPageMathesWith(String colour) {
        String actualColour = driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Colour color']")).getText();
        System.out.println("Current Product Colour: " + actualColour);
        Assert.assertEquals(actualColour, colour, "Colour color does not match");
    }

    @And("validate product quantity in cart page matcher with {string}")
    public void validateProductQuantityInCartPageMatcherWith(String quantity) {
        String actualQuantity = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.saucelabs.mydemoapp.android:id/noTV']")).getText();
        System.out.println("Current Product Quantity: " + actualQuantity);
        Assert.assertEquals(actualQuantity, quantity, "Quantity does not match");
    }


    @Given("user is on login page")
    public void userIsOnLoginPage() {
        driver.findElement(By.xpath("//android.widget.Button[@content-desc='Confirms products for checkout']")).click();
    }

    @When("user login using username {string} and password {string}")
    public void userLoginUsingUsernameAndPassword(String username, String password) {
        driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.saucelabs.mydemoapp.android:id/nameET']")).sendKeys(username);
        driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.saucelabs.mydemoapp.android:id/passwordET']")).sendKeys(password);
    }

    @Then("user is able to login")
    public void userIsAbleToLogin() {
        driver.findElement(By.xpath("//android.widget.LinearLayout[@resource-id='com.saucelabs.mydemoapp.android:id/buttonLL']")).click();
    }

    @Given("user is on enter shipping address page")
    public void userIsOnEnterShippingAddressPage() {
        String currentPage = driver.findElement(By.id("com.saucelabs.mydemoapp.android:id/enterShippingAddressTV")).getText();
        System.out.println(currentPage);
        Assert.assertEquals(currentPage, "Enter a shipping address", "Shipping Address does not match");
    }

    @When("user fill the shipping address detail")
    public void userFillTheShippingAddressDetail() {
        driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.saucelabs.mydemoapp.android:id/fullNameET']")).sendKeys("Automation Testing");
        driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.saucelabs.mydemoapp.android:id/address1ET']")).sendKeys("Automation Address 1");
        driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.saucelabs.mydemoapp.android:id/address2ET']")).sendKeys("Automation Address 2");
        driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.saucelabs.mydemoapp.android:id/cityET']")).sendKeys("Jakarta");
        driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.saucelabs.mydemoapp.android:id/stateET']")).sendKeys("Jakarta Timur");
        driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.saucelabs.mydemoapp.android:id/zipET']")).sendKeys("89750");
        driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.saucelabs.mydemoapp.android:id/countryET']")).sendKeys("Indonesia");
    }

    @Then("user proceed to payment page")
    public void userProceedToPaymentPage() {
        driver.findElement(By.id("com.saucelabs.mydemoapp.android:id/paymentBtn")).click();
    }

    @Given("user is on enter payment method page")
    public void userIsOnEnterPaymentMethodPage() {
        String currentPage = driver.findElement(By.id("com.saucelabs.mydemoapp.android:id/enterPaymentMethodTV")).getText();
        System.out.println(currentPage);
        Assert.assertEquals(currentPage, "Enter a payment method", "Payment Method does not match");
    }

    @When("user fill the payment method detail")
    public void userFillThePaymentMethodDetail() {
        driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.saucelabs.mydemoapp.android:id/nameET']")).sendKeys("Automation Payment");
        driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.saucelabs.mydemoapp.android:id/cardNumberET']")).sendKeys("3258 1256 7568 7891");
        driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.saucelabs.mydemoapp.android:id/expirationDateET']")).sendKeys("03/25");
        driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.saucelabs.mydemoapp.android:id/securityCodeET']")).sendKeys("12345");
    }

    @Then("user proceed to review order page")
    public void userProceedToReviewOrderPage() {
        driver.findElement(By.id("com.saucelabs.mydemoapp.android:id/paymentBtn")).click();
    }

    @Given("user is on review order page")
    public void userIsOnReviewOrderPage() {
        String currentPage = driver.findElement(By.id("com.saucelabs.mydemoapp.android:id/checkoutTitleTV")).getText();
        System.out.println(currentPage);
        Assert.assertEquals(currentPage, "Checkout", "User is not on checkout page");
    }

    @Then("user proceed to place order")
    public void userProceedToPlaceOrder() {
        driver.findElement(By.id("com.saucelabs.mydemoapp.android:id/paymentBtn")).click();
    }

    @And("user complete checkout")
    public void userCompleteCheckout() throws InterruptedException {
        String checkoutResult = driver.findElement(By.id("com.saucelabs.mydemoapp.android:id/completeTV")).getText();
        Assert.assertEquals(checkoutResult, "Checkout Complete", "Checkout failed");
        Thread.sleep(5000);
        driver.quit();
    }

    @When("user is validating order data {string} {string} {string}")
    public void userIsValidatingOrderData(String name, String colour, String quantity) {
        String currentProductName = driver.findElement(By.id("com.saucelabs.mydemoapp.android:id/titleTV")).getText();
//        String currentProductColour = ""; -> unable to find element that contain text Blue
        String currentProductQuantity = driver.findElement(By.id("com.saucelabs.mydemoapp.android:id/itemNumberTV")).getText();

        Assert.assertEquals(currentProductName, name, "Product Name does not match");
//        Assert.assertEquals(currentProductColour, colour, "Product Colour does not match");
        Assert.assertEquals(currentProductQuantity, quantity, "Product Quantity does not match");
    }
}
