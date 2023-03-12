package Framework;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppConfiguration {
    private static Properties config = null;

    public static boolean load(String pathConfigFile) {
        try {
            if (config == null)
                config = new Properties();
            InputStream configInput = new FileInputStream(pathConfigFile);
            config.load(configInput);

            System.out.println(">> (ok) AppConfiguration.load()");
            return true;
        } catch (IOException e) { // FileNotFoundException
            System.out.println(">> (error) AppConfiguration.load() " + e.getMessage());
        }
        return false;
    }

    public static String getDBName() {
        if (config == null) {
            System.out.println(">> (issue) AppConfiguration.getDB_NAME(), llamar primero a AppConfiguration.load() y agregar DB_NAME en CONFIG ");
            return "";
        }
        return config.getProperty(APP.GLOBAL.DB_NAME, "");
    }

    public static String getDBPathConnection() {
        if (config == null) {
            System.out.println(">> (issue) AppConfiguration.DB_PATH(), llamar primero a AppConfiguration.load() y agregar DB_PATH en CONFIG ");
            return "";
        }
        if (!config.containsKey(APP.GLOBAL.DB_PATH)) {
            System.out.println(">> (issue) AppConfiguration.DB_PATH(), la clave DB_PATH no está presente en la configuración.");
            return "";
        }
        String dbPath = config.getProperty(APP.GLOBAL.DB_PATH, "");
        if (dbPath.isEmpty()) {
            System.out.println(">> (issue) AppConfiguration.DB_PATH(), el valor de DB_PATH está vacío.");
            return "";
        }
        String dbName = getDBName();
        if (dbName.isEmpty()) {
            return "";
        }
        dbPath = "jdbc:sqlite:" + dbPath.replace('/', '\\') + "\\\\" + dbName;
        return dbPath;
    }
}
