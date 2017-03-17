package edu.ucsb.cs.cs185.bryannaphan.fundguy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HistoryActivity extends AppCompatActivity {

    private BarChart chart;
    //private

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        init();

        Random r = new Random();
        List<Float> dataList = new ArrayList<>();
        dataList.add((float) 47);
        dataList.add((float) 68);
        dataList.add((float) 14);
        dataList.add((float) 45);
        dataList.add((float) 32);
        dataList.add((float) 28);
        dataList.add((float) 3);

        List<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(0f, 30f));
        entries.add(new BarEntry(1f, 80f));
        entries.add(new BarEntry(2f, 60f));
        entries.add(new BarEntry(3f, 50f));
        // gap of 2f
        entries.add(new BarEntry(5f, 70f));
        entries.add(new BarEntry(6f, 60f));

        BarDataSet set = new BarDataSet(entries, "BarDataSet");
        BarData data = new BarData(set);
        data.setBarWidth(0.9f); // set custom bar width
        chart.setData(data);
        chart.setFitBars(true); // make the x-axis fit exactly all bars
        chart.invalidate(); // refresh




        //for(int i = 0; i<20; i++){
        //dataList.add((float) (r.nextInt(300-25)+25));
        //}

        //BarData barData2 = new BarData(MPUtil.getXAxisValues(20), MPUtil.getDataSet(HistoryActivity.this, dataList));

        //BarData barData2 = new BarData( dataList);

        //MPUtil.getDataSet(HistoryActivity.this, dataList);
       // MPUtil.drawChart(HistoryActivity.this, chart, barData2);

        chart.animateXY(3000, 3000);
    }

    private void init() {
        chart = (BarChart) findViewById(R.id.chart);
    }



}
