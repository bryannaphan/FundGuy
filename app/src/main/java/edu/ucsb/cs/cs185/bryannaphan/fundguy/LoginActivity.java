package edu.ucsb.cs.cs185.bryannaphan.fundguy;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Importing title font
//        TextView welcomeText = (TextView)findViewById(R.id.welcomeText);
//        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/Gradies.otf");
//        welcomeText.setTypeface(custom_font);

        final ImageView mainIcon = (ImageView) findViewById(R.id.mainIcon);

        final TextView loginText = (TextView) findViewById(R.id.loginText);
        final TextView passwordText = (TextView) findViewById(R.id.passwordText);

        final EditText loginEdit = (EditText) findViewById(R.id.loginEdit);
        final EditText passwordEdit = (EditText) findViewById(R.id.passwordEdit);


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
