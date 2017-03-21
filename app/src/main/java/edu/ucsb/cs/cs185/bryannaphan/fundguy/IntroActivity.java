package edu.ucsb.cs.cs185.bryannaphan.fundguy;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;

public class IntroActivity extends AppIntro {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Note here that we DO NOT use setContentView();

        // Add your slide fragments here.
        // AppIntro will automatically generate the dots indicator and buttons.
        addSlide(LoginFragment.newInstance(R.layout.fragment_login));
        addSlide(SetBudgetFragment.newInstance(R.layout.fragment_set_budget));
        //addSlide(introdFragment.newInstance(R.layout.fragment_introd));
        addSlide(introdFragment.newInstance(R.layout.fragment_introd));//"slide title", "loonng description here", R.drawable.ic_arrow_back_white, getColor(R.color.colorAccent)));
        // OPTIONAL METHODS
        // Override bar/separator color.
        setBarColor(Color.parseColor("#506d56"));
        setSeparatorColor(Color.parseColor("#214429"));

        // Hide Skip/Done button.
        //showSkipButton(false);
        //setProgressButtonEnabled(false);

        // Turn vibration on and set intensity.
        // NOTE: you will probably need to ask VIBRATE permission in Manifest.
        setFadeAnimation();
        // setFlowAnimation(); // this is kinda cool too
        // setVibrate(true);
        // setVibrateIntensity(30);
    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        // Do something when users tap on Skip button.
        Intent mainIntent = new Intent(IntroActivity.this, MainActivity.class);
        startActivity(mainIntent);
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        // Do something when users tap on Done button.
        Intent mainIntent = new Intent(IntroActivity.this, MainActivity.class);
        startActivity(mainIntent);
    }

    @Override
    public void onSlideChanged(@Nullable Fragment oldFragment, @Nullable Fragment newFragment) {
        super.onSlideChanged(oldFragment, newFragment);
        // Do something when the slide changes.
    }
}