package configuration;

import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
    private static final Properties properties;

    static {
        properties = new Properties();
        try {
            properties.load(ReadProperties.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getUrl() {
        return properties.getProperty("url");
    }
    public static String getUrl1() {
        return properties.getProperty("url1");
    }
    public static String getUrl2() {
        return properties.getProperty("url2");
    }
public static String getUrl3() {
        return properties.getProperty("url3");
    }

    public static String browserName() {
        return properties.getProperty("browser");
    }

    public static boolean isHeadless() {
        return properties.getProperty("headless").equalsIgnoreCase("true");
    }

    public static int timeout() {
        return Integer.parseInt(properties.getProperty("timeout"));
    }
}
