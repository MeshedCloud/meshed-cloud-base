package cn.meshed.exception.security;

import com.alibaba.cola.exception.BaseException;

/**
 * <h1>认证权限</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public class AuthenticationException extends BaseException {
    private static final long serialVersionUID = 1L;
    private static final String DEFAULT_ERR_CODE = "AUTHENTICATION_ERROR";

    public AuthenticationException(String errMessage) {
        super(DEFAULT_ERR_CODE,errMessage);
    }

    public AuthenticationException(String errCode, String errMessage) {
        super(errCode, errMessage);
    }

    public AuthenticationException(String errMessage, Throwable e) {
        super(DEFAULT_ERR_CODE,errMessage, e);
    }

    public AuthenticationException(String errCode, String errMessage, Throwable e) {
        super(errCode, errMessage, e);
    }
}
