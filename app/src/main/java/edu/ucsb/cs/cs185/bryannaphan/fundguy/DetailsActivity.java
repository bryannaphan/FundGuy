package edu.ucsb.cs.cs185.bryannaphan.fundguy;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity
        implements AddItemDialog.EditItemListener{

    public void onEditReturnValue(Item item) {
        TextView textTitle = (TextView) findViewById(R.id.titleDetail);
        textTitle.setText(item.getTitle());

        TextView textDescription = (TextView) findViewById(R.id.descriptionDetail);
        textDescription.setText(item.getDescription());

        TextView textCategory = (TextView) findViewById(R.id.categoryDetail);
        textCategory.setText(item.getCategory());

        TextView textAmount = (TextView) findViewById(R.id.amountDetail);
        textAmount.setText(String.format("%.2f", item.getAmount()));

        ImageView image = (ImageView) findViewById(R.id.imageView);
        image.setImageBitmap(item.getBitmap());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Bundle extras = getIntent().getExtras();
        final int index = extras.getInt("index");

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

        Button editButton = (Button) findViewById(R.id.editButton);
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getSupportFragmentManager();
                AddItemDialog f = new AddItemDialog();
                Bundle args = new Bundle();
                args.putBoolean("isNew", false);
                args.putInt("index", index);
                f.setArguments(args);
                f.show(fm, "Get Fragment");
            }
        });

        Button deleteButton = (Button) findViewById(R.id.deleteButton);
        deleteButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                ItemManager.getInstance().removeItem(ItemManager.getInstance().get(index));
                //refresh the listener sumhow
                finish();
            }
        });

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
