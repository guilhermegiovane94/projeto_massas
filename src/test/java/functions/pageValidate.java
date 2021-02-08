package functions;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public class pageValidate {
    private static Map<String,String> telas = new HashMap<String,String>() {{
        put("login", "Login");
        put("index", "Index");
        put("project list", "project_list");
        put("project execution", "project_execution");
    }};

    //Baseada na tela acessada, verifica se a url atual contém um regex
    public static Boolean verifica(String tela, String url){

        tela = tela.toLowerCase();
        url = url.toLowerCase();

        Boolean telaCorreta = null;
        try{
            telaCorreta = url.contains(telas.get(tela).toLowerCase());
        }
        catch (NullPointerException e){
            Assert.fail("A tela " + tela + " não consta no sistema.");
        }

        return telaCorreta;
    }

}
