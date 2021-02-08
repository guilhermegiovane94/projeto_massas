package functions;

import factory.driverFactory;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;
import java.util.Map;


public interface Actions {
    default void acessar() {
        driverFactory.accessDriver(String.format("%s%s", DotEnvHandler.getSite(), getUrl()));
        Eventos.waitForLoad();
    }
    default void validar() {}
    default void validar(String campo) {}
    default void inserirDados(Map<String, String> dados) throws  InterruptedException, IOException, Exception {}
    default void inserirDados(List<String> dados) throws  InterruptedException {}
    default void inserirDados(String botao, String valor) throws  InterruptedException {Eventos.insereTexto(getElement(botao),valor);}
    default void SelectList(String campo, String valor) throws  InterruptedException {}
    default void SelectTable(String campo, String valor) throws  InterruptedException {}
    default void inserirDados(String dado) throws  InterruptedException {}
    default void inserirMassa(List<Map<String, String>> massa) throws  InterruptedException {}
    default void acessarAba(String aba) throws InterruptedException {}

    default void clicarBotao(String button) throws InterruptedException {Eventos.clicaElemento(getElement(button));}
    default void acessaConta(String button, String conta)  {}
    default WebElement getElement(String nome)throws InterruptedException{return null;}
    default String getUrl(){return null;}
    default void getLinhasTransacao(){}
    default void createFile(){}
    default void writeFile(){}
    default void adicionaHeader(){}
}
