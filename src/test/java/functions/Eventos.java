package functions;

import factory.driverFactory;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Eventos extends driverFactory {

    //Método para rolar a página para determinado elemento
    public static void scrollToElement(WebElement element) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("arguments[0].scrollIntoView();", element);
        } catch (Exception e) {
         
            Assert.fail("Elemento não encontrado para scroll");
        }
    }

    //Método para inserir texto nos campos Input no site
    public static void insereTexto(WebElement elemento, String texto) {

        try {
            if (!elemento.isDisplayed() && !elemento.isEnabled()) {
                isElementLoaded(elemento);
            }
            elemento.sendKeys(texto);
            Thread.sleep(450);

        } catch (NoSuchElementException | InterruptedException e) {
            e.printStackTrace();
         
            Assert.fail("O campo não foi encontrado");
        }
    }

    public static void escolheSelect(WebElement elemento, String opcao) {
        try {

            if (opcao != null || !opcao.equals("")) {
                if (!elemento.isDisplayed() && !elemento.isEnabled()) {
                    isElementLoaded(elemento);
                }
                Select select = new Select(elemento);
                List<WebElement> listaOpcoes = select.getOptions();
                boolean encontrado = false;
                for (WebElement item : listaOpcoes) {
                    if (opcao.trim().equals(item.getText().trim())) {
                        encontrado = true;
                    }
                }
                select.selectByVisibleText(opcao);
            }
        } catch (Exception e){
         
            e.printStackTrace();
            Assert.fail("Campo não encontrado.");
        }
    }

    public static void clicaElemento(WebElement elemento)  {

        //Verifica se o elemento existe, é exibido e está habilitado, caso contrário joga um erro e informa qual elemento o erro ocorreu
        try{
            if (!elemento.isDisplayed() && !elemento.isEnabled()) {
                isElementLoaded(elemento);
            }

            elemento.click();
            Thread.sleep(450);

        } catch (NoSuchElementException | InterruptedException e){
            e.printStackTrace();
            Assert.fail("O elemento  não foi encontrado");
        }
    }

    public static void escolheList(WebElement elemento, String opcao) {
        try {

            if (opcao != null || !opcao.equals("")) {
                if (!elemento.isDisplayed() && !elemento.isEnabled()) {
                    isElementLoaded(elemento);
                }

                //Verifica se a opção existe
                List<WebElement> listaOpcoes = elemento.findElements(By.tagName("a"));
                WebElement item = null;
                for (int i = 0; i< listaOpcoes.size(); i++) {
                    item = listaOpcoes.get(i);
                    if (opcao.trim().equals(item.getText().trim())) {
                        break;
                    }
                }
                clicaElemento(item);

            }
        } catch (NoSuchElementException n){

            n.printStackTrace();
            Assert.fail("Campo não encontrado.");
        }
        catch(Exception e)
        {
            e.printStackTrace();

            Assert.fail("Erro não mapeado acionar automação!");
        }
    }

    public static void escolheTable(WebElement elemento, String opcao) {

        try {

            if (opcao != null || !opcao.equals("")) {
                if (!elemento.isDisplayed() && !elemento.isEnabled()) {
                    isElementLoaded(elemento);
                }
                List<WebElement> listaOpcoes = elemento.findElements(By.tagName("tr"));
                WebElement item = null;
                for (int i = 0; i< listaOpcoes.size(); i++) {
                    item = listaOpcoes.get(i);
                    if (item.getText().trim().contains(opcao.trim())) {
                        break;
                    }
                }
                clicaElemento(item);
            }
        } catch (NoSuchElementException n){

            n.printStackTrace();
            Assert.fail("Campo não encontrado.");
        }
        catch(Exception e)
        {
            e.printStackTrace();

            Assert.fail("Erro não mapeado acionar automação!");
        }
    }


    public static WebElement isElementLoaded(WebElement elementToBeLoaded) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 20);
        WebElement element = wait.until(ExpectedConditions.visibilityOf(elementToBeLoaded));
        return element;
    }

    public static void waitForLoad() {
        new WebDriverWait(getDriver(), 20).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
    }

    public static String valorBit(String linha)
    {
        //pega o valor do bit apos :
        int length = linha.length();
        int index = linha.indexOf(':');
        String valorBit = linha.substring(index + 1, length);

        return valorBit.trim();
    }

    public static String tipoBit(String linha)
    {
        int length = linha.length();
        int index = linha.indexOf(':');
        if (index > -1)
        {
            String tipoBit = linha.substring(0,index);

            //verifica se no dicionario de bits esse bit encontrado existe
            for (String bit : VariaveisGlobais.bits)
            {
                if (bit.equalsIgnoreCase(tipoBit.trim())    )
                {
                    // return montaBit(tipoBit.Trim());

                    return bit;
                }
            }
        }

        return "";
    }

    public static String getValorBit(List<WebElement> linhas, String bit){
        String retorno = "";
        for(WebElement linha : linhas){
            if(tipoBit(linha.getText()).equalsIgnoreCase(bit)){
                retorno = valorBit(linha.getText());
                break;
            }
        }
        return retorno;
    }

    public static String getLinhaBit(List<WebElement> linhas, String bit){
        String retorno = "";
        for(WebElement linha : linhas){
            if(tipoBit(linha.getText()).equalsIgnoreCase(bit)){
                retorno = linha.getText();
                break;
            }
        }
        return retorno;
    }

    public static String validoResposta(List<WebElement> linhas){
        String bit = "039";
        String temp = getValorBit(linhas,bit);
        int index = temp.indexOf("=");
        String retorno = temp.substring(index + 1, index + 7);
        return retorno.replace("\"","").trim();
    }

}
