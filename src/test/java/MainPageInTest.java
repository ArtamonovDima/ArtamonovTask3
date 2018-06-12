import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.$;

public class MainPageInTest {

    @FindBy(how = How.NAME, using = "firstname")
    private SelenideElement firstname;
    @FindBy(how = How.NAME, using = "lastname")
    private SelenideElement lastname;
    @FindBy(how = How.NAME, using = "reg_email__")
    private SelenideElement email;
    @FindBy(how = How.NAME, using = "reg_email_confirmation__")
    private SelenideElement emailConfirm;
    @FindBy(how = How.NAME, using = "reg_passwd__")
    private SelenideElement password;
    @FindBy(how = How.CSS, using = "#day>option[value='8']")
    private SelenideElement myday;
    @FindBy(how = How.CSS, using = "#month>option[value='9']")
    private SelenideElement mymonth;
    @FindBy(how = How.CSS, using = "#year>option[value='1989']")
    private SelenideElement myyear;
    @FindBy(how = How.XPATH, using = "//input[@name='sex' and @value='2']")
    private SelenideElement mysex;
    @FindBy(how = How.NAME, using = "websubmit")
    private SelenideElement submit;

    @FindBy(how = How.CSS, using = "#email")
    private SelenideElement logEmail;
    @FindBy(how = How.CSS, using = "#pass")
    private SelenideElement logPass;
    @FindBy(how = How.XPATH, using = "//input[@value='Вход']")
    private SelenideElement loginButton;

    @Step("register user")
    public MainPageInTest registration(String fname, String sname, String mail, String pass){
       firstname.should(Condition.exist).setValue(fname);
       lastname.setValue(sname);
       email.setValue(mail);
       emailConfirm.setValue(mail);
       password.setValue(pass);
       myday.shouldBe(Condition.visible).click();
       mymonth.click();
       myyear.waitUntil(Condition.visible, 10000).click();
       mysex.click();
       submit.shouldHave(Condition.name("websubmit")).click();
       return this;
    }
    @Step("login user")
    public MainPageInTest login(String email, String pass){
        logEmail.setValue(email);
        logPass.setValue(pass);
        loginButton.click();
        return  this;
    }

    public SelenideElement forAssert(){
        SelenideElement sel = $(By.xpath("//div[@class ='_1yqt' and text()='Загрузите фото себя']"));
        return sel;
    }
}
