package edu.ucsb.cs.cs185.bryannaphan.fundguy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final ImageView mainIcon = (ImageView) findViewById(R.id.mainIcon);


        final Button loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(LoginActivity.this, MainActivity.class);
                //myIntent.putExtra("key", value); //Optional parameters
                LoginActivity.this.startActivity(myIntent);
            }
        });
    }
}
