package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
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
    public void insiroNoCampo(String botao, String valor) throws Throwable {
        world.getPageAction().inserirDados(botao, valor);
    }

    @Entao("^clico no botão \"([^\"]*)\"$")
    public void clicoNoBotão(String botao) throws Throwable {
        world.getPageAction().clicarBotao(botao);
    }
}
