package com.linechart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    //x轴坐标对应的数据
    private List<String> xValue = new ArrayList<>();
    //y轴坐标对应的数据
    private List<Integer> yValue = new ArrayList<>();
    //折线对应的数据
    private Map<String, Integer> value = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (int i = 0; i < 31; i++) {
            xValue.add((i + 1) + "日");
            value.put((i + 1) + "日", (int) (Math.random() * 20 + 20));//60--240
        }

        for (int i = 0; i < 8; i++) {
            if (i == 6) {
                yValue.add(150);
            } else if (i == 7) {
                yValue.add(200);
            } else {
                yValue.add(i * 20);
            }
        }

        ChartView chartView = (ChartView) findViewById(R.id.chartview);
        chartView.setValue(value, xValue, yValue);
        chartView.setSelectIndex(8);//索引点
        chartView.setMonth("11月");
    }
}

