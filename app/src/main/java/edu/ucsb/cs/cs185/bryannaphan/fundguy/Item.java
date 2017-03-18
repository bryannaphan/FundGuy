package edu.ucsb.cs.cs185.bryannaphan.fundguy;

/**
 * Created by bryannaphan on 3/15/17.
 */

public class Item {

    private String title;
    private float amount;

    private String description;
    private String category;

    public Item(String title, float amount, String description, String category) {
        this.title = title;
        this.amount = amount;
        this.description = description;
        this.category = category;
    }

    public void setNewDetails(String newTitle, String newDescription, float newAmount) {
        title = newTitle;
        description = newDescription;
        amount = newAmount;
    }

    public String getTitle() { return title; }

    public float getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() { return category; }

}
