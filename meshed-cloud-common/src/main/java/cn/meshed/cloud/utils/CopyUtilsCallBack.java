package cn.meshed.cloud.utils;

@FunctionalInterface
public interface CopyUtilsCallBack <S, T> {
    void callBack(S t, T s);
}