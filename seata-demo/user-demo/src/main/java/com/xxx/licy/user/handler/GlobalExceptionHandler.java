package com.xxx.licy.user.handler;

import com.xxx.licy.userdb.api.exception.BusinessException;
import com.xxx.licy.userdb.api.model.ServiceResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 *
 * @author lichenyang
 * @since 2023/11/27 4:49
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(BusinessException.class)
    public ServiceResp businessExceptionHandler(BusinessException businessException) {
        LOGGER.error(businessException.getMessage());
        return new ServiceResp(businessException.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ServiceResp exceptionHandler(Exception exception) {
        LOGGER.error(exception.getMessage());
        return new ServiceResp(exception.getMessage());
    }
}
