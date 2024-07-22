package Pages;

import Base.BaseLibrary;
import org.openqa.selenium.By;

public class MainPage extends BaseLibrary {
    public MainPage goToShop() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/header/div[2]/nav/div[2]/div[1]/ul/li[3]/a")).click();
        sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"navTab2\"]/div[2]/div/div[1]/ul[2]/li[1]/a")).click();
        return this;
    }
}
