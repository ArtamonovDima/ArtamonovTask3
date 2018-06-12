import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;

public class TestClass extends BaseTest{

    @Test
    public void test(){

        long id = Thread.currentThread().getId();
        System.out.println("Simple test-method One. Thread id is: " + id);

        open("https://www.facebook.com/");
        mainT.registration("Dima", "Artamonov", "artbiba@ukr.net", "asdfg01g3")
                .login("artbiba@ukr.net", "asdfg01g3");


    }


}
