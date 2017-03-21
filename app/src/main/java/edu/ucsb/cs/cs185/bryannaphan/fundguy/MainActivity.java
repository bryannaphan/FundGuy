package edu.ucsb.cs.cs185.bryannaphan.fundguy;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ItemAdapter itemAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Getting Month
        Calendar cal = Calendar.getInstance();
        String month = String.format(Locale.US,"%tB",cal).toUpperCase();

        // Importing title font
        TextView monthText = (TextView)findViewById(R.id.month);
        // Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/Route159-BoldItalic.otf");
        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/nevis.ttf");
        monthText.setTypeface(custom_font);
        monthText.setText(month);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getSupportFragmentManager();
                AddItemFragment fragment = new AddItemFragment();
                fragment.show(fm, "Add Fragment");
            }
        });

        ListView lv = (ListView) findViewById(R.id.purchase_list);
        itemAdapter = new ItemAdapter(getBaseContext(), true);
        lv.setAdapter(itemAdapter);

        // Get item clicked in list view
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent,
                                    View view, int position, long id) {
                Item clickedItem = (Item) parent.getItemAtPosition(position);
                Toast.makeText(MainActivity.this,
                        "Clicked item:\n" +
                                clickedItem.getTitle() + ": " +
                                clickedItem.getDescription(),
                        Toast.LENGTH_SHORT).show();

                Intent detailsIntent = new Intent(MainActivity.this, DetailsActivity.class);

                // Pass in item info
                detailsIntent.putExtra("index", ItemManager.getInstance().getIndex(clickedItem));
                MainActivity.this.startActivity(detailsIntent);
            }}
        );

        // Navigation
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.home) {
            Intent myIntent = new Intent(MainActivity.this, MainActivity.class);
            //myIntent.putExtra("key", value); //Optional parameters
            MainActivity.this.startActivity(myIntent);
        }

        else if (id == R.id.budget) {
            // TODO: Not sure if working?
            Intent myIntent = new Intent(MainActivity.this, BudgetDetails.class);
            MainActivity.this.startActivity(myIntent);
            /*
            Fragment budgetFragment = new SetBudgetFragment();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction transaction = fm.beginTransaction();
            transaction.replace(R.id.content_main, budgetFragment); //Container -> R.id.contentFragment
            transaction.commit();
            */
        }

        else if (id == R.id.purchase_history) {
            Intent myIntent = new Intent(MainActivity.this, HistoryActivity.class);
            MainActivity.this.startActivity(myIntent);
        }

        else if (id == R.id.overview) {
            Intent myIntent = new Intent(MainActivity.this, OverviewActivity.class);
            MainActivity.this.startActivity(myIntent);
        }
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            return true;
    }

}
