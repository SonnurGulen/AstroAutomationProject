package Pages;

import Base.BaseLibrary;
import Base.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Homepage extends BaseLibrary {

    @Step("Başarılı giriş kontrolü")
    public  Homepage accountCheck ( WebDriver driver){
        String helloMessage = driver.findElement(By.xpath("//*[@id=\"colmain_rbm\"]/h5")).getText();
        Assert.assertEquals(helloMessage,"Hello Sonnur Gln");
        return this;
    };

    @Step("Başarılı çıkış kontrolü")
    public Homepage accountLogout(){
        driver.findElement(By.xpath("//*[@id=\"colmain_rbm\"]/div[1]/div/div[2]/ul/li[3]/a")).click();
        String loginText = driver.findElement(By.xpath("//*[@id=\"awdlogin\"]/form/div/h5")).getText();
        Assert.assertEquals(loginText,"Log in to your user profile here:");
        return this;
    };
}
