package Pages;

import Base.BaseLibrary;
import Base.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class DataEnterPage  extends BaseLibrary {
    LoginPage loginPage = new LoginPage();
    @Step("Başarılı data oluşturma sayfasına giriş")
    public DataEnterPage newDataCreate(){
        driver.findElement(By.className("newdata")).click();
        return this;
    };

    @Step("Başarılı data oluşturma kontrolü")
    public DataEnterPage enterDataInfo(){
        driver.findElement(By.id("sfnm")).sendKeys(dataName);
        driver.findElement(By.id("sday")).sendKeys(dataDay);
        driver.findElement(By.id("ssxf")).click();

        WebElement dropdownElementMonth = driver.findElement(By.id("imon"));
        Select dropdownMon = new Select(dropdownElementMonth);
        dropdownMon.selectByValue("6");

        driver.findElement(By.id("syar")).sendKeys(dataYear);

        WebElement dropdownElementYear  = driver.findElement(By.id("ihou"));
        Select dropdownYear = new Select(dropdownElementYear);
        dropdownYear.selectByValue("5");

        driver.findElement(By.id("scit")).sendKeys(dataCity);

        return this;
    };

    @Step("Başarılı data gönderme")
    public DataEnterPage clickSendData() throws InterruptedException {
        driver.findElement(By.className("adebutton")).click();
        sleep(2000);
       List<WebElement > dataEntiries = driver.findElements(By.className("myalink"));
       Assert.assertTrue(dataEntiries.get(dataEntiries.size()-1).getText().contains(dataName));
//        List<WebElement> elements = driver.findElements(By.className("myalink"));
//        elements.stream()
//                .forEach(element -> {
//            String elementText = element.getText();
//            Assert.assertTrue(elementText.contains(dataName));
//        });

        return this;
    };

    @Step("Başarılı data silme")
    public DataEnterPage deleteData(){
        List<WebElement> inputElements = driver.findElements(By.className("myadel"));
        inputElements.get(inputElements.size()-1).click();
        driver.findElement(By.className("awdsublink")).click();
        loginPage.passwordFill(password);
        driver.findElement(By.className("formbtn")).click();
        return this;
    };

}
