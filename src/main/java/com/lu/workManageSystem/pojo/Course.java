package com.lu.workManageSystem.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author lu
 * @since 2021-11-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Course extends Model<Course> {

    private static final long serialVersionUID = 1L;

      @TableId(value = "cid", type = IdType.ASSIGN_ID)
    private String cid;

    private String name;

    private String tid;

    private String info;

    private Integer learnTime;

    private Integer score;

    private LocalDate beginTime;

    private LocalDate endTime;

    private Integer chooseSum;


    @Override
    protected Serializable pkVal() {
        return this.cid;
    }

}
