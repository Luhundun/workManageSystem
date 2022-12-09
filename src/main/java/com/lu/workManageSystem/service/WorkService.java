package com.lu.workManageSystem.service;

import com.lu.workManageSystem.pojo.Work;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lu.workManageSystem.pojo.vo.StudentWorkInfo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lu
 * @since 2021-11-10
 */
public interface WorkService extends IService<Work> {

    List<StudentWorkInfo> getStudentWorkInfoList(String cid);



}
