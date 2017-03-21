package edu.ucsb.cs.cs185.bryannaphan.fundguy;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class BudgetDetails extends AppCompatActivity implements SetBudgetDialog.BudgetEditListener {
    public void onEditReturnValue(float budget){
        TextView budget_text = (TextView) findViewById(R.id.text_budget);
        budget_text.setText(String.format("%.2f", Budget.getInstance().getBudget()));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
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

}

//package edu.ucsb.cs.cs185.bryannaphan.fundguy;
//
//import android.app.Activity;
//import android.os.Bundle;
//import android.support.design.widget.CollapsingToolbarLayout;
//import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.Snackbar;
//import android.support.v4.app.Fragment;
//import android.support.v4.app.FragmentManager;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.Toolbar;
//import android.view.View;
//import android.widget.CheckBox;
//import android.widget.TextView;
//
//public class BudgetDetails extends Fragment implements SetBudgetDialog.BudgetEditListener {
//    public void onEditReturnValue(Budget budget){
//        TextView budget_text = (TextView) findViewById(R.id.text_budget);
//        budget_text.setText(String.format("%.2f", Budget.getInstance().getBudget()));
//
//    }
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_budget_details);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//
//
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                FragmentManager fm = getSupportFragmentManager();
//                SetBudgetDialog fragment = new SetBudgetDialog();
//                fragment.setTargetFragment(BudgetDetails.this, 300);
//                fragment.show(fm, "Get Fragment");
//            }
//        });
//        TextView budget_text = (TextView) findViewById(R.id.text_budget);
//        budget_text.setText(String.format("%.2f", Budget.getInstance().getBudget()));
//
//    }
//
//}
