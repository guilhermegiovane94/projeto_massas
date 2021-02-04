package functions;

import pa.loginPA;

import javax.swing.*;

public class pageHandler {
    public static Actions pegaTela(String tela) throws ClassNotFoundException {
        switch (tela.toLowerCase()){
            case "login": return new loginPA();

            default: throw new ClassNotFoundException("A tela " + tela + " não foi implementada");
        }
    }
}
