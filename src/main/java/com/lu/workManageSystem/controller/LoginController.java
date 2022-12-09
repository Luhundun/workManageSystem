package com.lu.workManageSystem.controller;

import com.lu.workManageSystem.exceptions.LoginsException;
import com.lu.workManageSystem.pojo.Student;
import com.lu.workManageSystem.pojo.Teacher;
import com.lu.workManageSystem.service.LoginService;
import com.lu.workManageSystem.utils.ResultInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @ClassName: LoginController
 * @Description:
 * @Author: luning
 * @Date: 2021/11/8 13:25
 * @Version: v1.0
 */

@Controller
@RequestMapping("/")
public class LoginController {

    @Resource
    LoginService loginService;


    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/teacherLogin")
    @ResponseBody
    public ResultInfo teacherLogin(String tid, String password,HttpSession session){
        ResultInfo resultInfo = new ResultInfo();

        try {
            Teacher teacher = loginService.teacherLogin(tid, password);
            resultInfo.setResult(teacher);
            resultInfo.setMessage("登录成功");
            session.setAttribute("teacher",teacher);
        }catch (LoginsException le){
            resultInfo.setCode(le.getCode());
            resultInfo.setMessage(le.getMessage());
        }catch (Exception e){
            resultInfo.setCode(500);
            resultInfo.setMessage("其他错误");
        }
        return resultInfo;
    }

    @PostMapping("/studentLogin")
    @ResponseBody
    public ResultInfo studentLogin(String sid, String password,HttpSession session){
        ResultInfo resultInfo = new ResultInfo();

        try {
            Student student = loginService.studentLogin(sid, password);
            resultInfo.setResult(student);
            resultInfo.setMessage("登录成功");
            session.setAttribute("student",student);
        }catch (LoginsException le){
            resultInfo.setCode(le.getCode());
            resultInfo.setMessage(le.getMessage());
        }catch (Exception e){
            resultInfo.setCode(500);
            resultInfo.setMessage("其他错误");
        }
        return resultInfo;
    }
}
