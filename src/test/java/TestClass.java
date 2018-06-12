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


}
