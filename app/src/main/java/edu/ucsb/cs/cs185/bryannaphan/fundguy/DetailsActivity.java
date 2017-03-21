package edu.ucsb.cs.cs185.bryannaphan.fundguy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Bundle extras = getIntent().getExtras();
        int index = extras.getInt("index");
        ItemManager im = ItemManager.getInstance();
        Item current = im.get(index);

        TextView titleView = (TextView) findViewById(R.id.titleDetail);
        titleView.setText(current.getTitle());

        TextView amountView = (TextView) findViewById(R.id.amountDetail);
        amountView.setText(String.format("%.2f", current.getAmount()));

        TextView descriptionView = (TextView) findViewById(R.id.descriptionDetail);
        descriptionView.setText(current.getDescription());

        TextView categoryView = (TextView) findViewById(R.id.categoryDetail);
        categoryView.setText(current.getCategory());

        ImageView image = (ImageView) findViewById(R.id.imageView);
        image.setImageBitmap(current.getBitmap());

    }

    /*
    // Toolbar back button
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }*/
}
