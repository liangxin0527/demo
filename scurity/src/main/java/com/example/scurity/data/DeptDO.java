package com.example.scurity.data;

import lombok.Data;

/**
 * @author wupeng
 * @title: DeptDO
 * @projectName thinkedge
 * @date 2019/5/20 10:31
 */

@Data
public class DeptDO extends BaseDO  {

    private String name;
    private String manager;
    private String phone;
    private String email;
    private String parentId;
    private String ancestors;
    private Integer level;
    private String ipAddress;
    private String province;
    private String city;
    private String description;

}
