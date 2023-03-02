package cn.meshed.cloud.dto;

import com.alibaba.cola.dto.SingleResponse;

/**
 * <h1></h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public class TipResponse<T> extends SingleResponse<T> {

    /**
     * 显示等级 {@link ShowType}
     */
    private int showType;

    public int getShowType() {
        return showType;
    }

    public void setShowType(int showType) {
        this.showType = showType;
    }

    @Override
    public String toString() {
        return "[" + showType + ']' + super.toString();
    }
}
