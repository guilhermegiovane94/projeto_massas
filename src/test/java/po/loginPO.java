package po;


import factory.driverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPO extends driverFactory {

    public loginPO(){
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(css = "#email")
    public WebElement txtUser;

    @FindBy(css = "#password")
    public WebElement txtPassword;

    @FindBy(css = "#loginButton")
    public WebElement btnLogin;

}
