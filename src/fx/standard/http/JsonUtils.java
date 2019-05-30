package fx.standard.http;

import com.google.gson.Gson;
import fx.standard.enums.EAlertTitle;
import fx.standard.util.ShowAlert;
import javafx.scene.control.Alert.AlertType;

public class JsonUtils {

    public static <T> T json2Bean(String json, Class<T> clazz) {
        boolean isJson = new JsonValidator().validate(json);
        if (!isJson) {
            ShowAlert.alert(AlertType.ERROR, EAlertTitle.ERROR.getValue(),"json格式不正确");
        }
        T t = null;
        try {
            Gson gson = new Gson();
            t = (T) gson.fromJson(json, clazz);
        } catch (Exception e) {
            ShowAlert.alert(AlertType.ERROR, EAlertTitle.ERROR.getValue(),"json2Bean不正确:" + e.getMessage());
        }
        return t;
    }

    public static String object2Json(Object bean) {
        Gson gson = new Gson();
        return gson.toJson(bean);
    }

    public static String string2Json(String key, String value) {
        return "{\"" + key + "\":\"" + value + "\"}";
    }
}
