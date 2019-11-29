package goodnews.crocodile.Utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Props {
    private static Properties properties;
    private static String path = "src/main/resources/app.properties";

    private Props() {
    }

    public static Properties inst() {
        //synchronized (Props.class) {//Синхронизация по классу не подходит, если будут другие проперти
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
        //}
    }

}
