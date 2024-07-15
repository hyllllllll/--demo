package com.example.demo.controller;

import com.example.demo.mapper.h2mapper;
import com.example.demo.obj.h2;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("h2")
@Api(value = "h2数据库")
public class h2Controller {
    @Autowired
    private h2mapper h2mapper;

    @ApiOperation(value = "获取h2数据库所有数据")
    @GetMapping
    public List<h2> getAll(){
        List<h2> h2s = h2mapper.selectList(null);
        return h2s;
    }

    @ApiOperation(value = "根据id查询")
    @ApiImplicitParam(value = "用户id", name = "id")
    @GetMapping("/{id}")
    public h2 getById(@PathVariable Integer id){
        h2 h2 = h2mapper.selectById(id);
        return h2;
    }

}
