package configiration;

import java.io.InputStream;
import java.util.Properties;

public class configReader {
    private static Properties properties = new Properties();

    static {
        try (InputStream input = configReader.class.getClassLoader().getResourceAsStream("config.properties")) {
            properties.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getUrl() {
        return properties.getProperty("url");
    }

}