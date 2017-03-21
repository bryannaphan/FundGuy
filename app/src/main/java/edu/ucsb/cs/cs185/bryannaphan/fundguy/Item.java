package edu.ucsb.cs.cs185.bryannaphan.fundguy;

import android.graphics.Bitmap;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by bryannaphan on 3/15/17.
 */

public class Item {

    private String title;
    private float amount;
    private String description;
    private String category;
    private Bitmap bitmap;
    private String date;

    public Item(String title, float amount, String description, String category, Bitmap bitmap) {
        this.title = title;
        this.amount = amount;
        this.description = description;
        this.category = category;
        Calendar cc = Calendar.getInstance();
        int year = cc.get(Calendar.YEAR);
        int month = cc.get(Calendar.MONTH) + 1;
        int mDay = cc.get(Calendar.DAY_OF_MONTH);
        this.date = month+"/"+mDay+"/"+year;
        this.bitmap = bitmap;
    }

    public String getTitle() {
        return title;
    }

    public float getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() { return category; }

    public Bitmap getBitmap() { return bitmap; }

}
