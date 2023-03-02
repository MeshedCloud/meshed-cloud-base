package cn.meshed.base.gateway;

import cn.meshed.base.core.IDelete;
import cn.meshed.base.core.ISave;
import cn.meshed.base.core.IUpdate;

/**
 * <h1></h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public interface CommandGateway<C, U, D, R> extends ISave<C, R>, IDelete<D, R>, IUpdate<U, R> {
}
