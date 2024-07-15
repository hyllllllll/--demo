package com.example.demo.obj;

import com.influxdb.annotations.Measurement;
import lombok.Data;

@Data
@Measurement(name = "student")
public class student {
    private String name;
    private String height;
    private String id;
}
