package com.lu.workManageSystem.service;

import com.lu.workManageSystem.mapper.StudentMapper;
import com.lu.workManageSystem.mapper.TeacherMapper;
import com.lu.workManageSystem.pojo.Student;
import com.lu.workManageSystem.pojo.Teacher;
import com.lu.workManageSystem.utils.AssertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

/**
 * @ClassName: LoginService
 * @Description:
 *
 * 1.检查id是否存在并从数据库获取相关信息
 * 2.核对密码是否正确
 * 3.提交登录结果给控制器
 * 4.
 * 5.
 * 6.
 *
 * @Author: luning
 * @Date: 2021/11/8 13:28
 * @Version: v1.0
 */

@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    TeacherMapper teacherMapper;

    @Autowired
    StudentMapper studentMapper;

    public Teacher teacherLogin(String tid,String password) throws Exception {
        AssertUtil.isTureForLogin(StringUtils.isEmpty(tid),"用户id未填写");

        Teacher teacher = teacherMapper.selectById(tid);

        AssertUtil.isTureForLogin(teacher == null, "用户id不存在");
        assert teacher != null;
        System.out.println(teacher.getPassword());
        System.out.println(password);
        AssertUtil.isTureForLogin(!teacher.getPassword().equals(password),"用户密码错误");
        return teacher;
    }

    public Student studentLogin(String sid,String password) throws Exception {
        AssertUtil.isTureForLogin(StringUtils.isEmpty(sid),"用户id未填写");

        Student student = studentMapper.selectById(sid);

        AssertUtil.isTureForLogin(student == null, "用户id不存在");
        assert student != null;
        System.out.println(student.getPassword());
        System.out.println(password);
        AssertUtil.isTureForLogin(!student.getPassword().equals(password),"用户密码错误");
        return student;
    }
}
