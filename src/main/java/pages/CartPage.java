package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCheckout() {
        driver.findElement(By.id("checkout")).click();
    }

    
    public boolean isOnCartPage() {
        return driver.findElement(By.className("title")).getText().equals("Your Cart");
    }
}
