package pa;

import factory.driverFactory;
import functions.*;
import org.openqa.selenium.WebElement;
import po.indexPO;
import po.projectExecutionPO;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class projectExecutionPA extends driverFactory implements Actions {
    projectExecutionPO pagina = new projectExecutionPO();
    List<String> arquivo = new ArrayList<>();

    @Override
    public String getUrl() {
        return "/project_execution.htm";
    }

    @Override
    public WebElement getElement(String nome){
        switch (nome){
            case"filtro": return pagina.btnFiltro;
            case"nome": return pagina.txtNome;
            case"enviar": return pagina.btnFiltrar;
            case"caso de teste": return pagina.btnCasoDeTeste;
            case"executar teste": return pagina.btnExecutarCT;
            case"resultado teste": return pagina.ResultadoCT;
            case"gerar log teste": return pagina.btnCasoDeTeste;
            case"lupa": return pagina.btnLupa;
            case"primeiro expand": return pagina.btnPrimeiroExpand;
            case"segundo expand": return pagina.btnSegundoExpand;
            //case"linhas": return pagina.linhasTransacao;
            default:
                System.out.println("Elemento não implementado "+nome);;
        }

        return null;
    }

    @Override
    public void validar(String campo) {
        boolean loop = true;
        while (loop) {
            String classe = getElement(campo).getAttribute("class");
            if(classe.contains("glyphicon-unchecked") ||
                    classe.contains("glyphicon-refresh") ||
                    classe.contains("glyphicon-time") ){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                loop=false;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    @Override
    public void getLinhasTransacao() {
       List<WebElement> linhas = pagina.linhasTransacao;
       String retorno = Eventos.validoResposta(linhas);

       if(!retorno.equalsIgnoreCase("00")){
           //mapa de bits para erros
           arquivo.add(Eventos.getLinhaBit(linhas,"002"));
           arquivo.add(Eventos.getLinhaBit(linhas,"011"));
           arquivo.add(Eventos.getLinhaBit(linhas,"012"));
           arquivo.add(Eventos.getLinhaBit(linhas,"013"));
           arquivo.add(Eventos.getLinhaBit(linhas,"039"));
           arquivo.add(Eventos.getLinhaBit(linhas,"048"));
       }
       else{
           //mapa de bit para transações OK
           arquivo.add(Eventos.getLinhaBit(linhas,"011"));
           arquivo.add(Eventos.getLinhaBit(linhas,"012"));
           arquivo.add(Eventos.getLinhaBit(linhas,"038"));
       }
    }

    @Override
    public void createFile() {
        FileHandler.createFile();
    }

    @Override
    public void writeFile() {
        FileHandler.writeFile(arquivo);
    }

    @Override
    public void adicionaHeader() {
        String CT = getElement("caso de teste").getText();
        CT.trim();
        int index = CT.indexOf("Versão");
        CT = CT.substring(0,index);
        arquivo.add(CT);
    }
}
