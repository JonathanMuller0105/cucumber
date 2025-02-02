package stepdefinitions;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginSteps {
    public static WebDriver driver;
    LoginPage loginPage;

    @Given("que estou logado no site SauceDemo")
    public void queEstouLogadoNoSiteSauceDemo() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");

        loginPage = new LoginPage(driver);

        // ✅ Validação: Garantir que estamos na página de login
        assertTrue(loginPage.isOnLoginPage(), "ERRO: Não estamos na página de login!");

        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
    }
}
