package cn.meshed.cloud.exception.security;

import com.alibaba.cola.exception.BaseException;

/**
 * <h1>安全异常</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public class SysSecurityException extends BaseException {
    private static final long serialVersionUID = 1L;
    private static final String DEFAULT_ERR_CODE = "SECURITY_FORBIDDEN";

    public SysSecurityException(String errMessage) {
        super(DEFAULT_ERR_CODE,errMessage);
    }

    public SysSecurityException(String errCode, String errMessage) {
        super(errCode, errMessage);
    }

    public SysSecurityException(String errMessage, Throwable e) {
        super(DEFAULT_ERR_CODE,errMessage, e);
    }

    public SysSecurityException(String errCode, String errMessage, Throwable e) {
        super(errCode, errMessage, e);
    }
}
