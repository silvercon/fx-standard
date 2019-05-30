/**
 * @Title BizConnecter.java 
 * @Package com.ibis.pz.http 
 * @Description 
 * @author miyb  
 * @date 2015-5-12 下午9:44:59 
 * @version V1.0   
 */
package fx.standard.http;

import fx.standard.enums.EAlertTitle;
import fx.standard.util.PropertiesUtil;
import fx.standard.util.RegexUtils;
import fx.standard.util.ShowAlert;
import java.util.Properties;
import javafx.scene.control.Alert.AlertType;

public class BizConnecter {
    public static final String YES = "0";

    public static final String GCHF_URL = PropertiesUtil.Config.GCHF_URL;

    public static final String POST_URL = "...";

    public static <T> T getBizData(String code, String json, Class<T> clazz) {
        String data = getBizData(code, json);
        return JsonUtils.json2Bean(data, clazz);
    }

    public static String getBizData(String code, String json) {
        String data = null;
        String resJson = null;
        try {
            Properties formProperties = new Properties();
            formProperties.put("code", code);
            formProperties.put("json", json);
            resJson = PostSimulater.requestPostForm(getPostUrl(code),
                formProperties);
        } catch (Exception e) {
            ShowAlert.alert(AlertType.ERROR, EAlertTitle.ERROR.getValue(),"链接请求超时，请联系管理员");
        }
        // 开始解析响应json
        String errorCode = RegexUtils.find(resJson, "errorCode\":\"(.+?)\"", 1);
        String errorInfo = RegexUtils.find(resJson, "errorInfo\":\"(.+?)\"", 1);
        if (YES.equalsIgnoreCase(errorCode)) {
            data = RegexUtils.find(resJson, "data\":(.*)\\}", 1);
        } else {
            ShowAlert.alert(AlertType.ERROR, EAlertTitle.ERROR.getValue(),errorInfo);
        }
        return data;
    }

    private static String getPostUrl(String code) {
        String postUrl = POST_URL;
        if (true) {
            postUrl = GCHF_URL;
        }
        return postUrl;
    }

}
