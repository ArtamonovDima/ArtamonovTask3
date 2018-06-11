import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    MainPageInTest mainT;

    @BeforeClass
    public void setup(){
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://www.facebook.com/";
        mainT = Selenide.page(MainPageInTest.class);
    }
}
