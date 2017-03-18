package edu.ucsb.cs.cs185.bryannaphan.fundguy;

import android.graphics.Bitmap;

/**
 * Created by bryannaphan on 3/15/17.
 */

public class Item {

    private String title;
    private float amount;
    private String description;
    private String category;
    private Bitmap bitmap;

    public Item(String title, float amount, String description, String category) {//}), Bitmap bitmap) {
        this.title = title;
        this.amount = amount;
        this.description = description;
        this.category = category;
        this.bitmap = bitmap;
    }

    public String getTitle() {
        return title;
    }

    public float getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() { return category; }

    public Bitmap getBitmap() { return bitmap; }

}
