package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {
    private WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addProductToCart(String productName) {
        String productXpath = "//div[text()='" + productName + "']/ancestor::div[@class='inventory_item']//button";
        driver.findElement(By.xpath(productXpath)).click();
    }

    public void goToCart() {
        driver.findElement(By.className("shopping_cart_link")).click();
    }

    public boolean isOnProductsPage() {
        return driver.findElement(By.className("title")).getText().equals("Products");
    }
}
