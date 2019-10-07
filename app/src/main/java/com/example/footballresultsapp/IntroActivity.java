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

        showSkipButton(true);
        setProgressButtonEnabled(true);
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
    }
}
