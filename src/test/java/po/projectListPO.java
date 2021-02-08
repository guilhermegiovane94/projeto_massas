package po;

import factory.driverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class projectListPO extends driverFactory {
    public projectListPO(){
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(css = "body > div.container > div:nth-child(6) > div.col-md-2 > div > a")
    public WebElement btnAmbiente;

    @FindBy(css = "#environmentList")
    public WebElement listAmbientes;

    @FindBy(css = "body > div.container > div:nth-child(7) > div > div > div > div.panel-heading")
    public WebElement btnFiltro;

    @FindBy(css = "#name")
    public WebElement txtNome;

    @FindBy(css = "#ProjectListFilterBean > div:nth-child(3) > div > div > div:nth-child(2) > input")
    public WebElement btnEnviar;

    @FindBy(css = "body > div.container > div.panel.panel-default.panel-danger > table > tbody")
    public WebElement btnProjeto;

    @FindBy(xpath = "//button[text()='Abrir']")
    public WebElement btnCiclo;


}
