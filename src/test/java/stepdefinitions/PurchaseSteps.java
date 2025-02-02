package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PurchaseSteps {
    WebDriver driver = LoginSteps.driver;
    ProductsPage productsPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    ConfirmationPage confirmationPage;

    @When("adiciono os produtos {string}, {string}, {string}, {string} ao carrinho")
    public void addProducts(String p1, String p2, String p3, String p4) {
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        confirmationPage = new ConfirmationPage(driver);

        // ✅ Validação: Garantir que estamos na página de produtos
        assertTrue(productsPage.isOnProductsPage(), "ERRO: Não estamos na página de produtos!");

        productsPage.addProductToCart(p1);
        productsPage.addProductToCart(p2);
        productsPage.addProductToCart(p3);
        productsPage.addProductToCart(p4);
        productsPage.goToCart();

        // ✅ Validação: Garantir que estamos na página do carrinho
        assertTrue(cartPage.isOnCartPage(), "ERRO: Não estamos na página do carrinho!");

        cartPage.clickCheckout();
    }

    @And("realizo o checkout com os dados {string}, {string} e {string}")
    public void checkout(String nome, String sobrenome, String cep) {
        // ✅ Validação: Garantir que estamos na página de checkout
        assertTrue(checkoutPage.isOnCheckoutPage(), "ERRO: Não estamos na página de checkout!");

        checkoutPage.enterFirstName(nome);
        checkoutPage.enterLastName(sobrenome);
        checkoutPage.enterZipCode(cep);
        checkoutPage.clickContinue();
        checkoutPage.clickFinish();
    }

    @Then("a compra deve ser finalizada com sucesso")
    public void verifyPurchase() {
        // ✅ Validação: Garantir que o pedido foi concluído
        assertTrue(confirmationPage.isOnOrderConfirmationPage(), "ERRO: O pedido não foi concluído!");

        driver.quit();
    }
}
