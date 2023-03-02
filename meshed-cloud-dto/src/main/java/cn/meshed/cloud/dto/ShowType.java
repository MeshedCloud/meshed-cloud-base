package cn.meshed.cloud.dto;

/**
 * <h1>Error Show Type</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public enum ShowType {

    //静默
    SILENT(0),
    //警告
    WARN_MESSAGE(1),
    //错误
    ERROR_MESSAGE(2),
    //通知
    NOTIFICATION(3),
    //重定向
    REDIRECT(9);

    /**
     * 类型
     */
    private int type;

    ShowType(int type) {
        this.type = type;
    }

    public static ShowType of(int showType) {
        for (ShowType value : values()) {
            if (value.getType() == showType){
                return value;
            }
        }
        throw new RuntimeException("ShowType: enum type not found");
    }

    public int getType() {
        return type;
    }

    @Override
    public String toString() {
        return String.valueOf(type);
    }
}
