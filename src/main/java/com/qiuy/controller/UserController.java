package com.qiuy.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by admin on 2019/12/9.
 */
@Controller
@RequestMapping("/userInfo")
public class UserController {
    /**
     * 用户查询.
     * @return
     */
    @RequestMapping("/userList")
  //  @RequiresPermissions("userInfo:view")//权限管理
    public String userInfo(){
        return "stuInfo";
    }

    /**
     * 用户添加;
     * @return
     */
    @RequestMapping("/userAdd")
    @RequiresPermissions("userInfo:add")//权限管理
    public String userInfoAdd(){
        return "userInfoAdd";
    }
    /**
     * 用户删除;
     * @return
     */
    @RequestMapping("/userDel")
    @RequiresPermissions("userInfo:del")//权限管理;
    public String userDel(){
        return "userInfoDel";
    }
}
