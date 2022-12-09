package com.lu.workManageSystem.service;

import com.lu.workManageSystem.pojo.StudentCourse;
import com.lu.workManageSystem.mapper.StudentCourseMapper;
import com.lu.workManageSystem.pojo.vo.ChoosedCourseInfo;
import com.lu.workManageSystem.pojo.vo.StudentCourseInfo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lu
 * @since 2021-11-09
 */
@Service
public class StudentCourseServiceImpl extends ServiceImpl<StudentCourseMapper, StudentCourse> implements StudentCourseService {
    @Autowired
    StudentCourseMapper studentCourseMapper;
    @Override
    public List<StudentCourseInfo> getTeaStudentCourseInfo(String cid) {
        return studentCourseMapper.getTeaStudentCourseInfo(cid);
    }

    @Override
    public List<ChoosedCourseInfo> getChoosedCourseInfo(String tid){
        return studentCourseMapper.getChoosedCourseInfo(tid);
    }
}
