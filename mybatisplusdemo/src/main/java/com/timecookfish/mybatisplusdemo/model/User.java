package com.timecookfish.mybatisplusdemo.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 用户类
 *
 * @author HappyGhost
 * @create 2019-08-18 20:31
 **/
@Data
@TableName("user")
public class User {


    private Long id;

    private String name;

    private Integer age;

    private String email;

    private Long managerId;

    private Date createTime;

    @TableField(exist = false)
    private  String remark;




}
