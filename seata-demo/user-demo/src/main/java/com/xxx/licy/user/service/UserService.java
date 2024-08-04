package com.xxx.licy.user.service;

import com.xxx.licy.userdb.api.model.QueryResp;
import com.xxx.licy.userdb.api.model.ServiceResp;
import com.xxx.licy.userdb.api.model.UserVo;

import java.math.BigDecimal;

/**
 * 余额服务接口
 *
 * @author lichenyang
 * @since 2023/11/22 20:08
 */
public interface UserService {

    /**
     * 根据用户id查询用户信息
     *
     * @param id 用户id
     * @return 用户信息
     */
    QueryResp<UserVo> getById(String id);

    /**
     * 简单转账操作
     *
     * @param account 金额
     * @param fromId  转出用户id
     * @param toId    转入用户id
     * @return 服务响应
     */
    ServiceResp transferAccount(BigDecimal account, String fromId, String toId);
}
