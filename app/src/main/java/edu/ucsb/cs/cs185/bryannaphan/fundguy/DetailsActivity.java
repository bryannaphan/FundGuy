package edu.ucsb.cs.cs185.bryannaphan.fundguy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Bundle extras = getIntent().getExtras();
        String title = extras.getString("title");
        String description = extras.getString("description");
        Float amount = extras.getFloat("amount");
        String category = extras.getString("category");
        // Image image = extras.get ???

        TextView titleView = (TextView) findViewById(R.id.titleDetail);
        titleView.setText(title);

        // TODO: Get the amount to print with two decimal places
        TextView amountView = (TextView) findViewById(R.id.amountDetail);
        amountView.setText(amount.toString());
        // amount.setText(String.format("%.2f", amount));


        TextView descriptionView = (TextView) findViewById(R.id.descriptionDetail);
        descriptionView.setText(description);

        TextView categoryView = (TextView) findViewById(R.id.categoryDetail);
        categoryView.setText(category);

        // ImageView image = (ImageView) findViewById(R.id.imageView); //??
        // image.setImageBitmap(ItemManager.getInstance().get(position).getBitmap()); // ??

    }
}
