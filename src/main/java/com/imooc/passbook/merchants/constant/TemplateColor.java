package com.imooc.passbook.merchants.constant;

/**
 * 优惠券的背景颜色
 * 枚举类
 */
public enum TemplateColor {

    RED(1,"红色"),
    GREEN(2,"绿色"),
    BLUE(3,"蓝色");

    // 颜色代码
    private Integer code;

    // 颜色描述
    private String color;

    TemplateColor(Integer code, String color) {
        this.code = code;
        this.color = color;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getColor() {
        return this.color;
    }
}

