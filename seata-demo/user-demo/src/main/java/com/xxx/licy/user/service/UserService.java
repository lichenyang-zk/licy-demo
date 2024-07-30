package com.xxx.licy.user.service;

import com.xxx.licy.common.model.ServiceResp;

/**
 * 用户服务接口
 *
 * @author lichenyang
 * @since 2024/7/29 17:49
 */
public interface UserService {

    /**
     * 模拟用户购买东西
     *
     * @return 服务响应
     */
    ServiceResp buy();
}
