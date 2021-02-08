package functions;

import pa.indexPA;
import pa.loginPA;
import pa.projectExecutionPA;
import pa.projectListPA;

import javax.swing.*;

public class pageHandler {
    public static Actions pegaTela(String tela) throws ClassNotFoundException {
        switch (tela.toLowerCase()){
            case "login": return new loginPA();
            case "index": return new indexPA();
            case "project list": return new projectListPA();
            case "project execution": return new projectExecutionPA();

            default: throw new ClassNotFoundException("A tela " + tela + " não foi implementada");
        }
    }
}
