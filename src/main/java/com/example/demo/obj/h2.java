package com.example.demo.obj;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "test")
public class h2 {
    private Integer id;
    private String name;
}
