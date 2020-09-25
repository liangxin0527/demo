package com.example.scurity.data;

import lombok.Data;

import java.util.Date;

@Data
public class BaseDO {

	private String id;

	private String deleted;

	private Date createTime;
	private Date updateTime;
	private Date deleteTime;
}