package configuration;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class UpdateEnvironmentProperties {
    private static final Properties properties;
    static String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
    static String appConfigPath = rootPath + "environment.properties";

    static {
        properties = new Properties();
    }

    public static void storeEnvProperties() {
        //System.getProperties().list(System.out);

        try {
            properties.store(new FileWriter(appConfigPath), "Environment Properties");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void setProperty(String name, String value) {
        properties.setProperty(name, value);
    }
}
