package com.qiuy.controller;

import com.qiuy.entity.User;
import com.qiuy.service.UserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by admin on 2019/12/11.
 */
@Controller
@RequestMapping()
public class StudentController {
    @Autowired
    private UserService userService;
    @RequestMapping("/stuInfo")
    @RequiresPermissions("stInfo:view")
    public ModelAndView stuInfo(HttpServletRequest request, Model model){
        String stuid=(String)request.getSession().getAttribute("loginId");
        if(stuid!=null){
            User user=userService.findByUsername(stuid);
            model.addAttribute("stulist",user);
            return new ModelAndView("/stuInfo","studentModel",model );}
        else  return new ModelAndView("error");
    }
  @RequestMapping("/updateStudent")
  @RequiresPermissions("stInfo:update")
  public String  updateStudent( HttpServletRequest request, Model model) {
    String username=(String)request.getSession().getAttribute("loginId");
    String address=request.getParameter("address");
    String phone=request.getParameter("phone");
    String name=request.getParameter("name");
    String sex=request.getParameter("sex");
    if(userService.existsByusername(username)){
      User user=new User();
      user.setName(name);
      user.setAddress(address);
      user.setPhone(phone);
      user.setSex(sex);
      User source=userService.findByUsername(username);
      UpdateTool.copyNullProperties(source,user);
      userService.saveUser(user);
      model.addAttribute("successMsg","修改信息成功");
      return"success";
    }else{
      model.addAttribute("errorMsg",username);
      return "error";}
  }
  @RequestMapping("/success")
  public String success(){
    return "success";
  }

  @RequestMapping("/stuPwd")
  @RequiresPermissions("stPwd:update")
  public String stuPwd(){ return "stuPwd";}

  @RequestMapping("/updateStuPwd")
  public String updateStuPwd(HttpServletRequest request,Model model){
    String stupwd1=request.getParameter("newpwd1");
    String stupwd2=request.getParameter("newpwd2");
    if(stupwd1.equals(stupwd2)){
      User user=new User();
      user.setPassword(stupwd2);
      User source=userService.findByUsername((String)request.getSession().getAttribute("loginId"));
      UpdateTool.copyNullProperties(source,user);
      userService.saveUser(user);
      model.addAttribute("successMsg","修改密码成功");
      return "success";
    }
    else {
      model.addAttribute("errorMsg","1");
      return "/stuPwd";
    }
  }
  }
