package com.xxx.licy.user.controller;

import com.xxx.licy.user.service.UserService;
import com.xxx.licy.userdb.api.model.QueryResp;
import com.xxx.licy.userdb.api.model.ServiceResp;
import com.xxx.licy.userdb.api.model.UserVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * 用户管理
 *
 * @author lichenyang
 * @since 2023/11/22 20:20
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/getById")
    QueryResp<UserVo> getById(@RequestParam("id") String id) {
        return userService.getById(id);
    }

    @PostMapping("/transferAccount")
    ServiceResp transferAccount(@RequestParam("account") BigDecimal account,
                                @RequestParam("fromId") String fromId,
                                @RequestParam("toId") String toId) {
        return userService.transferAccount(account, fromId, toId);
    }
}
