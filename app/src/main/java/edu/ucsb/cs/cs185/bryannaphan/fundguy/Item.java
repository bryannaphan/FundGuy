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
    private float newAmountLeft;

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

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setBitmap(Bitmap image) {
        this.bitmap = image;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    /*
    public void setAmountLeft(float amount) { //???
        //newAmountLeft = (Budget.getInstance().getBudget() - ItemManager.getInstance().totalSpent());
        this.newAmountLeft = Budget.getInstance().getBudget() - amount;
    }

    public float getAmountLeft() {
        return this.newAmountLeft;
    }*/
}
