package com.example.demo.obj;

import com.influxdb.annotations.Column;
import com.influxdb.annotations.Measurement;
import lombok.Data;

@Data
@Measurement(name = "mem")
public class mem {
    @Column(tag = true)
    private String host;
    @Column
    private Double used_percent;
    @Column
    private Double price;

}
