package cn.meshed.cloud.gateway;

import cn.meshed.cloud.ability.CommandAbility;
import cn.meshed.cloud.ability.QueryAbility;

/**
 * <h1>基本能力包含增删改查</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public interface BaseGateway<C, U, D, Q, CR, QR> extends CommandAbility<C, U, D, CR>, QueryAbility<Q, QR> {
}
