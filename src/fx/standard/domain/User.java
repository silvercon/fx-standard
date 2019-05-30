package fx.standard.domain;

public class User {

    private String loginName;

    private String loginPwd;

    private String type;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public User(String loginName, String loginPwd, String type) {
        super();
        this.loginName = loginName;
        this.loginPwd = loginPwd;
        this.type = type;
    }

    @Override
    public String toString() {
        return "User{" +
                "loginName='" + loginName + '\'' +
                ", loginPwd='" + loginPwd + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
