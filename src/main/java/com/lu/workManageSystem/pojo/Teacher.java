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
 * @since 2021-11-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Teacher extends Model<Teacher> {

    private static final long serialVersionUID = 1L;

      @TableId(value = "tid", type = IdType.ASSIGN_ID)
    private String tid;

    private String password;

    private String name;

    private String email;

    private String phone;
    private String school;
    private String college;
    private String department;

    @Override
    protected Serializable pkVal() {
        return this.tid;
    }

}
