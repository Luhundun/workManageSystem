package com.lu.workManageSystem.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.lu.workManageSystem.pojo.Course;
import com.lu.workManageSystem.pojo.Teacher;
import com.lu.workManageSystem.pojo.Work;
import com.lu.workManageSystem.pojo.vo.StudentCourseInfo;
import com.lu.workManageSystem.pojo.vo.StudentWorkInfo;
import com.lu.workManageSystem.service.CourseService;
import com.lu.workManageSystem.service.StudentCourseService;
import com.lu.workManageSystem.service.WorkService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Collection;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lu
 * @since 2021-11-06
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Resource
    CourseService courseService;
    @Resource
    StudentCourseService studentCourseService;
    @Resource
    WorkService workService;
    //教师主页
    @RequestMapping("/main")
    public String toMain(){
        return "redirect:/teacher/course";
    }

    //教师设置
    @RequestMapping("/profile")
    public String toProfile(){
        return "teacher-profile";
    }

    //注销
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("teacher");
        return "redirect:/login";
    }

    //前往管理课程页面
    @RequestMapping("/course")
    public String getIntoCourses(HttpSession session,Model model){
        Teacher teacher = (Teacher) session.getAttribute("teacher");

        //构造mp条件
        QueryWrapper<Course> wrapper = new QueryWrapper<Course>();
        wrapper.eq("tid",teacher.getTid());

        Collection<Course> courseList = courseService.list(wrapper);
        model.addAttribute("courseList",courseList);
        return "teacher-course-table";
    }

    //查看某一课程的学生列表
    @RequestMapping("/course/{cid}/student")
    public String getCourseStudent(@PathVariable("cid") String cid, HttpSession session, Model model){
        Teacher teacher = (Teacher) session.getAttribute("teacher");

        //如果教师没有权限教授这门课，去错误页面

        QueryWrapper<Course> wrapper = new QueryWrapper<Course>();
        wrapper.eq("cid",cid);

        Collection<StudentCourseInfo> studentCourseInfos = studentCourseService.getTeaStudentCourseInfo(cid);
        model.addAttribute("studentCourseInfos",studentCourseInfos);

        Course course = courseService.getById(cid);
        model.addAttribute("course",course);
        return "course-student-table";
    }

    //查看某一课程的上传作业列表
    @RequestMapping("/course/{cid}/work")
    public String getCourseWork(@PathVariable("cid") String cid, HttpSession session, Model model){
        Teacher teacher = (Teacher) session.getAttribute("teacher");

        //如果教师没有权限教授这门课，去错误页面

        QueryWrapper<StudentWorkInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("cid",cid);
        //向前台直接传递作业记录表
        Collection<StudentWorkInfo> studentWorkInfos = workService.getStudentWorkInfoList(cid);
        model.addAttribute("studentWorkInfos",studentWorkInfos);

        Course course = courseService.getById(cid);
        model.addAttribute("course",course);
        session.setAttribute("course",course);
        return "teacher-work-table";
    }

    //教师给学生作业打分
    @PostMapping("/{wid}")
    public String judgeWork(@PathVariable("wid") Long wid, @RequestParam("workScore") Integer score,
                            HttpSession session){
        Work work = new Work();
        work.setWid(wid);
        work.setScore(score);

        //如果教师没有权限教授这门课，去错误页面
        Course course = (Course)session.getAttribute("course");

        workService.saveOrUpdate(work);
        return "redirect:/teacher/course/"+course.getCid()+"/work";
    }
}

