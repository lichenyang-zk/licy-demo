package com.xxx.licy.common.model;

import com.xxx.licy.common.constant.RespStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 查询服务响应
 *
 * @author lichenyang
 * @since 2024/7/26 16:48
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class QueryReap<T> extends ServiceResp {

    private T resultObject;
    private List<T> resultList;

    public QueryReap() {
    }

    public QueryReap(T resultObject) {
        this.resultObject = resultObject;
    }

    public QueryReap(List<T> resultList) {
        this.resultList = resultList;
    }

    public QueryReap(T resultObject, List<T> resultList) {
        this.resultObject = resultObject;
        this.resultList = resultList;
    }

    public static <T> QueryReap<T> getServiceFallback(Class<T> tClass) {
        QueryReap<T> queryReap = new QueryReap<>();
        queryReap.setServiceRespStatus(RespStatus.SERVICE_FALLBACK);
        return queryReap;
    }
}
