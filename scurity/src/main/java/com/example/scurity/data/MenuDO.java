package com.example.scurity.data;

import lombok.Data;

import java.util.Date;

/**
 * @author wupeng
 * @title: MenuDO
 * @projectName thinkedge
 * @description: TODO
 * @date 2019/6/24 15:01
 */
@Data
public class MenuDO{

    private String id;

    private String name;
    private String icon;
    private String path;
    private String perms;
    private Boolean enabled;

    private String parentId;

    private Integer level;

    private Integer orderby;

    private String version;

    private String deleted;

    private Date createTime;
    private Date updateTime;
    private Date deleteTime;

}
