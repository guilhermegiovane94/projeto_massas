package functions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface Actions {
    default void acessar() {}
    default void validar() {}
    default void validar(String campo) {}
    default void inserirDados(Map<String, String> dados) throws  InterruptedException, IOException, Exception {}
    default void inserirDados(List<String> dados) throws  InterruptedException {}
    default void inserirDados(String botao, String valor) throws  InterruptedException {}
    default void inserirDados(String dado) throws  InterruptedException {}
    default void inserirMassa(List<Map<String, String>> massa) throws  InterruptedException {}
    default void acessarAba(String aba) throws InterruptedException {}

    default void clicarBotao(String button) {

    }

    default void acessaConta(String button, String conta) throws InterruptedException {

    }
}
