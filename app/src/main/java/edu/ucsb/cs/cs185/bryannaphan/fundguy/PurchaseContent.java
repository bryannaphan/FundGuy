package edu.ucsb.cs.cs185.bryannaphan.fundguy;

import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Danielle on 2/8/2017.
 */


public class PurchaseContent {
    //public static RecyclerView.Adapter<MainActivity.SimpleItemRecyclerViewAdapter.ViewHolder> adapter;
    public static final List<Reminder> ITEMS = new ArrayList<Reminder>();
    public static final Map<String, Reminder> ITEM_MAP = new HashMap<String, Reminder>();
    /**
     * Add a reminder to the list
     * @param item
     */
    public static void addItem(Reminder item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
        //adapter.notifyDataSetChanged();
    }

    public static void editItem(Reminder item,
                                String title,
                                Boolean mon,
                                Boolean tues,
                                Boolean wed,
                                Boolean thurs,
                                Boolean fri,
                                Boolean sat,
                                Boolean sun,
                                String time,
                                String description)
    {

        ITEM_MAP.put(item.id, item);
        item.update(title, mon, tues, wed, thurs, fri, sat, sun, time, description);
        //adapter.notifyDataSetChanged();
    }



    /**
     * Remove a reminder from the list
     * @param item
     */
    public static void removeItem(Reminder item) {
        ITEMS.remove(item);
        ITEM_MAP.remove(item.id);
        //adapter.notifyDataSetChanged();
    }

    /**

     * The reminder object (add fields as necessary)
     */
    public static class Reminder {
        public final String id;
        public String title;
        public static int count = 0;
        public boolean mon;
        public boolean tues;
        public boolean wed;
        public boolean thurs;
        public boolean fri;
        public boolean sat;
        public boolean sun;
        public String time;
        public String details;

        public void update(String title,
                           Boolean mon,
                           Boolean tues,
                           Boolean wed,
                           Boolean thurs,
                           Boolean fri,
                           Boolean sat,
                           Boolean sun,
                           String time,
                           String description){
            this.title = title;
            this.mon = mon;
            this.tues = tues;
            this.wed = wed;
            this.thurs = thurs;
            this.fri = fri;
            this.sat = sat;
            this.sun = sun;
            this.time = time;
            this.details = description;
        }

        public Reminder(String title, boolean mon, boolean tues, boolean wed, boolean thurs, boolean fri,
                        boolean sat, boolean sun, String time, String details) {
            id = count++ + "";
            this.title = title;
            this.mon = mon;
            this.tues = tues;
            this.wed = wed;
            this.thurs = thurs;
            this.fri = fri;
            this.sat = sat;
            this.sun = sun;
            this.time = time;
            this.details = details;
        }
    }
}








