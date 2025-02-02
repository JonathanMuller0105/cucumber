package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationPage {
    private WebDriver driver;

    public ConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isOrderComplete() {
        return driver.findElement(By.className("complete-header")).isDisplayed();
    }

    public boolean isOnOrderConfirmationPage() {
        return driver.findElement(By.className("complete-header")).getText().equals("Thank you for your order!");
    }
}
