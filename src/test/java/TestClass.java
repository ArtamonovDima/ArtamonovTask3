import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;

@Epic("Regression test")
@Feature("Registration test")
public class TestClass extends BaseTest{

    @Test
    @Description("registration and login test")
    @Story("valid data")
    public void test(){

        long id = Thread.currentThread().getId();
        System.out.println("Simple test-method. Thread id is: " + id);

        open("https://www.facebook.com/");
        mainT.registration("Dima", "Artamonov", "artbiba@ukr.net", "asdfg01g3")
                .login("artbiba@ukr.net", "asdfg01g3");
        Assert.assertEquals("Загрузите фото себя", mainT.forAssert().getText() );

    }

    @Test
    public void negativeTestWithoutName(){
        open("https://www.facebook.com/");
        mainT.registrationWithoutName("", "Artamonov", "artbiba@ukr.net", "asdfg01g3");
        Assert.assertEquals("Как вас зовут?", mainT.getWithoutNameMessege().getText() );
    }

    @Test
    public void negativeTestWithoutSex(){
        open("https://www.facebook.com/");
        mainT.registrationWithoutSex("Dima", "Artamonov", "artbiba@ukr.net", "asdfg01g3");
        Assert.assertEquals("Укажите пол. Позже вы сможете изменить, кто видит эту информацию.", mainT.getWithoutSexMessege().getText() );
    }

    @Test
    public void negativeTestWithoutSecondMail(){
        open("https://www.facebook.com/");
        mainT.registrationWithoutSecondMail("Dima", "Artamonov", "artbiba@ukr.net", "asdfg01g3");
        Assert.assertEquals("Введите повторно ваш эл. адрес.", mainT.getWithoutSecondMailMessege().getText() );
    }

    @Test
    public void negativeTestLoginWrongMail(){
        open("https://www.facebook.com/");
        mainT.loginWrongMail("я@ukr.net", "asdfg01g3");
        Assert.assertEquals("Эл. адрес или номер телефона, который вы указали, не соответствует ни одному аккаунту. Зарегистрируйте аккаунт.", mainT.getWrongMailMessege().getText() );
    }

    @Test
    public void negativeTestLoginWithoutPassword(){
        open("https://www.facebook.com/");
        mainT.loginWithoutPassword("artbiba@ukr.net", "");
        Assert.assertEquals("Вы ввели неверный пароль. Забыли пароль?", mainT.getWithoutPasswordMessege().getText() );
    }

}
