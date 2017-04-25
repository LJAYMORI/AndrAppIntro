package com.example.jonguk.andrappintro;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Jonguk on 2017. 4. 24..
 */

public class IntroFragment extends Fragment {

    public static final String KEY_TITLE = "TITLE";

    private TextView mTitleView;
    private String mTitle;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Bundle args = getArguments();
        if (args != null) {
            mTitle = args.getString(KEY_TITLE, "Title!!");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_intro, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mTitleView = (TextView) view.findViewById(R.id.intro_title);
        mTitleView.setText(mTitle);
    }
}
