package com.example.demo.h2;

import com.example.demo.mapper.h2mapper;
import com.example.demo.obj.h2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class test {

    @Autowired
    private h2mapper h2mapper;

    @Test
    public void test1(){
        List<h2> h2s = h2mapper.selectList(null);
        System.out.println(h2s);

    }
}
