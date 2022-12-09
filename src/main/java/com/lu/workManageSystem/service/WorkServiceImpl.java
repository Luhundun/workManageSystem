package com.lu.workManageSystem.service;

import com.lu.workManageSystem.pojo.Work;
import com.lu.workManageSystem.mapper.WorkMapper;
import com.lu.workManageSystem.pojo.vo.StudentWorkInfo;
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
 * @since 2021-11-10
 */
@Service
public class WorkServiceImpl extends ServiceImpl<WorkMapper, Work> implements WorkService {
    @Autowired
    WorkMapper workMapper;

    @Override
    public List<StudentWorkInfo> getStudentWorkInfoList(String cid) {
        return workMapper.getStudentWorkInfoList(cid);
    }
}
