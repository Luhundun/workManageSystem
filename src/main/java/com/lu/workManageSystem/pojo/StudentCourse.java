package com.lu.workManageSystem.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
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
 * @since 2021-11-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class StudentCourse extends Model<StudentCourse> {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String sid;

    private String cid;

    private Integer grade;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
