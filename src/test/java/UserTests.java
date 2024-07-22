import Base.BaseLibrary;
import Base.BaseTest;
import Pages.Homepage;
import Pages.LoginPage;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

import javax.print.attribute.standard.Severity;

public class UserTests extends BaseTest {
        LoginPage loginPage = new LoginPage();
        Homepage homepage = new Homepage();

    @Test(description = "Başarılı kullanıcı kontrolü sağlandı")
    public void succesfulllLogin () throws InterruptedException{
        loginPage
                .emailFill( email)
                .passwordFill( password)
                .loginClick();
    }

    @Test(description = "Kayıtlı olmayan e-mail adresi ile giriş")
    public void notValidEmail() throws InterruptedException{
        loginPage
                .emailFill("add@fssdsa.com")
                .passwordFill( password)
                .loginClick();

        sleep(3000);
        loginPage.checkEmailErrorMessage();
    }

    @Test(description = "Hatalı paralo ile giriş")
    public void notValidPassword() throws InterruptedException{
        loginPage
                .emailFill(email)
                .passwordFill( "adsda")
                .loginClick();

        sleep(3000);
        loginPage.checkPasswordErrorMessage();
    }

    @Test(description = "Boş parola alanı ile giriş ")
    public void requiredPassword() throws InterruptedException{
        loginPage
                .emailFill(email)
                .passwordFill("")
                .loginClick();

        sleep(3000);
        loginPage.requiredPassword();
    }

    @Test(description = "Geçerli olmayan formatta e-mail adresi ile giriş")
    public void wronFormatEmail() throws InterruptedException{
        loginPage
                .emailFill("aaaaaaaaaaa@qqqq")
                .passwordFill(password)
                .loginClick();

        sleep(3000);
        loginPage.wrongFormatEmail();
    }

    @Test(description = "Başarılı kullanıcı çıkışı kontrolü sağlandı")
    public void succesfulllLogout () throws InterruptedException{
        loginPage
                .emailFill( email)
                .passwordFill( password)
                .loginClick();
        homepage.accountLogout();
    }
}
