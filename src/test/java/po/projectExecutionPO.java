package po;

import factory.driverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class projectExecutionPO extends driverFactory {
    public projectExecutionPO(){
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(css = "#collapseFilter")
    public WebElement btnFiltro;

    @FindBy(css = "#name")
    public WebElement txtNome;

    @FindBy(xpath = "//input[@value='Filtrar']")
    public WebElement btnFiltrar;

    @FindBy(xpath = "//div[@role='tablist']/div")
    public WebElement btnCasoDeTeste;


    @FindBy(xpath = "//div[@id='testCaseList']//button[contains(text(),'Re-Executar')]")
    public WebElement btnExecutarCT;

    @FindBy(xpath = "//div[@id='testCaseList']//button[contains(text(),'Gerar log')]")
    public WebElement btnGeraLogCT;

    @FindBy(xpath = "//div[@id='testCaseList']//span[contains(@id,'testCaseResult')]")
    public WebElement ResultadoCT;

    @FindBy(xpath = "//div[@id='testCaseList']//div[contains(@class,'showValidation cursorPointer')]")
    public WebElement btnLupa;

    @FindBy(xpath = "//*[@id=\"tree\"]//td[@id='ygtvt3']")
    public WebElement btnPrimeiroExpand;

    @FindBy(xpath = "//*[@id=\"tree\"]//td[@id='ygtvt13']")
    public WebElement btnSegundoExpand;


    @FindAll({
            @FindBy(xpath = "//*[@id=\"tree\"]//div[@id='ygtvc13']//div[@class='ygtvitem']")
    })
    public List<WebElement> linhasTransacao;

}
