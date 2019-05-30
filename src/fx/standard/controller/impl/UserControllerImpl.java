package fx.standard.controller.impl;

import com.alibaba.fastjson.JSONObject;
import fx.standard.controller.IUserController;
import fx.standard.domain.User;
import fx.standard.enums.EAlertTitle;
import fx.standard.enums.EUserType;
import fx.standard.http.BizConnecter;
import fx.standard.util.ShowAlert;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import org.apache.commons.lang.StringUtils;

/**
 * @author : silver
 * @since : 2019-05-29 17:15
 */
public class UserControllerImpl implements IUserController {

    @FXML
    private TextField txtLoginName;

    @FXML
    private TextField txtLoginPass;

    @Override
    public void doLogin(){
        String loginName = txtLoginName.getText();
        String passWord = txtLoginPass.getText();

        if (StringUtils.isEmpty(loginName) || StringUtils.isEmpty(passWord)) {
            ShowAlert.alert(AlertType.WARNING, EAlertTitle.ERROR.getValue(),"请输入登录名和密码");
        }

        User user = new User(loginName, passWord, EUserType.Owner.getCode());

        String data = BizConnecter.getBizData("631071",
                JSONObject.toJSONString(user));

        if(StringUtils.isNotBlank(data) && data.contains("userId")){
            ShowAlert.alert(AlertType.WARNING, EAlertTitle.INFO.getValue(),"登录成功");
        }

    }

    @Override
    public void doExit(){
        Platform.exit();
    }
}
