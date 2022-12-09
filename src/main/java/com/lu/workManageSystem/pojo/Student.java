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
public class Student extends Model<Student> {

    private static final long serialVersionUID = 1L;

      @TableId(value = "sid", type = IdType.ASSIGN_ID)
    private String sid;

    private String password;

    private String name;

    private String email;

    private String gender;
    private String school;
    private String college;
    private String banji;


    @Override
    protected Serializable pkVal() {
        return this.sid;
    }

}
