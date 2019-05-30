package fx.standard.util;

import fx.standard.enums.EAlertTitle;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import javafx.scene.control.Alert.AlertType;

public class PropertiesUtil {

    private static Properties props;

    static {
        props = new Properties();
        try {
            props.load(Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("config.properties"));
        } catch (FileNotFoundException e) {
            ShowAlert.alert(AlertType.ERROR, EAlertTitle.ERROR.getValue(),"找不到config.properties文件");
        } catch (IOException e) {
            ShowAlert.alert(AlertType.ERROR, EAlertTitle.ERROR.getValue(),"读取config.properties文件出错");
        }
    }

    public static String getProperty(String key) {
        if (props == null) {
            // throw new Exception("配置文件初始化失败");
        }
        return props.getProperty(key);
    }

    public static final class Config {

        public static String GCHF_URL = props.getProperty("GCHF_URL");

    }
}
