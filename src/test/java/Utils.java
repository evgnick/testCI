import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Utils {

    public static ChromeOptions getChromeOptions() {
        try {
            Properties properties = new Properties();
            FileInputStream input = new FileInputStream("src/test/resources/local.properties");
            properties.load(input);

            String chromeOptions = properties.getProperty("chrome_options");

            ChromeOptions options = new ChromeOptions();
            if (chromeOptions != null && !chromeOptions.isEmpty()) {
                String[] optionsArray = chromeOptions.split(";");
                for (String option : optionsArray) {
                    options.addArguments(option);
                }
            }
            return options;
        } catch (IOException e) {
            e.printStackTrace();
            return new ChromeOptions();
        }

    }
}
