package cn.meshed.cloud.utils;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * <h1>bean 拷贝工具</h1>
 *
 * @version 1.0
 * @author: Vincent Vic
 */
public class CopyUtils extends BeanUtils {

    public static <S, T> void copy(S sources, T target) {
        copyProperties(sources, target);
    }

    public static <S, T> T copy(S sources, Class<T> clazz) {
        if (sources == null) {
            return null;
        }
        try {
            T instance = clazz.newInstance();
            copyProperties(sources, instance);
            return instance;
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }

    public static <S, T> List<T> copyListProperties(Collection<S> sources, Supplier<T> target) {
        if (CollectionUtils.isEmpty(sources)) {
            return Collections.emptyList();
        }
        return copyListProperties(sources, target, null);
    }

    /**
     * 使用场景：Entity、Bo、Vo层数据的复制，因为BeanUtils.copyProperties只能给目标对象的属性赋值，却不能在List集合下循环赋值，因此添加该方法
     * 如：List<AdminEntity> 赋值到 List<AdminVo> ，List<AdminVo>中的 AdminVo 属性都会被赋予到值
     * S: 数据源类 ，T: 目标类::new(eg: AdminVo::new)
     */
    public static <S, T> List<T> copyListProperties(Collection<S> sources, Supplier<T> target, CopyUtilsCallBack<S, T> callBack) {
        if (CollectionUtils.isEmpty(sources)) {
            return Collections.emptyList();
        }
        List<T> list = new ArrayList<>(sources.size());
        for (S source : sources) {
            T t = target.get();
            copyProperties(source, t);
            if (callBack != null) {
                // 回调
                callBack.callBack(source, t);
            }
            list.add(t);
        }
        return list;
    }

    public static <S, T> Set<T> copySetProperties(Collection<S> sources, Supplier<T> target) {
        if (CollectionUtils.isEmpty(sources)) {
            return Collections.emptySet();
        }
        return copySetProperties(sources, target, null);
    }

    /**
     * 使用场景：Entity、Bo、Vo层数据的复制，因为BeanUtils.copyProperties只能给目标对象的属性赋值，却不能在List集合下循环赋值，因此添加该方法
     * 如：Set<AdminEntity> 赋值到 Set<AdminVo> ，Set<AdminVo>中的 AdminVo 属性都会被赋予到值
     * S: 数据源类 ，T: 目标类::new(eg: AdminVo::new)
     */
    public static <S, T> Set<T> copySetProperties(Collection<S> sources, Supplier<T> target, CopyUtilsCallBack<S, T> callBack) {
        if (CollectionUtils.isEmpty(sources)) {
            return Collections.emptySet();
        }
        Set<T> sets = new HashSet<>(sources.size());
        for (S source : sources) {
            T t = target.get();
            copyProperties(source, t);
            if (callBack != null) {
                // 回调
                callBack.callBack(source, t);
            }
            sets.add(t);
        }
        return sets;
    }

    /**
     * 复制list
     *
     * @param sources 原列表
     * @param target  目标类型
     * @param <T>     原列表类型
     * @param <K>     目标类型
     * @return 复制的列表
     */
    public static <T, K> List<K> copyListProperties(Collection<T> sources, Class<K> target) {
        if (CollectionUtils.isEmpty(sources)) {
            return Collections.emptyList();
        }
        return sources.stream().map(e -> copy(e, target)).collect(Collectors.toList());
    }


}
