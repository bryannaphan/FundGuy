package edu.ucsb.cs.cs185.bryannaphan.fundguy;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;


import org.w3c.dom.Text;

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
        final List<BarEntry> entries = new ArrayList<>();
        int entriesCount = ItemManager.getInstance().getSize();
        int xPosition = 0;
        final List<Float> entriesID = new ArrayList<>();
        for(int i = 0; i<entriesCount; i++) {
            xPosition = i;
            entries.add(new BarEntry((float)xPosition, ((float)ItemManager.getInstance().get(i).getAmount())));
            entriesID.add((float)i);
        }

        BarDataSet set = new BarDataSet(entries, "Dollars Spent");
        BarData data = new BarData(set);
        data.setBarWidth(0.9f); // set custom bar width
        chart.setData(data);
        chart.setFitBars(true); // make the x-axis fit exactly all bars
        chart.invalidate(); // refresh
        chart.setVisibleXRangeMaximum(6f);
        chart.setScaleEnabled(false);
        //chart.getAxisLeft().setDrawGridLines(false);
        //chart.getAxisRight().setDrawGridLines(false);
        //chart.getXAxis().setDrawGridLines(false);
        chart.getXAxis().setEnabled(false);
        //chart.getAxisLeft().setEnabled(false);
        chart.getAxisRight().setEnabled(false);

        chart.animateXY(3000, 3000);

        final Button buttonDay = (Button) findViewById(R.id.entriesDay);
        final Button buttonWeek = (Button) findViewById(R.id.entriesWeek);
        final Button buttonMonth = (Button) findViewById(R.id.entriesMonth);
        final Button buttonEntry = (Button) findViewById(R.id.entries);



        buttonDay.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //switch bar chart such that one bar = one day
                buttonDay.setBackgroundColor(Color.DKGRAY);
                buttonWeek.setBackgroundColor(Color.GRAY);
                buttonMonth.setBackgroundColor(Color.GRAY);
                buttonEntry.setBackgroundColor(Color.GRAY);
            }
        });

        buttonWeek.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //switch bar chart such that one bar = one day
                buttonDay.setBackgroundColor(Color.GRAY);
                buttonWeek.setBackgroundColor(Color.DKGRAY);
                buttonMonth.setBackgroundColor(Color.GRAY);
                buttonEntry.setBackgroundColor(Color.GRAY);
            }
        });

        buttonMonth.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //switch bar chart such that one bar = one day
                buttonDay.setBackgroundColor(Color.GRAY);
                buttonWeek.setBackgroundColor(Color.GRAY);
                buttonMonth.setBackgroundColor(Color.DKGRAY);
                buttonEntry.setBackgroundColor(Color.GRAY);
            }
        });

        buttonEntry.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //switch bar chart such that one bar = one day
                buttonDay.setBackgroundColor(Color.GRAY);
                buttonWeek.setBackgroundColor(Color.GRAY);
                buttonMonth.setBackgroundColor(Color.GRAY);
                buttonEntry.setBackgroundColor(Color.DKGRAY);

                List<BarEntry> entries = new ArrayList<>();
                int entriesCount = ItemManager.getInstance().getSize();
                int xPosition = 0;
                for(int i = 0; i<entriesCount; i++) {
                    xPosition = i;
                    entries.add(new BarEntry((float)xPosition, ((float)ItemManager.getInstance().get(i).getAmount())));
                }
                BarDataSet set = new BarDataSet(entries, "BarDataSet");
                BarData data = new BarData(set);
                data.setBarWidth(0.9f); // set custom bar width
                chart.setData(data);
                chart.setFitBars(true); // make the x-axis fit exactly all bars
                chart.invalidate(); // refresh
                chart.setVisibleXRangeMaximum(6f);
                chart.setScaleEnabled(false);
                chart.getXAxis().setEnabled(false);
                chart.getAxisRight().setEnabled(false);
            }
        });

        chart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {
                TextView textView = (TextView) findViewById(R.id.entryInfo);
                textView.setText(ItemManager.getInstance().get(Math.round(e.getX())).getTitle());
            }

            @Override
            public void onNothingSelected() {
                //do nothing for now
            }
        });


    }

    private void init() {
        chart = (BarChart) findViewById(R.id.chart);
    }



}
