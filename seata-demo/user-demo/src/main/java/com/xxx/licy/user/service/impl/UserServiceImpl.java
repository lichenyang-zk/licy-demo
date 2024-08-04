package com.xxx.licy.user.service.impl;

import com.xxx.licy.user.service.UserService;
import com.xxx.licy.userdb.api.client.UserClient;
import com.xxx.licy.userdb.api.exception.BusinessException;
import com.xxx.licy.userdb.api.model.QueryResp;
import com.xxx.licy.userdb.api.model.ServiceResp;
import com.xxx.licy.userdb.api.model.UserVo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * 余额服务接口实现类
 *
 * @author lichenyang
 * @since 2023/11/22 20:09
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    private static final String LIMIT_AMOUNT = "1000";

    @Resource
    private UserClient userClient;

    @Override
    public QueryResp<UserVo> getById(String id) {
        if (StringUtils.isBlank(id)) {
            throw new BusinessException("用户id为空");
        }
        return userClient.getById(id);
    }

    @Override
    public ServiceResp transferAccount(BigDecimal account, String fromId, String toId) {
        if (null == account) {
            throw new BusinessException("转账金额不能为空");
        }
        if (StringUtils.isAnyBlank(fromId, toId)) {
            throw new BusinessException("用户id为空");
        }
        // 转出
        QueryResp<UserVo> fromUserResp = userClient.getById(fromId);
        UserVo fromUser = fromUserResp.getResultObj();
        BigDecimal fromUserAmount = fromUser.getAmount();
        LOGGER.info("{}余额：{}元。", fromUser.getName(), fromUserAmount);
        BigDecimal newFromUserAmount = fromUserAmount.subtract(account);
        fromUser.setAmount(newFromUserAmount);
        userClient.updateById(fromUser);

        // 模拟转账失败
        if (fromUser.getAmount().compareTo(new BigDecimal(LIMIT_AMOUNT)) < 0) {
            throw new BusinessException("就剩一千啦，你可别转了");
        }

        // 转入
        QueryResp<UserVo> toUserResp = userClient.getById(toId);
        UserVo toUser = toUserResp.getResultObj();
        BigDecimal toUserAmount = toUser.getAmount();
        LOGGER.info("{}余额：{}元。", toUser.getName(), toUserAmount);
        BigDecimal newToUserAmount = toUserAmount.add(account);
        toUser.setAmount(newToUserAmount);
        userClient.updateById(toUser);

        LOGGER.info("{}成功向{}转账{}元。", fromUser.getName(), toUser.getName(), account);

        return new ServiceResp();
    }
}
