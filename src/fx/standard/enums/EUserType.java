package fx.standard.enums;

public enum EUserType {
    Plat("P", "平台用户"),

    Bank("B", "银行用户"),

    Owner("O", "业主单位"),

    Supervise("S", "监管端");

    EUserType(String code, String value) {
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
