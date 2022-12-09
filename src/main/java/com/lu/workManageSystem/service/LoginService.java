package com.lu.workManageSystem.service;

import com.lu.workManageSystem.pojo.Student;
import com.lu.workManageSystem.pojo.Teacher;

/**
 * @ClassName: LoginService
 * @Description:
 * @Author: luning
 * @Date: 2021/11/8 13:28
 * @Version: v1.0
 */
public interface LoginService {
    public Teacher teacherLogin(String tid, String password) throws Exception;
    public Student studentLogin(String sid, String password) throws Exception;
}
