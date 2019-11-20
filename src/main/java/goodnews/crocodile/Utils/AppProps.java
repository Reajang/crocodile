package goodnews.crocodile.Utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class AppProps {
    private static Properties properties;

    private AppProps() {
    }

    public static Properties inst() {
        synchronized (properties) {
            if (properties == null) {
                try (FileReader propertiesReader = new FileReader(new File("app.properties"))) {
                    properties = new Properties();
                    properties.load(propertiesReader);
                } catch (IOException e) {
                    System.out.println("Не найден файл свойств app.properties");
                    e.printStackTrace();
                }
            }
            return properties;
        }
    }

}
