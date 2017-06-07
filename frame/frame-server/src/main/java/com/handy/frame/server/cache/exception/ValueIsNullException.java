package com.handy.frame.server.cache.exception;


import com.handy.frame.shared.exception.GeneralException;

/**
 * @author longhairen
 * @create 2017-05-21 14:35
 * @description  key存在，value为null
 **/
public class ValueIsNullException extends GeneralException {

    private static final long serialVersionUID = 932825584009506614L;

    public ValueIsNullException(String message) {
        super(message);
    }

    public ValueIsNullException(Throwable e) {
        super(e);
    }

    public ValueIsNullException(String message, Throwable cause) {
        super(message, cause);
    }
    
    
}
