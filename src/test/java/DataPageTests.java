import Base.BaseTest;
import Pages.DataEnterPage;
import Pages.LoginPage;
import Pages.MainPage;
import org.testng.annotations.Test;

public class DataPageTests extends BaseTest {
    LoginPage loginPage = new LoginPage();
    DataEnterPage dataEnterPage = new DataEnterPage();

    @Test(description = "Yeni data oluşturur")
    public void enterNewData () throws InterruptedException{
        loginPage
                .emailFill( email)
                .passwordFill( password)
                .loginClick();
        sleep(3000);
        dataEnterPage.newDataCreate()
                     .enterDataInfo()
                     .clickSendData();
    }

    @Test(description = "Son oluşturulan datayı siler")
    public void deleteData () throws InterruptedException{
        loginPage
                .emailFill( email)
                .passwordFill( password)
                .loginClick();
        sleep(3000);
        dataEnterPage.deleteData();

    }

}
