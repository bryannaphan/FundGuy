package edu.ucsb.cs.cs185.bryannaphan.fundguy;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
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

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar bar = getSupportActionBar();
        bar.setDisplayHomeAsUpEnabled(true);
        bar.setTitle("Purchase History");

        init();

        final List<BarEntry> entries = new ArrayList<>();
        int entriesCount = ItemManager.getInstance().getSize();
        int xPosition = 0;
        final List<Float> entriesID = new ArrayList<>();
        for (int i = 0; i < entriesCount; i++) {
            xPosition = i;
            entries.add(new BarEntry((float) xPosition, ((float) ItemManager.getInstance().get(i).getAmount())));
            entriesID.add((float) i);
        }

        BarDataSet set = new BarDataSet(entries, "Dollars Spent");
        BarData data = new BarData(set);
        data.setBarWidth(0.9f); // set custom bar width
        chart.setData(data);
        chart.setFitBars(true); // make the x-axis fit exactly all bars
        chart.invalidate(); // refresh
        chart.setVisibleXRangeMaximum(6f);
        chart.setScaleEnabled(false);
        chart.getXAxis().setEnabled(false);
        chart.getAxisRight().setEnabled(false);
        chart.getAxisLeft().setAxisMinimum(0);
        chart.animateXY(1000, 1000);

        TextView textView = (TextView) findViewById(R.id.entryInfo);
        textView.setText("Click on a bar to display information");
        textView.setTextSize(22);

        chart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {
                String entryTitle = ItemManager.getInstance().get(Math.round(e.getX())).getTitle();
                String entryDescription = ItemManager.getInstance().get(Math.round(e.getX())).getDescription();
                String entryCategory = ItemManager.getInstance().get(Math.round(e.getX())).getCategory();
                String entryDate = ItemManager.getInstance().get(Math.round(e.getX())).getDate();
                String entryInfo = "Title: " + entryTitle + "\n" + "Description: " + entryDescription + "\n" + "Category: " + entryCategory + "\n" + "Date: " + entryDate;

                TextView textView = (TextView) findViewById(R.id.entryInfo);
                textView.setText(entryInfo);
                textView.setTextSize(22);
            }

            @Override
            public void onNothingSelected() {
                //do nothing for now
                TextView textView = (TextView) findViewById(R.id.entryInfo);
                textView.setText("Click on a bar to display information");
                textView.setTextSize(22);
            }
        });

        final Button buttonMonth = (Button) findViewById(R.id.entriesMonth);
        final Button buttonEntry = (Button) findViewById(R.id.entries);

        buttonMonth.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                init();
                final List<BarEntry> entries = new ArrayList<>();
                int entriesCount = ItemManager.getInstance().getSize();
                int xPosition;

                entries.add(new BarEntry((float) 0, 23f));
                entries.add(new BarEntry((float) 1, 52f));
                entries.add(new BarEntry((float) 2, 17f));
                entries.add(new BarEntry((float) 3, 40f));
                entries.add(new BarEntry((float) 4, 62f));
                entries.add(new BarEntry((float) 5, 17f));
                entries.add(new BarEntry((float) 6, 110f));
                entries.add(new BarEntry((float) 7, 82f));

                BarDataSet set = new BarDataSet(entries, "Dollars Spent");
                BarData data = new BarData(set);
                data.setBarWidth(0.9f); // set custom bar width
                chart.setData(data);
                chart.setFitBars(true); // make the x-axis fit exactly all bars
                chart.invalidate(); // refresh
                chart.setVisibleXRangeMaximum(6f);
                chart.setScaleEnabled(false);
                chart.getXAxis().setEnabled(false);
                chart.getAxisRight().setEnabled(false);
                chart.getAxisLeft().setAxisMinimum(0);
                chart.animateXY(1000, 1000);

                chart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
                    @Override
                    public void onValueSelected(Entry e, Highlight h) {
                        TextView textView = (TextView) findViewById(R.id.entryInfo);
                        if (e == entries.get(0)) {
                            textView.setText("Date: March 14th, 2017" + "\n" + "Total Money Spent: $23 " + "\n" +
                                    "Purchases: Panda Express, Cardboard");
                            textView.setTextSize(22);
                        }
                        else if (e == entries.get(1)) {
                            textView.setText("Date: March 15th, 2017" + "\n" + "Total Money Spent: $52 " + "\n" +
                                    "Purchases: Birthday Present For Donny, Yerbamate");
                            textView.setTextSize(22);
                        }
                        else if (e == entries.get(2)) {
                            textView.setText("Date: March 16th, 2017" + "\n" + "Total Money Spent: $17 " + "\n" +
                                    "Purchases: Dress Shirt, Tie");
                            textView.setTextSize(22);
                        }
                        else if (e == entries.get(3)) {
                            textView.setText("Date: March 17th, 2017" + "\n" + "Total Money Spent: $40 " + "\n" +
                                    "Purchases: Bed Frame, Hana Kitchen");
                            textView.setTextSize(22);
                        }
                        else if (e == entries.get(4)) {
                            textView.setText("Date: March 18th, 2017" + "\n" + "Total Money Spent: $62 " + "\n" +
                                    "Purchases: Groceries Trader Joes, Movies");
                            textView.setTextSize(22);
                        }
                        else if (e == entries.get(5)) {
                            textView.setText("Date: March 19th, 2017" + "\n" + "Total Money Spent: $17 " + "\n" +
                                    "Purchases: Balloons, Candles, Cake");
                            textView.setTextSize(22);
                        }
                        else if (e == entries.get(6)) {
                            textView.setText("Date: March 20th, 2017" + "\n" + "Total Money Spent: $110 " + "\n" +
                                    "Purchases: Disneyland Tickets");
                            textView.setTextSize(22);
                        }
                        else if (e == entries.get(7)) {
                            textView.setText("Date: March 21st, 2017" + "\n" + "Total Money Spent: $82 " + "\n" +
                                    "Purchases: New Speakers, laptop case");
                            textView.setTextSize(22);
                        }
                    }
                    @Override
                    public void onNothingSelected() {
                        //do nothing for now
                        TextView textView = (TextView) findViewById(R.id.entryInfo);
                        textView.setText("Click on a bar to display information");
                        textView.setTextSize(22);
                    }
                });
            }
        });


        buttonEntry.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                init();

                final List<BarEntry> entries = new ArrayList<>();
                int entriesCount = ItemManager.getInstance().getSize();
                int xPosition = 0;
                final List<Float> entriesID = new ArrayList<>();
                for (int i = 0; i < entriesCount; i++) {
                    xPosition = i;
                    entries.add(new BarEntry((float) xPosition, ((float) ItemManager.getInstance().get(i).getAmount())));
                    entriesID.add((float) i);
                }

                BarDataSet set = new BarDataSet(entries, "Dollars Spent");
                BarData data = new BarData(set);
                data.setBarWidth(0.9f); // set custom bar width
                chart.setData(data);
                chart.setFitBars(true); // make the x-axis fit exactly all bars
                chart.invalidate(); // refresh
                chart.setVisibleXRangeMaximum(6f);
                chart.setScaleEnabled(false);
                chart.getXAxis().setEnabled(false);
                chart.getAxisRight().setEnabled(false);
                chart.getAxisLeft().setAxisMinimum(0);
                chart.animateXY(1000, 1000);

                TextView textView = (TextView) findViewById(R.id.entryInfo);
                textView.setText("Click on a bar to display information");

                chart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
                    @Override
                    public void onValueSelected(Entry e, Highlight h) {
                        String entryTitle = ItemManager.getInstance().get(Math.round(e.getX())).getTitle();
                        String entryDescription = ItemManager.getInstance().get(Math.round(e.getX())).getDescription();
                        String entryCategory = ItemManager.getInstance().get(Math.round(e.getX())).getCategory();
                        String entryDate = ItemManager.getInstance().get(Math.round(e.getX())).getDate();
                        String entryInfo = "Title: " + entryTitle + "\n" + "Description: " + entryDescription + "\n" + "Category: " + entryCategory + "\n" + "Date: " + entryDate;

                        TextView textView = (TextView) findViewById(R.id.entryInfo);
                        textView.setText(entryInfo);
                        textView.setTextSize(22);
                    }

                    @Override
                    public void onNothingSelected() {
                        //do nothing for now
                        TextView textView = (TextView) findViewById(R.id.entryInfo);
                        textView.setText("Click on a bar to display information");
                        textView.setTextSize(22);
                    }
                });
            }
        });
    }


    private void init() {
        chart = (BarChart) findViewById(R.id.chart);
    }

}