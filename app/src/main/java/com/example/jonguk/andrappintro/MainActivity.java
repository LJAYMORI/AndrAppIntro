package com.example.jonguk.andrappintro;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final float[] ANIMATION_TIMES = new float[]{
            0f,
            0.3333f,
            0.6666f,
            1f,
            1f
    };

    private LottieAnimationView mLottieAnimView;

    private CustomViewPager mViewPager;
    private PagerAdapter mPageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLottieAnimView = (LottieAnimationView) findViewById(R.id.lottie_animation_view);

        mViewPager = (CustomViewPager) findViewById(R.id.view_pager);
        mViewPager.setScrollDurationFactor(3);
        mViewPager.setAdapter(createPageAdapter());
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                setAnimationProgress(position, positionOffset);
            }

            @Override
            public void onPageSelected(int position) {}

            @Override
            public void onPageScrollStateChanged(int state) {}

        });

    }

    private PagerAdapter createPageAdapter() {
        if (mPageAdapter == null) {
            List<Fragment> list = new ArrayList<>();
            int length = ANIMATION_TIMES.length - 1;
            for (int i = 0; i < length; i++) {
                Bundle args = new Bundle();
                args.putString(IntroFragment.KEY_TITLE, "Title! - " + i);
                IntroFragment introFragment = new IntroFragment();
                introFragment.setArguments(args);
                list.add(introFragment);
            }
            mPageAdapter = new IntroPageAdapter(getSupportFragmentManager(), list);
        }

        return mPageAdapter;
    }

    private void setAnimationProgress(int position, float positionOffset) {
        float startProgress = ANIMATION_TIMES[position];
        float endProgress = ANIMATION_TIMES[position + 1];

        mLottieAnimView.setProgress(lerp(startProgress, endProgress, positionOffset));
    }

    private float lerp(float startValue, float endValue, float offset) {
        return startValue + offset * (endValue - startValue);
    }
}
