package edu.ucsb.cs.cs185.bryannaphan.fundguy;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class BudgetDetailsActivity extends AppCompatActivity
        implements SetBudgetDialog.BudgetEditListener {

    // Listener for isNew
    public void onEditReturnValue(float budget) {
        TextView budget_text = (TextView) findViewById(R.id.text_budget);
        budget_text.setText(String.format("%.2f", Budget.getInstance().getBudget()));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget_details);

        // Tool bar set up
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar bar = getSupportActionBar();
        bar.setDisplayHomeAsUpEnabled(true);
        bar.setTitle("Budget Details");

        Button button = (Button) findViewById(R.id.edit_budget);
        //FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getSupportFragmentManager();
                SetBudgetDialog fragment = new SetBudgetDialog();
                //fragment.setTargetFragment(BudgetDetails.this, 300);
                fragment.show(fm, "Get Fragment");
            }
        });

        TextView budget_text = (TextView) findViewById(R.id.text_budget);
        budget_text.setText(String.format("%.2f", Budget.getInstance().getBudget()));

    }

    // Toolbar stuff
    @Override
    public boolean onOptionsItemSelected(android.view.MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}