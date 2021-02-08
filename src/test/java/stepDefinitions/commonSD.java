package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import functions.DotEnvHandler;
import functions.World;
import functions.pageHandler;

public class commonSD {
    World world = new World();

    @Dado("^usuário está na tela \"([^\"]*)\"$")
    public void usuárioEstáNaTela(String tela) throws Throwable {
        world.setPageAction(pageHandler.pegaTela(tela));
        world.getPageAction().acessar();
    }

    @Quando("^insiro no campo \"([^\"]*)\" \"([^\"]*)\"$")
    public void insiroNoCampo(String campo, String valor) throws Throwable {
        if(campo.equalsIgnoreCase("user") && valor.equalsIgnoreCase("") ){
            world.getPageAction().inserirDados(campo, DotEnvHandler.getUsuario());
        }else if(campo.equalsIgnoreCase("password") && valor.equalsIgnoreCase("")){
            world.getPageAction().inserirDados(campo, DotEnvHandler.getPassword());
        }
        world.getPageAction().inserirDados(campo, valor);
    }

    @Entao("^clico no botão \"([^\"]*)\"$")
    public void clicoNoBotão(String botao) throws Throwable {
        world.getPageAction().clicarBotao(botao);
    }

    @Quando("^seleciono lista \"([^\"]*)\" \"([^\"]*)\"$")
    public void selecionoLista(String campo, String valor) throws Throwable {
        world.getPageAction().SelectList(campo,valor);
    }


    @Entao("^seleciono campo \"([^\"]*)\" na tabela com valor \"([^\"]*)\"$")
    public void selecionoCampoNaTabelaComValor(String campo, String valor) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        world.getPageAction().SelectTable(campo, valor);
    }

    @E("^valido o campo \"([^\"]*)\"$")
    public void validoOCampo(String campo) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        world.getPageAction().validar(campo);
    }

    @E("^valido a url \"([^\"]*)\"$")
    public void validoAUrl(String url) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        world.getPageAction().validar(url);
    }

    @E("^mudo de tela para \"([^\"]*)\"$")
    public void mudoDeTelaPara(String tela) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        world.setPageAction(pageHandler.pegaTela(tela));
    }

    @E("^seleciono o campo \"([^\"]*)\"$")
    public void selecionoOCampo(String campo) throws Throwable {
        world.getPageAction().clicarBotao(campo);
    }

    @E("^valido o resultado do caso de teste$")
    public void validoOResultadoDoCasoDeTeste() {
        world.getPageAction().validar();
    }

    @E("^recupero as linhas da transação$")
    public void recuperoAsLinhasDaTransação() {
        world.getPageAction().getLinhasTransacao();
    }

    @E("^crio o arquivo$")
    public void crioOArquivo() {
        world.getPageAction().createFile();
    }

    @E("^escrevo as informações no arquivo$")
    public void escrevoAsInformaçõesNoArquivo() {
        world.getPageAction().writeFile();
    }

    @E("^adiciono header ao arquivo$")
    public void adicionoHeaderAoArquivo() {
        world.getPageAction().adicionaHeader();
    }
}
