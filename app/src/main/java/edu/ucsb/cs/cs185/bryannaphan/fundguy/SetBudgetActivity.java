package edu.ucsb.cs.cs185.bryannaphan.fundguy;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class SetBudgetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_budget);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // TODO: Make this actually set the amount!
        // It currently just opens a new intent to MainActivity
        Button setBudgetButton = (Button) findViewById(R.id.setBudgetButton);
        Intent mainIntent = new Intent(SetBudgetActivity.this, MainActivity.class);
        SetBudgetActivity.this.startActivity(mainIntent);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(SetBudgetActivity.this, MainActivity.class);
                SetBudgetActivity.this.startActivity(myIntent);

                Snackbar.make(view, "Budget has been successfully set", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
            }
        });
    }

}
