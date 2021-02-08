package po;

import factory.driverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class indexPO extends driverFactory {
    public indexPO(){
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(css = "#menu\\.Projects")
    public WebElement drpProjeto;

    @FindBy(css = "#menu\\.ProjectList")
    public WebElement btnVisaoGeral;

    @FindBy(css = "#crfo-nav > ul:nth-child(2) > li > a")
    public WebElement btnUsuario;
}
