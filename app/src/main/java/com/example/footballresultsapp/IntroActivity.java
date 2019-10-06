package com.example.footballresultsapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;
import com.github.paolorotolo.appintro.model.SliderPage;

public class IntroActivity extends AppIntro {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setFadeAnimation();

        // Add your slide fragments here.
        // AppIntro will automatically generate the dots indicator and buttons.
        //addSlide(firstFragment);
        //addSlide(secondFragment);
        //addSlide(thirdFragment);
        //addSlide(fourthFragment);

        // Instead of fragments, you can also use our default slide.
        // Just create a `SliderPage` and provide title, description, background and image.
        // AppIntro will do the rest.
        SliderPage sliderPage = new SliderPage();
        sliderPage.setTitle("Welcome to Football-Results.");
        sliderPage.setDescription("Simple app to check current football statistics.");
        sliderPage.setImageDrawable(R.drawable.football_png);
        sliderPage.setBgColor(Color.parseColor("#3B5323"));
        addSlide(AppIntroFragment.newInstance(sliderPage));

        SliderPage sliderPage1 = new SliderPage();
        sliderPage1.setTitle("Results and schedules.");
        sliderPage1.setDescription("Find out team results and check out upcoming matches.");
        sliderPage1.setBgColor(Color.parseColor("#3B5323"));
        sliderPage1.setImageDrawable(R.drawable.football_game_png);
        addSlide(AppIntroFragment.newInstance(sliderPage1));

        SliderPage sliderPage2 = new SliderPage();
        sliderPage2.setTitle("Scores");
        sliderPage2.setDescription("Check out top scores on the field!");
        sliderPage2.setImageDrawable(R.drawable.score_icon);
        sliderPage2.setBgColor(Color.parseColor("#3B5323"));
        addSlide(AppIntroFragment.newInstance(sliderPage2));

        // OPTIONAL METHODS
        // Override bar/separator color.
        //setBarColor(Color.parseColor("#3F51B5"));
        //setSeparatorColor(Color.parseColor("#2196F3"));

        // Hide Skip/Done button.
        showSkipButton(true);
        setProgressButtonEnabled(true);

        // Turn vibration on and set intensity.
        // NOTE: you will probably need to ask VIBRATE permission in Manifest.
        //setVibrate(true);
        //setVibrateIntensity(30);
    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        Intent mainActivityIntent = new Intent(this, MainActivity.class);
        startActivity(mainActivityIntent);
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        Intent mainActivityIntent = new Intent(this, MainActivity.class);
        startActivity(mainActivityIntent);
    }

    @Override
    public void onSlideChanged(@Nullable Fragment oldFragment, @Nullable Fragment newFragment) {
        super.onSlideChanged(oldFragment, newFragment);
        // Do something when the slide changes.
        //mainActivityIntent();
    }
}
