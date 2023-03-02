package cn.meshed.base.cqrs;

import java.io.Serializable;

/**
 * <h1>CMD 对象操作 - 充血模型</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public interface Command extends Serializable {

    /**
     * 验证自身对象数据是否合法
     * @return 校验结果
     */
    Boolean verifySelf();
}
