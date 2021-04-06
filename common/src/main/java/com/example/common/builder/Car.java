package com.example.common.builder;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Car {

	/**
	 * 名称
	 */
    private String name;
	/**
	 * 品牌 LOGO
	 */
	private String logo;
	/**
	 * 轮胎
	 */
    private String tires;
	/**
	 * 座椅
	 */
	private String seat;
	/**
	 * 屏幕
	 */
    private String screen;

}
