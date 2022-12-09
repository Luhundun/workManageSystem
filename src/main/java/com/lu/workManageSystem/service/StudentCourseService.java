package com.lu.workManageSystem.service;

import com.lu.workManageSystem.pojo.StudentCourse;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lu.workManageSystem.pojo.vo.ChoosedCourseInfo;
import com.lu.workManageSystem.pojo.vo.StudentCourseInfo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lu
 * @since 2021-11-09
 */
public interface StudentCourseService extends IService<StudentCourse> {
    List<StudentCourseInfo> getTeaStudentCourseInfo(String cid);

    List<ChoosedCourseInfo> getChoosedCourseInfo(String tid);
}
