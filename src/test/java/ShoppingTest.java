import Base.BaseTest;
import Pages.Homepage;
import Pages.LoginPage;
import Pages.MainPage;
import Pages.ShopPage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ShoppingTest extends BaseTest {
    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage();
    ShopPage shopPage = new ShopPage();

    @Test(description = "Mağaza sayfasına gider")
    public void goToShopping () throws InterruptedException{
        loginPage
                .emailFill( email)
                .passwordFill( password)
                .loginClick();
        sleep(3000);
        mainPage.goToShop();
    }

    @Test(description = "Mağazadan sepete ürün eklenir")
    public void addItemToCart () throws InterruptedException{
        loginPage
                .emailFill( email)
                .passwordFill( password)
                .loginClick();
        sleep(3000);
        mainPage.goToShop();
        shopPage.addToCart();
    }

    @Test(description = "Sepeti onaylama işlemi yapılır")
    public void checkoutCart() throws InterruptedException{
        loginPage
                .emailFill( email)
                .passwordFill( password)
                .loginClick();
        sleep(3000);
        mainPage.goToShop();
        shopPage.addToCart()
                .termsAccept()
                .checkoutClick();

    }
}
