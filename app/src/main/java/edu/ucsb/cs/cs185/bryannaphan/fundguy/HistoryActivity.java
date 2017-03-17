package edu.ucsb.cs.cs185.bryannaphan.fundguy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import edu.ucsb.cs.cs185.bryannaphan.fundguy.R;
import edu.ucsb.cs.cs185.bryannaphan.fundguy.utilHistory.MPUtil;


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
        for(int i = 0; i<20; i++){
            dataList.add((float) (r.nextInt(300-25)+25));
        }

        BarData barData2 = new BarData(MPUtil.getXAxisValues(20), MPUtil.getDataSet(HistoryActivity.this, dataList));

        MPUtil.getDataSet(HistoryActivity.this, dataList);
        MPUtil.drawChart(HistoryActivity.this, chart, barData2);

        chart.animateXY(3000, 3000);
    }

    private void init() {
        chart = (BarChart) findViewById(R.id.chart);
    }



}
