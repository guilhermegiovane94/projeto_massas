package functions;

import io.github.cdimascio.dotenv.Dotenv;

public class DotEnvHandler {
    private static Dotenv dotenv = Dotenv.load();

    public static String getUsuario(){
        return dotenv.get("user");
    }
    public static String getPassword(){
        return dotenv.get("password");
    }
    public static String getSite(){
        return dotenv.get("site");
    }
}
