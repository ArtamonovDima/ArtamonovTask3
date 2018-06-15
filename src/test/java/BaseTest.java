
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.*;

public class BaseTest {

    MainPageInTest mainT;

    @Parameters("browser")
    @BeforeClass
    public void setup(@Optional("chrome") String browser){

        if(browser.equals("chrome")){
            Configuration.browser = "chrome";
        } else if(browser.equals("firefox")){
            Configuration.browser = "firefox";
        }
        mainT = Selenide.page(MainPageInTest.class);
    }

    @AfterClass
    public void close(){
    Selenide.close();
    }

}
