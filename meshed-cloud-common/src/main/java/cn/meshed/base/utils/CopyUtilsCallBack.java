package cn.meshed.base.utils;

@FunctionalInterface
public interface CopyUtilsCallBack <S, T> {
    void callBack(S t, T s);
}