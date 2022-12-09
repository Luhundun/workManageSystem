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
 * @since 2021-11-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Work extends Model<Work> {

    private static final long serialVersionUID = 1L;

      @TableId(value = "wid", type = IdType.ASSIGN_ID)
    private Long wid;

    private String cid;

    private String sid;

    private Boolean isSubmit;

    private String url;

    private Integer score;

    private Boolean isJudge;

    private String info;


    @Override
    protected Serializable pkVal() {
        return this.wid;
    }

}
