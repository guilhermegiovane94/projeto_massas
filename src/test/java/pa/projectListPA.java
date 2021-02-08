package pa;

import factory.driverFactory;
import functions.Actions;
import functions.DotEnvHandler;
import functions.Eventos;
import org.openqa.selenium.WebElement;
import po.projectExecutionPO;
import po.projectListPO;

public class projectListPA extends driverFactory implements Actions {
    projectListPO pagina = new projectListPO();

    @Override
    public String getUrl() {
        return "/project_list.htm";
    }

    @Override
    public WebElement getElement(String nome){
        switch (nome){
            case"ambiente": return pagina.btnAmbiente;
            case"lista ambientes": return pagina.listAmbientes;
            case"filtro": return pagina.btnFiltro;
            case"nome": return pagina.txtNome;
            case"enviar": return pagina.btnEnviar;
            case"projeto": return pagina.btnProjeto;
            case"ciclo": return pagina.btnCiclo;
            default:
                System.out.println("Elemento não implementado "+nome);;
        }

        return null;
    }

    @Override
    public void SelectList(String campo, String valor) throws InterruptedException {
        Eventos.escolheList(getElement(campo),valor);
    }

    @Override
    public void SelectTable(String campo, String valor) throws InterruptedException {
        Eventos.escolheTable(getElement(campo),valor);
    }

    @Override
    public void validar(String campo) {
        Eventos.isElementLoaded(getElement(campo));
    }
}
