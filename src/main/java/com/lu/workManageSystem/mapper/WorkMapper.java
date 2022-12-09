package com.lu.workManageSystem.mapper;

import com.lu.workManageSystem.pojo.Work;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lu.workManageSystem.pojo.vo.StudentWorkInfo;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lu
 * @since 2021-11-10
 */
@Repository
public interface WorkMapper extends BaseMapper<Work> {
    @Select("SELECT w.*,s.name from work w,student s where w.sid=s.sid and w.cid='1'")
    List<StudentWorkInfo> getStudentWorkInfoList(String cid);
}
