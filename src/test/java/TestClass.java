import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;

public class TestClass extends BaseTest{

    @Test
    public void test1(){

        open("/");
        mainT.registration("Dima", "Artamonov", "artbiba@ukr.net", "asdfg01g3")
                .login("artbiba@ukr.net", "asdfg01g3");


    }



}
