import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Utils {

    public static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();

        // Попытка получить опции из переменной окружения
        String envChromeOptions = System.getenv("CHROME_OPTIONS");
        if (envChromeOptions != null && !envChromeOptions.isEmpty()) {
            String[] optionsArray = envChromeOptions.split(";");
            for (String option : optionsArray) {
                options.addArguments(option);
            }
        } else {
            // Если переменная окружения не задана, читаем файл local.properties
            try (FileInputStream input = new FileInputStream("src/test/resources/local.properties")) {
                Properties properties = new Properties();
                properties.load(input);

                String fileChromeOptions = properties.getProperty("chrome_options");
                if (fileChromeOptions != null && !fileChromeOptions.isEmpty()) {
                    String[] optionsArray = fileChromeOptions.split(";");
                    for (String option : optionsArray) {
                        options.addArguments(option);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.err.println("Ошибка чтения файла local.properties. Используются стандартные настройки.");
            }
        }

        return options;
    }

}
