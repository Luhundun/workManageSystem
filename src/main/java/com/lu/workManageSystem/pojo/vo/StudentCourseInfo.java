package com.lu.workManageSystem.pojo.vo;

import com.lu.workManageSystem.pojo.StudentCourse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @ClassName: StudentCourseInfo
 * @Description:
 * @Author: luning
 * @Date: 2021/11/9 14:48
 * @Version: v1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentCourseInfo extends StudentCourse {
    private Integer id;

    private String sid;

    private String cid;

    private Integer grade;
    private String name;
    private String college;
    private String banji;
    private String email;



}
