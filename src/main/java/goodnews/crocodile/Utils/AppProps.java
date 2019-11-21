package goodnews.crocodile.Utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class AppProps {
    private static Properties properties;
    private static String path = "src/main/resources/app.properties";

    private AppProps() {
    }
    public static Properties inst() {
        synchronized (AppProps.class) {
            if (properties == null) {
                try (FileReader propertiesReader = new FileReader(new File(path))) {
                    properties = new Properties();
                    properties.load(propertiesReader);
                } catch (IOException e) {
                    System.out.println("Не найден файл свойств по пути " + path);
                    e.printStackTrace();
                }
            }
            return properties;
        }
    }

}
