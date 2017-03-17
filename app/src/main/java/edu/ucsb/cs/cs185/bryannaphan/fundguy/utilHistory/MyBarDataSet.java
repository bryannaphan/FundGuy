package edu.ucsb.cs.cs185.bryannaphan.fundguy.utilHistory;

/**
 * Created by georgelieu on 3/15/17.
 */

import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.List;

public class MyBarDataSet extends BarDataSet {

    public MyBarDataSet(List<BarEntry> yVals, String label) {
        super(yVals, label);
    }

    @Override
    public int getColor(int index) {
        float indexVal = getEntryForXIndex(index).getVal();

        if (indexVal <= 60)
            return mColors.get(0);
        else
            return mColors.get(1);

    }
}
