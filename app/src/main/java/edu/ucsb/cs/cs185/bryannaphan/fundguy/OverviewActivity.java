package edu.ucsb.cs.cs185.bryannaphan.fundguy;
import android.icu.text.SelectFormat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by JZ on 3/15/17.
 */

public class OverviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Link elements from layout xml
        setContentView(R.layout.activity_overview);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);


        final PieChart pieChart = (PieChart) findViewById(R.id.chart);

        ArrayList<String> categories = new ArrayList<>();
        categories.add("Home & Utilities");
        categories.add("Food");
        categories.add("Transportation");
        categories.add("Treat Yo Self");
        categories.add("Other");


        float sumHome=0; float sumFood=0; float sumTrans=0; float sumTreat=0; float sumOther=0;

        // create a list of entries from the ListFragment
        final List<PieEntry> entries = new ArrayList<>();
        int entriesCount = ItemManager.getInstance().getSize();
        for(int i = 0; i<entriesCount; i++) {
            String entryCategory = ItemManager.getInstance().get(i).getCategory();
            if (entryCategory == categories.get(0))
                sumHome += ItemManager.getInstance().get(i).getAmount();
            else if (entryCategory == categories.get(1))
                sumFood += ItemManager.getInstance().get(i).getAmount();
            else if (entryCategory == categories.get(2))
                sumTrans += ItemManager.getInstance().get(i).getAmount();
            else if (entryCategory == categories.get(3))
                sumTreat += ItemManager.getInstance().get(i).getAmount();
            else {
                sumOther += ItemManager.getInstance().get(i).getAmount();
            }
        }

        if (sumHome != 0)
            entries.add(new PieEntry(sumHome,categories.get(0)));
        if (sumFood != 0)
            entries.add(new PieEntry(sumFood,categories.get(1)));
        if (sumTrans != 0)
            entries.add(new PieEntry(sumTrans,categories.get(2)));
        if (sumTreat != 0)
            entries.add(new PieEntry(sumTreat,categories.get(3)));
        if (sumOther != 0)
            entries.add(new PieEntry(sumOther,categories.get(4)));

        PieDataSet dataSet = new PieDataSet(entries, "");
        PieData data = new PieData(dataSet);

        // change the colors cause thats fun :D
        dataSet.setColors(ColorTemplate.JOYFUL_COLORS);
        pieChart.setData(data);
        pieChart.invalidate(); // refresh
    }
}
