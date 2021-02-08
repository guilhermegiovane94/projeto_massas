package pa;

import factory.driverFactory;
import functions.Actions;
import functions.DotEnvHandler;
import functions.Eventos;
import org.openqa.selenium.WebElement;
import po.indexPO;
import po.loginPO;

public class indexPA extends driverFactory implements Actions {
    indexPO pagina = new indexPO();

    @Override
    public String getUrl() {
        return "/index.htm";
    }

    @Override
    public WebElement getElement(String nome){
        switch (nome){
            case"drop projeto": return pagina.drpProjeto;
            case"visao geral": return pagina.btnVisaoGeral;
            case"usuario": return pagina.btnUsuario;
          //  case"login": return pagina.btnLogin;

            default:
                System.out.println("Elemento não implementado "+nome);;
        }

        return null;
    }

    @Override
    public void validar(String campo) {
        Eventos.isElementLoaded(getElement(campo));
        getElement(campo).getText().equalsIgnoreCase("Guilherme Oliveira");
    }
}
