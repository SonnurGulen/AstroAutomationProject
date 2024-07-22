package Pages;

import Base.BaseLibrary;
import io.qameta.allure.Step;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Objects;

public class ShopPage extends BaseLibrary {

    @Step("Mağazaya giriş yapılır.")
    public ShopPage goToShop ( String email) throws InterruptedException {
        driver.findElements(By.className("nshort")).get(2).click();
        String checkProduct = driver.findElement(By.xpath("<h1 class=\"display-2\">Yearly Horoscope Analysis</h1>")).getText();
        Assert.assertEquals("Yearly Horoscope Analysis",checkProduct);
        return this;
    }

    @Step("Sepete ürün eklenir")
    public ShopPage addToCart() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"topright\"]/div/div[1]/div[2]/a")).click();
        sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"mainsubmit\"]")).click();
        if (Objects.equals(driver.findElement(By.xpath("/html/body/header/div[2]/div/div/div/div[2]/div/span[2]")).getText(), "1")){
            System.out.println("Sepete ürün eklendi");
        };

            return this;
    }

    @Step("Koşulları onaylar")
    public ShopPage termsAccept() throws InterruptedException {
        WebElement termsAndCond = driver.findElement(By.className("agbcheckbox"));
        termsAndCond.click();
        Assert.assertTrue(termsAndCond.isSelected());
        return this;
    }

    @Step("Sepet onaylanır")
    public ShopPage checkoutClick() throws InterruptedException {
        driver.findElement(By.className("btn-success")).click();
        WebElement element = driver.findElement(By.className("myaicon"));
        element.isDisplayed();
        return this;
    }


}
