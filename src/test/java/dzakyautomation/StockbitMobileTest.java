package dzakyautomation;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class StockbitMobileTest extends BaseTest {
    public void BuyProductTest() throws InterruptedException {
        System.out.println("Appium Basics");

        Thread.sleep(10000);
        // Actual Automation
        driver.findElement(By.xpath("//androidx.recyclerview.widget.RecyclerView[@content-desc='Displays all products of catalog']/android.view.ViewGroup/android.widget.ImageView[@content-desc='Sauce Lab Back Packs']")).click();
        driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='Blue color']")).click();

        driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='Increase item quantity']")).click();
        String quantity = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.saucelabs.mydemoapp.android:id/noTV']")).getText();
        System.out.println("Current Quantity: " + quantity);

        driver.findElement(By.xpath("//android.widget.Button[@content-desc='Tap to add product to cart']")).click();
        driver.findElement(By.xpath("//android.widget.RelativeLayout[@content-desc='View cart']")).click();

        driver.findElement(By.xpath("//android.widget.Button[@content-desc='Confirms products for checkout']")).click();

        //Input username password
        driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.saucelabs.mydemoapp.android:id/nameET']")).sendKeys("automationtesting");
        driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.saucelabs.mydemoapp.android:id/passwordET']")).sendKeys("Password123");
        driver.findElement(By.xpath("//android.widget.LinearLayout[@resource-id='com.saucelabs.mydemoapp.android:id/buttonLL']")).click();

        //Input Shipping Address
        driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.saucelabs.mydemoapp.android:id/fullNameET']")).sendKeys("Automation Testing");
        driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.saucelabs.mydemoapp.android:id/address1ET']")).sendKeys("Automation Address 1");
        driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.saucelabs.mydemoapp.android:id/address2ET']")).sendKeys("Automation Address 2");
        driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.saucelabs.mydemoapp.android:id/cityET']")).sendKeys("Jakarta");
        driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.saucelabs.mydemoapp.android:id/stateET']")).sendKeys("Jakarta Timur");
        driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.saucelabs.mydemoapp.android:id/zipET']")).sendKeys("89750");
        driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.saucelabs.mydemoapp.android:id/countryET']")).sendKeys("Indonesia");
        driver.findElement(By.id("com.saucelabs.mydemoapp.android:id/paymentBtn")).click();

        //Input Payment Method
        driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.saucelabs.mydemoapp.android:id/nameET']")).sendKeys("Automation Payment");
        driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.saucelabs.mydemoapp.android:id/cardNumberET']")).sendKeys("3258 1256 7568 7891");
        driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.saucelabs.mydemoapp.android:id/expirationDateET']")).sendKeys("03/25");
        driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.saucelabs.mydemoapp.android:id/securityCodeET']")).sendKeys("12345");

        driver.findElement(By.id("com.saucelabs.mydemoapp.android:id/paymentBtn")).click();

        //Review Order
        driver.findElement(By.id("com.saucelabs.mydemoapp.android:id/paymentBtn")).click();

        Thread.sleep(5000);
        tearDown();
    }
}
