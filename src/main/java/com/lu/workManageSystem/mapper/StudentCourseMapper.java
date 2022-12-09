package com.lu.workManageSystem.mapper;

import com.lu.workManageSystem.pojo.StudentCourse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lu.workManageSystem.pojo.vo.ChoosedCourseInfo;
import com.lu.workManageSystem.pojo.vo.StudentCourseInfo;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lu
 * @since 2021-11-09
 */
@Repository
public interface StudentCourseMapper extends BaseMapper<StudentCourse> {
    @Select("SELECT sc.*,s.`name`,s.college,s.banji,s.email FROM student_course sc, student s " +
            "WHERE sc.sid=s.sid and sc.cid=#{cid}")
    List<StudentCourseInfo> getTeaStudentCourseInfo(String cid);

    @Select("SELECT sc.*,c.`name`,c.score,c.choose_sum,t.name as tname FROM student_course sc, course c,teacher t " +
            "WHERE sc.cid=c.cid and sc.sid=#{sid} and t.tid=c.tid")
    List<ChoosedCourseInfo> getChoosedCourseInfo(String sid);
}
