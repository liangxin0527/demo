package com.example.scurity.data;

import lombok.Data;

import java.io.Serializable;
import java.util.List;


@Data
public class RoleDO extends BaseDO implements Serializable {

    private String nameEn;
    private String name;
    private String description;
    private String descriptionEn;
    private List<PermDO> perms;

}
