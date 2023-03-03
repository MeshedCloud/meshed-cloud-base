package cn.meshed.cloud.ability;

import cn.meshed.cloud.core.IDelete;
import cn.meshed.cloud.core.ISave;
import cn.meshed.cloud.core.IUpdate;

/**
 * <h1></h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public interface CommandAbility<C, U, D, R> extends ISave<C, R>, IDelete<D, R>, IUpdate<U, R> {
}
