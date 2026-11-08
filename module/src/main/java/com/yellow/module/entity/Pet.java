package com.yellow.module.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * 宠物表
 */
@Data
@TableName("pet")
@Accessors(chain = true)
public class Pet {

    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 宠物名称
     */
    private String petName;

    /**
     * 多张照片url，用$分隔
     */
    private String photos;

    /**
     * 品种
     */
    private String variety;

    /**
     * 价格
     */
    private Float price;

    /**
     * 宠物详情介绍
     */
    private String detail;

    /**
     * 创建时间
     */
    private Integer createTime;

    /**
     * 修改时间
     */
    private Integer updateTime;

    /**
     * 逻辑删除：0未删除，1已删除
     */
    @TableLogic
    private Integer isDeleted;

    public static void sey(){
        System.out.println("-------嘿嘿------");
    }

}
