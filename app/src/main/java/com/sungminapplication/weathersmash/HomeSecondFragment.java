package com.sungminapplication.weathersmash;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

public class HomeSecondFragment extends Fragment {

    public static HomeSecondFragment homeSecondFragment = new HomeSecondFragment();
    public static HomeSecondFragment getInstance(){
        return homeSecondFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home2, container, false);
        Button bt_rain = (Button) view.findViewById(R.id.rain_button);
        final LinearLayout page_rain = (LinearLayout) view.findViewById(R.id.rain_percentage);
        bt_rain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (page_rain.getVisibility() == View.GONE) {
                    page_rain.setVisibility(View.VISIBLE);
                } else {
                    page_rain.setVisibility(View.GONE);
                }
            }
        });
        return view;
    }
}
