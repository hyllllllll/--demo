package com.example.demo.influxdb;

import com.example.demo.mapper.studentMapper;
import com.influxdb.client.InfluxDBClientOptions;
import com.influxdb.client.internal.InfluxDBClientImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class studentTest {
    @Autowired
    private studentMapper studentMapper;

    @Test
    public void aVoid(){
        InfluxDBClientImpl influxDBClient = new InfluxDBClientImpl(InfluxDBClientOptions.builder().build());
        System.out.println(influxDBClient.ping());

    }
}
