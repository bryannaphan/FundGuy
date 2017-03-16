package edu.ucsb.cs.cs185.bryannaphan.fundguy;

/**
 * Created by bryannaphan on 3/15/17.
 */

public class Item {

    private String title;
    private float amount;
    private String description;

    public Item(String title, float amount, String description) {
        this.title = title;
        this.amount = amount;
        this.description = description;
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

}
