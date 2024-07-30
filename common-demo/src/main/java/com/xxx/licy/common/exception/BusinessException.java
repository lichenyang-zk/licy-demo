package com.xxx.licy.common.exception;

import com.xxx.licy.common.constant.RespStatus;

import java.util.Objects;

/**
 * 业务异常
 *
 * @author lichenyang
 * @since 2024/7/26 17:20
 */
public class BusinessException extends RuntimeException {

    private int code;
    private String message;

    public BusinessException() {
    }

    public BusinessException(RespStatus status) {
        this(status.getCode(), status.getMessage());
    }

    public BusinessException(RespStatus status, Objects... args) {
        this(status.getCode(), String.format(status.getMessage(), (Object) args));
    }

    public BusinessException(int code, String message) {
        super(message);
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BusinessException that = (BusinessException) o;
        return code == that.code && Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, message);
    }
}
