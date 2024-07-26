package com.xxx.licy.common.constant;

import lombok.Getter;

/**
 * 服务响应状态
 *
 * @author lichenyang
 * @since 2024/7/26 16:37
 */
@Getter
public enum RespStatus {

    FAILED(0, "失败"),
    SUCCESS(1, "成功"),
    SERVICE_FALLBACK(9999, "服务降级");

    private int code;
    private String message;

    RespStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
