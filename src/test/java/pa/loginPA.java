package pa;


import factory.driverFactory;
import functions.Actions;
import functions.Eventos;
import org.openqa.selenium.WebElement;
import po.loginPO;

public class loginPA extends driverFactory implements Actions {

    loginPO pagina = new loginPO();

    private String getUrl(){
        return "/logon.htm";
    }

    @Override
    public void inserirDados(String botao, String valor) throws InterruptedException {
        Eventos.insereTexto(getElement(botao),valor);
    }

    @Override
    public void clicarBotao(String button) {
        Eventos.clicaElemento(getElement(button));
    }

    @Override
    public void acessar() {
        accessDriver(String.format("%s%s","http://172.26.86.28", getUrl()));
    }

    public WebElement getElement(String nome){
        switch (nome){
            case"user": return pagina.txtUser;
            case"senha": return pagina.txtSenha;
            case"login": return pagina.btnLogin;

            default:
                System.out.println("Elemento não implementado "+nome);;
        }

        return null;
    }
}
