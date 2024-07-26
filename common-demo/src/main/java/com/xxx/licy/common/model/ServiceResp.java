package com.xxx.licy.common.model;

import com.xxx.licy.common.constant.RespStatus;
import lombok.Data;

import java.io.Serializable;

/**
 * 服务响应
 *
 * @author lichenyang
 * @since 2024/7/26 16:33
 */
@Data
public class ServiceResp implements Serializable {

    private static final ServiceResp SERVICE_FALLBACK;
    private int statusCode;
    private String message;

    static {
        SERVICE_FALLBACK = new ServiceResp(RespStatus.SERVICE_FALLBACK);
    }

    public ServiceResp() {
        this(RespStatus.SUCCESS);
    }

    public ServiceResp(RespStatus status) {
        this(status.getCode(), status.getMessage());
    }

    public ServiceResp(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public void setServiceRespStatus(RespStatus status) {
        this.setStatusCode(status.getCode());
        this.setMessage(status.getMessage());
    }

    public static ServiceResp getServiceFallback() {
        return SERVICE_FALLBACK;
    }
}
