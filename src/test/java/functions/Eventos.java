package functions;

import factory.driverFactory;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

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

        //Verifica se o elemento existe, é exibido e está habilitado, caso contrário joga um erro e informa qual elemento o erro ocorreu
        try {
            if (!elemento.isDisplayed()) {
             
                Assert.fail("O campo não foi exibido");
            }
            if (!elemento.isEnabled()) {
             
                Assert.fail("O campo não está habilitado");
            }

            //Se passada todas as validações, insere os dados no campo
            //WebActions.setText(getBrowser(), elemento, texto, 5);
            elemento.sendKeys(texto);
            Thread.sleep(1000);

        } catch (NoSuchElementException | InterruptedException e) {
            e.printStackTrace();
         
            Assert.fail("O campo não foi encontrado");
        }
    }

    //Método para inserir texto nos campos Input no site
    public static void insereTextoComTab(WebElement elemento, String texto, String lugar) {

        //Verifica se o elemento existe, é exibido e está habilitado, caso contrário joga um erro e informa qual elemento o erro ocorreu
        try {
            if (!elemento.isDisplayed()) {
             
                Assert.fail("O campo '" + lugar + "' não foi exibido");
            }
            if (!elemento.isEnabled()) {
             
                Assert.fail("O campo '" + lugar + "' não está habilitado");
            }

            //Se passada todas as validações, insere os dados no campo
            elemento.sendKeys(texto);
          //  elemento.sendKeys(Key.TAB);

        } catch (NoSuchElementException  e) {
            e.printStackTrace();
         
            Assert.fail("O campo '" + lugar + "' não foi encontrado");
        }
    }

    //Método para selecionar determinada opção nos Selects (menu dropdown de múltiplas opções) no site. Sempre escolhe de acordo com o texto das opções
    public static void escolheSelect(WebElement elemento, String opcao, String lugar) {

        try {
            //Verifica se o texto enviado é nulo ou vazio
            if (opcao != null || !opcao.equals("")) {
                //Verifica se o elemento existe, é exibido e está habilitado, caso contrário joga um erro e informa qual elemento o erro ocorreu
                if (!elemento.isDisplayed()) {
                 
                    Assert.fail("O campo '" + lugar + "' não foi exibido");
                }
                if (!elemento.isEnabled()) {
                 
                    Assert.fail("O campo '" + lugar + "' não está habilitado");
                }

                Select select = new Select(elemento);

                //Verifica se a opção existe
                List<WebElement> listaOpcoes = select.getOptions();
                boolean encontrado = false;
                for (WebElement item : listaOpcoes) {
                    if (opcao.trim().equals(item.getText().trim())) {
                        encontrado = true;
                    }
                }

                //Caso não encontrado, lança um erro e imprime as opções disponíveis no Reports
                if (!encontrado) {
                
                    for (WebElement item : listaOpcoes) {
                     
                    }
                 
                    Assert.fail("A opção '" + opcao + "' não existe no menu '" + lugar + "'");
                }

                //Se passada todas as validações, seleciona o elemento no Select
                select.selectByVisibleText(opcao);
            }
        } catch (NoSuchElementException n){
         
            n.printStackTrace();
            Assert.fail("Campo " + lugar + " não encontrado.");
        }
        catch(Exception e)
        {
            e.printStackTrace();
         
            Assert.fail("Erro não mapeado acionar automação!");
        }
    }

    //Método para clicar num elemento no site
    public static void clicaElemento(WebElement elemento)  {

        //Verifica se o elemento existe, é exibido e está habilitado, caso contrário joga um erro e informa qual elemento o erro ocorreu
        try{

            if (!elemento.isDisplayed()){
                Assert.fail("O botão  não foi exibido");
            }

            if (!elemento.isEnabled()){
                Assert.fail("O botão  não está habilitado");
            }

            //Se passada todas as validações, clica no elemento
            elemento.click();
            Thread.sleep(1000);

        } catch (NoSuchElementException | InterruptedException e){
            e.printStackTrace();
         
            Assert.fail("O elemento  não foi encontrado");
        }
    }

    //Tira print com highlight antes de clicar em elemento
    public static void clicaElemento(WebElement elemento, String nomeBotao, boolean highlightPrint)  {

        //Verifica se o elemento existe, é exibido e está habilitado, caso contrário joga um erro e informa qual elemento o erro ocorreu
        try{

            if (!elemento.isDisplayed()){
                Assert.fail("O botão '" + nomeBotao + "' não foi exibido");
            }

            if (!elemento.isEnabled()){
                Assert.fail("O botão '" + nomeBotao + "' não está habilitado");
            }

            //Se passada todas as validações, clica no elemento
           
            elemento.click();

        } catch (NoSuchElementException e){
            e.printStackTrace();
         
            Assert.fail("O elemento '" + nomeBotao + "' não foi encontrado");
        }
    }
}
