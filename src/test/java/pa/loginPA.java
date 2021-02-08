package pa;


import factory.driverFactory;
import functions.Actions;
import functions.DotEnvHandler;
import functions.Eventos;
import org.openqa.selenium.WebElement;
import po.loginPO;

public class loginPA extends driverFactory implements Actions {

    loginPO pagina = new loginPO();

    @Override
    public String getUrl() {
        return "/logon.htm";
    }

    @Override
    public WebElement getElement(String nome){
        switch (nome){
            case"user": return pagina.txtUser;
            case"password": return pagina.txtPassword;
            case"login": return pagina.btnLogin;

            default:
                System.out.println("Elemento não implementado "+nome);;
        }

        return null;
    }
}
