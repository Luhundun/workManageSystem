package com.lu.workManageSystem;


import com.lu.workManageSystem.mapper.StudentCourseMapper;
import com.lu.workManageSystem.mapper.TeacherMapper;
import com.lu.workManageSystem.pojo.Teacher;
import com.lu.workManageSystem.pojo.vo.StudentWorkInfo;
import com.lu.workManageSystem.service.WorkService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class MybatisplusApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private TeacherMapper teacherMapper;

    @Test
    void mybatisplus(){
//        List teachers = teacherMapper.selectList(null);
//        teachers.forEach(System.out::println);

//        Teacher teacher = new Teacher("4","7","龙大红","4783124091@163.com","13976442184");

        Teacher teacher=new Teacher();
        teacher.setPassword("3");
        teacher.setName("李三红");
        teacherMapper.insert(teacher);
    }

    @Autowired
    private StudentCourseMapper studentCourseMapper;
    @Resource
    WorkService workService;

    @Test
    void test11(){
//        List res = studentCourseMapper.getChoosedCourseInfo("19218104");
//        res.forEach(System.out::println);
        List<StudentWorkInfo> studentWorkInfoList = workService.getStudentWorkInfoList("1");
        studentWorkInfoList.forEach(System.out::println);
    }

}

