package fx.standard.enums;

/**
 *提示标题
 */
public enum EAlertTitle {

    ERROR("ERROR", "错误"),

    INFO("INFO", "信息");

    EAlertTitle(String code, String value) {
        this.code = code;
        this.value = value;
    }

    private String code;

    private String value;

    public String getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }
}
