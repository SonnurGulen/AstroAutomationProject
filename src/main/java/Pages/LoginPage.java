package Pages;

import Base.BaseLibrary;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Base.Data.*;

public class LoginPage extends BaseLibrary {

    @Step("E-mail alanı doldurulur")
    public LoginPage emailFill ( String email) throws InterruptedException {
    driver.findElement(By.id("input_email")).sendKeys(email);
    return this;
    }

    @Step("Parola alanı doldurulur")
    public LoginPage passwordFill( String password){
    driver.findElement(By.id("password")).sendKeys(password);
    return this;
    }

    @Step("Login Butonuna Tıklanır")
    public  LoginPage loginClick(){
        driver.findElement(By.cssSelector("[value='Login']")).click();
        return this;
    }

    @Step("Kullanıcı bulunamadı mesajı kontrolü yapılır")
    public LoginPage checkEmailErrorMessage() throws InterruptedException {
        String valueOfMessage = driver.findElement(By.className("awdwarn")).getText();
        if (valueOfMessage.contains(noUserMessage))System.out.println("Wrong E-mail ");
    return this;
    };

    @Step("Parola gereklidir mesajı kontrolü yapılır")
    public LoginPage requiredPassword() throws InterruptedException {
        String valueOfMessage = driver.findElement(By.className("awdwarn")).getText();
        Assert.assertEquals(valueOfMessage,requiredFieldMessage);
        return this;
    };

    @Step("Yanlış parola mesajı kontrolü yapılır")
    public LoginPage checkPasswordErrorMessage() throws InterruptedException {
        String valueOfMessage = driver.findElement(By.className("awdwarn")).getText();
        Assert.assertEquals(valueOfMessage,wrongPasswordMessage);
        return this;
    };

    @Step("Yanlış e-mail formatı mesajı kontrolü yapılır")
    public LoginPage wrongFormatEmail() throws InterruptedException {
        String valueOfMessage = driver.findElement(By.className("awdwarn")).getText();
        Assert.assertEquals(valueOfMessage,wrongEmailFormatMessage);
        return this;
    };



}
