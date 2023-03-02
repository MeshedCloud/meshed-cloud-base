package cn.meshed.base.utils;

import cn.meshed.cloud.dto.ShowType;
import cn.meshed.cloud.dto.TipResponse;
import com.alibaba.cola.dto.PageResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import org.apache.commons.lang3.StringUtils;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Supplier;

/**
 * <h1>结果工具类</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public class ResultUtils {

    public static SingleResponse ok(){
        return of(true,null,"成功");
    }

    public static SingleResponse fail(){
        return fail("400","失败");
    }

    public static SingleResponse fail(String errMsg){
        return fail("400",errMsg);
    }

    public static <T> TipResponse<T> fail(String errCode, String errMessage) {
        return fail(errCode, errMessage,ShowType.ERROR_MESSAGE);
    }
    public static <T> TipResponse<T> fail(Response response) {
        if (response == null){
            return fail("400","失败");
        } else if (response instanceof TipResponse) {
            int showType = ((TipResponse<?>) response).getShowType();
            return fail(response.getErrCode(),response.getErrMessage(), ShowType.of(showType));
        } else {
            return fail(response.getErrCode(),response.getErrMessage());
        }
    }

    public static <T> TipResponse<T> warn(String errCode, String errMessage) {
        return fail(errCode, errMessage,ShowType.WARN_MESSAGE);
    }
    public static <T> TipResponse<T> notification(T data) {
        return of(data,ShowType.NOTIFICATION);
    }

    public static <T> SingleResponse of(Boolean condition,String errMsg){
        if (condition){
            return SingleResponse.buildSuccess();
        }
        return SingleResponse.buildFailure("400",errMsg);
    }

    public static <T> SingleResponse of(Boolean condition,T success,String errMsg){
        if (condition){
            return SingleResponse.of(success);
        }
        return SingleResponse.buildFailure("400",errMsg);
    }

    public static <T> TipResponse<T> fail(String errCode, String errMessage,ShowType showType) {
        TipResponse<T> response = new TipResponse<>();
        response.setSuccess(false);
        response.setErrCode(errCode);
        response.setErrMessage(errMessage);
        response.setShowType(showType.getType());
        return response;
    }

    public static <T> SingleResponse<T> of(T data){
        return SingleResponse.of(data);
    }

    public static <T> TipResponse<T> of(T data,ShowType showType) {
        TipResponse<T> response = new TipResponse<>();
        response.setSuccess(true);
        response.setData(data);
        response.setShowType(showType.getType());
        return response;
    }

    public static <T> SingleResponse<T> ofNullable(T data){
        return ofNullable(data,"操作失败");
    }

    public static <T> SingleResponse ofNullable(T data, String errMsg){
        if (Objects.isNull(data) || data instanceof String && StringUtils.isNotBlank((CharSequence) data)){
            return fail(errMsg);
        }
        return SingleResponse.of(data);
    }


    public static <S, T> SingleResponse<T> convertResponse(SingleResponse<S> sources, Class<T> clazz) {
        if (sources == null) {
            return ResultUtils.fail("系统异常:答复数据丢失");
        } else if (!sources.isSuccess()){
            return ResultUtils.fail(sources);
        }
        return of(CopyUtils.copy(sources.getData(),clazz));
    }

    public static <S, T> SingleResponse<T> copy(S sources, Class<T> clazz) {
        return of(CopyUtils.copy(sources,clazz));
    }

    public static <S, T> SingleResponse<List<T>> copyList(Collection<S> sources, Supplier<T> target) {
        return of(CopyUtils.copyListProperties(sources, target));
    }

    public static <S, T> SingleResponse<Set<T>> copySet(Collection<S> sources, Supplier<T> target) {
        return of(CopyUtils.copySetProperties(sources, target));
    }


    public static <S, T> PageResponse<T> copyPage(PageResponse<S> sources, Supplier<T> target) {
        if (sources == null){
            return null;
        }
        List<S> data = sources.getData();
        List<T> targetList = CopyUtils.copyListProperties(data, target);
        return PageResponse.of(targetList, sources.getTotalCount(),
                sources.getPageSize(), sources.getPageIndex());
    }

}
