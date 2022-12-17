package com.doudou.freechat.controllers;
 
import com.doudou.freechat.dao.UserDao;
import com.doudou.freechat.service.UserService;
import com.doudou.freechat.vo.UserVo;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/{id}")
    public UserVo getUserInfo(@PathVariable Long id) {

        UserDao userDao = userService.getUserInfoById(id);

        UserVo userVo = new UserVo();

        userVo.setUserName(userDao.getUserName());
        userVo.setPersonalitySign(userDao.getPersonalitySign());
        userVo.setId(userDao.getId());

        return userVo;
    }
}