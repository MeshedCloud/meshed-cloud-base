package cn.meshed.cloud.dto;

/**
 * <h1>安全事件</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public abstract class SecurityEvent extends Event {
    private static final long serialVersionUID = 1L;
    private Operator operator;

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    @Override
    public String toString() {
        if (getUuid() != null){
            return getUuid()+ "#"+ operator.toString();
        }
        return operator.toString();
    }
}
