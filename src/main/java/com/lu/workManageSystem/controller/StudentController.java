package com.lu.workManageSystem.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lu.workManageSystem.pojo.*;
import com.lu.workManageSystem.pojo.vo.ChoosedCourseInfo;
import com.lu.workManageSystem.service.CourseService;
import com.lu.workManageSystem.service.StudentCourseService;
import com.lu.workManageSystem.service.WorkService;
import com.lu.workManageSystem.service.storage.StorageService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

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
@RequestMapping("/student")
public class StudentController {
    @Resource
    CourseService courseService;
    @Resource
    StudentCourseService studentCourseService;
    @Resource
    WorkService workService;
    @Resource
    StorageService storageService;


    @RequestMapping("/main")
    public String toMain(){
        return "redirect:/student/course/mine";
    }

    @RequestMapping("/profile")
    public String toProfile(){
        return "student-profile";
    }


    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("student");
        return "redirect:/login";
    }

    //前往管理课程页面
    @RequestMapping("/course/mine")
    public String getIntoCourses(HttpSession session, Model model){
        Student student = (Student) session.getAttribute("student");

        //获取学生选中课程的信息
        Collection<ChoosedCourseInfo> choosedCourseList = studentCourseService.getChoosedCourseInfo(student.getSid());
        model.addAttribute("choosedCourseList",choosedCourseList);
        return "student-course-table";
    }

    //前往某课程作业页面
    @RequestMapping("/course/{cid}/work")
    public String getCourseStudent(@PathVariable("cid") String cid, HttpSession session, Model model){
        Student student = (Student) session.getAttribute("student");

        //如果学生没有选这门课，去错误页面
        //···

        QueryWrapper<Work> wrapper = new QueryWrapper<>();
        wrapper.eq("cid",cid);
        wrapper.eq("sid",student.getSid());
        //向前台直接传递作业记录表
        Collection<Work> works = workService.list(wrapper);
        model.addAttribute("works",works);

        Course course = courseService.getById(cid);
        model.addAttribute("course",course);
        session.setAttribute("course",course);
        return "student-work-table";
    }

    //学生上传一个作业
    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                    HttpSession session) {
        //学生没有选中课程就报错

        Course course = (Course) session.getAttribute("course");
        Student student = (Student) session.getAttribute("student");
        //生成新的记录
        Work work = new Work();
        work.setSid(student.getSid());
        work.setCid(course.getCid());
        work.setUrl(file.getOriginalFilename());
        workService.save(work);
        storageService.prefixStore(file,work.getWid().toString());
        //重定向回选中课程作业管理界面
        return "redirect:/student/course/"+course.getCid()+"/work";
    }

    //学生删除一个作业
    @GetMapping("/delete/{fileName}")
    public String handleFileUpload(@PathVariable("fileName") String fileName, HttpSession session) {
        //学生没有选中课程就报错

        Course course = (Course) session.getAttribute("course");


        storageService.deleteFile(fileName);
        workService.removeById(fileName.substring(0,19));
        return "redirect:/student/course/"+course.getCid()+"/work";
    }
}

