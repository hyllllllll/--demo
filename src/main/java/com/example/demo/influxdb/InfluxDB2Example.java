package com.example.demo.influxdb;

import com.example.demo.obj.mem;
import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.InfluxDBClientFactory;
import com.influxdb.client.WriteApiBlocking;
import com.influxdb.client.domain.WritePrecision;
import com.influxdb.query.FluxRecord;
import com.influxdb.query.FluxTable;

import java.util.List;
import java.util.Map;

public class InfluxDB2Example {
    public static void main(final String[] args) {

        // You can generate an API token from the "API Tokens Tab" in the UI
        String token = "hPVOqhTVffEPD7NXVqXBwXGRkNWfrNkEt33f8kTVYJSOrJYvDaU-B2ov2sNWyLdJ6xylPIAFCBp6kP5ycEe9TQ==";
        String bucket = "demo";
        String org = "test";

        InfluxDBClient client = InfluxDBClientFactory.create("http://localhost:8086", token.toCharArray());

//        Option 1: Use InfluxDB Line Protocol to write data
//        String data = "mem,host=host11 used_percent=23.43234543";
//        WriteApiBlocking writeApi = client.getWriteApiBlocking();
//        writeApi.writeRecord(bucket, org, WritePrecision.NS, data);

//        Option 2: Use a Data Point to write data
//        Point point = Point.measurement("mem")
//                .addTag("host", "host33")
//                .addField("used_percent", 1.234);
//        WriteApiBlocking writeApi = client.getWriteApiBlocking();
//        writeApi.writePoint(bucket, org, point);


//        Option 3: Use POJO and corresponding class to write data
        mem mem = new mem();
        mem.setHost("host888");
//        mem.setUsed_percent(888.8);
        mem.setPrice(88.8);
        WriteApiBlocking writeApi = client.getWriteApiBlocking();
        writeApi.writeMeasurement(bucket, org, WritePrecision.NS, mem);


//        String query = "from(bucket: \"demo\") |> range(start: -1h)";
        String query = "from(bucket: \"demo\") |> range(start: -1h)";
        List<FluxTable> tables = client.getQueryApi().query(query, org);

        for (FluxTable table : tables) {
            for (FluxRecord record : table.getRecords()) {
//                System.out.println(record);
//                System.out.println(record.getValues().get("host"));
                Map<String, Object> values = record.getValues();
                values.forEach((key, value) -> {
                    System.out.println("Key = " + key + ", Value = " + value);

                });
                System.out.println();
            }
        }

    }
}


