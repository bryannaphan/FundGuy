package edu.ucsb.cs.cs185.bryannaphan.fundguy;
import android.content.ContentResolver;
import android.net.Uri;
import android.provider.MediaStore;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by bryannaphan on 3/15/17.
 */

public class ItemManager {

    private Item item;

    private static ArrayList<Item> itemslist;
    private static ItemManager instance = new ItemManager();
    public ItemManagerListener listener;

    public float totalSpent(){
        float sum = 0;
        for(int i = 0; i<itemslist.size(); i++){
            sum += itemslist.get(i).getAmount();
        }
        listener.onUpdate();
        return sum;
    }

    public static ItemManager getInstance() {
        if (instance == null)
            instance = new ItemManager();
        return instance;
    }


    public int getIndex(Item item){
        return itemslist.indexOf(item);
    }

    public int getSize(){
        return itemslist.size();
    }

    // Private constructor
    private ItemManager() {
        this.itemslist = new ArrayList<>();
        this.listener = new ItemManagerListener() {
            @Override
            public void onUpdate() {

            }
        };
    }

    public void add(Item item) {
        itemslist.add(item);
        listener.onUpdate();
    }

    public void removeItem(Item item){
        itemslist.remove(item);
        listener.onUpdate();
    }

    public void clear(Item item) {
        itemslist.clear();
        listener.onUpdate();
    }

    public Item get(int index) {
        return itemslist.get(index);
    }

    public void setListener(ItemManagerListener listener) {
        this.listener = listener;
    }

    public interface ItemManagerListener {
        public void onUpdate();
    }
}
