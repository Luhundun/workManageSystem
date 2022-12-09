package com.lu.workManageSystem.pojo.vo;

import com.lu.workManageSystem.pojo.Work;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @ClassName: StudentWorkInfo
 * @Description:
 * @Author: luning
 * @Date: 2021/11/10 19:31
 * @Version: v1.0
 */

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentWorkInfo extends Work {
    private Long wid;

    private String cid;

    private String sid;

    private Boolean isSubmit;

    private String url;

    private Integer score;

    private Boolean isJudge;

    private String info;
    private String name;
}
