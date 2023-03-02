package cn.meshed.base.constant;


/**
 * <h1></h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public enum Status {

    /**
     * 0 失效
     * 1 有效
     * 2 删除
     */
    INVALID(0, "INVALID"),
    VALID(1, "VALID"),
    DELETE(2, "DELETE");

    /**
     * 状态
     */
    private int status;
    private String desc;

    Status(int status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public int getStatus() {
        return status;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "[" + status + "]=" + desc;
    }

}
