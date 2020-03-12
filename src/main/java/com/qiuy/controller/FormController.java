package com.qiuy.controller;

import com.qiuy.entity.MaintenanceForm;
import com.qiuy.service.MaintenanceFormService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
 * Created by admin on 2019/12/12.
 */
@Controller
@RequestMapping("/Form/*")
public class FormController {

   @Autowired
   private MaintenanceFormService maintenanceFormService;

    @RequestMapping("/list")
    @RequiresPermissions("Form:view")
    public ModelAndView list(HttpServletRequest request, Model model){
        String username=(String)request.getSession().getAttribute("loginId");
        if(username!=null){
           model.addAttribute("Formlist",maintenanceFormService.findAllByApplysusername(username));
            model.addAttribute("title","报修管理");
            return new ModelAndView("/maintenanceForm/list","FormModel",model );}
        else  return new ModelAndView("error");
    }
    @RequestMapping("/messageview")
    @RequiresPermissions("Form:messageview")
    public ModelAndView messageview(HttpServletRequest request, Model model){
        String username=(String)request.getSession().getAttribute("loginId");
        if(username!=null){
            model.addAttribute("Formlist",maintenanceFormService.findAllByApplysusername(username));
            model.addAttribute("title","查看留言");
            return new ModelAndView("/maintenanceForm/messageview","FormModel",model );}
        else  return new ModelAndView("error");
    }
    @RequestMapping("/statusview")
    @RequiresPermissions("Form:statusview")
    public ModelAndView statusview(HttpServletRequest request, Model model){
        String username=(String)request.getSession().getAttribute("loginId");
        if(username!=null){
            model.addAttribute("Formlist",maintenanceFormService.findAllByApplysusername(username));
            model.addAttribute("title","查看报修进度");
            return new ModelAndView("/maintenanceForm/statusview","FormModel",model );}
        else  return new ModelAndView("error");
    }
    @RequestMapping("/add")
    public String add(){
        return "/maintenanceForm/add";
    }
    @RequestMapping("/saveform")
    @RequiresPermissions("Form:add")
    public String saveform(HttpServletRequest request, Model model){
        String username=(String)request.getSession().getAttribute("loginId");
        if(username!=null){
            String computermodels=request.getParameter("computermodels");
            String problemcause=request.getParameter("problemcause");
            String applysphone=request.getParameter("applysphone");
            String worktime=request.getParameter("worktime");
            MaintenanceForm maintenanceForm =new MaintenanceForm();
            maintenanceForm.setApplysphone(applysphone);
            maintenanceForm.setApplysusername(username);
            maintenanceForm.setProblemcause(problemcause);
            maintenanceForm.setWorktime(worktime);
            maintenanceForm.setComputermodels(computermodels);
            maintenanceForm.setStatus("0");
            maintenanceForm.setLeavemessage(null);
            maintenanceFormService.saveMaintenanceForm(maintenanceForm);
            model.addAttribute("successMsg","添加报修单成功");
            return "success";
        }else{
            return "error";
        }
    }
    @GetMapping("{id}")
    public ModelAndView view (@PathVariable("id") Long id, Model model){
        MaintenanceForm maintenanceForm=maintenanceFormService.findByFormid(id);
        model.addAttribute("maintenanceForm",maintenanceForm);
        model.addAttribute("title","查看报修单");
        return new ModelAndView("/maintenanceForm/view","FormModel",model);
    }
    //删除单条报修单
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id,HttpServletRequest request,Model model){
        MaintenanceForm maintenanceForm=maintenanceFormService.findByFormid(id);
        String status=maintenanceForm.getStatus();
        if(status.equals("0")){
            maintenanceFormService.deleteByFormid(id);
            String username=(String)request.getSession().getAttribute("loginId");
            if(username!=null){
                model.addAttribute("Formlist",maintenanceFormService.findAllByApplysusername(username));
                model.addAttribute("title","报修管理");
                }
                return new ModelAndView("/maintenanceForm/list","FormModel",model );
        }else
            return new ModelAndView("/maintenanceForm/error");


    }
}
