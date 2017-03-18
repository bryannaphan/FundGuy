package edu.ucsb.cs.cs185.bryannaphan.fundguy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

/**
 * Created by JZ on 3/15/17.
 */

public class OverviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);

        final PieChart pieChart = (PieChart) findViewById(R.id.chart);

        ArrayList<PieEntry> entries = new ArrayList<PieEntry>();
        entries.add(new PieEntry(4f, "Fun"));
        entries.add(new PieEntry(8f, "Bills"));
        entries.add(new PieEntry(6f, "TreatYoSelf"));
        entries.add(new PieEntry(12f, "Booze"));
        entries.add(new PieEntry(18f, "Rent"));

        PieDataSet dataSet = new PieDataSet(entries, "# of calls");


        ArrayList<String> labels = new ArrayList<String>();
        labels.add("January");
        labels.add("February");
        labels.add("March");
        labels.add("April");
        labels.add("May");
        labels.add("June");

        PieData data = new PieData(dataSet);
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        pieChart.setData(data);

        pieChart.invalidate(); // refresh
    }
}
