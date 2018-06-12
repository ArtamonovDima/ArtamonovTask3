import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPageInTest {

    @FindBy(how = How.NAME, using = "firstname")
    private SelenideElement firstname;
    @FindBy(how = How.NAME, using = "lastname")
    private SelenideElement lastname;
    @FindBy(how = How.NAME, using = "reg_email__")
    private SelenideElement email;
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

    public MainPageInTest registration(String fname, String sname, String mail, String pass){
       firstname.setValue(fname);
       lastname.setValue(sname);
       email.setValue(mail);
       password.setValue(pass);
       myday.click();
       mymonth.click();
       myyear.click();
       mysex.click();
       submit.click();
       return this;
    }

    public MainPageInTest login(String email, String pass){
        logEmail.setValue(email);
        logPass.setValue(pass);
        loginButton.click();
        return  this;
    }
}
