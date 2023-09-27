package com.owncloud.android.ui.zeus;


import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.ArrayList;

public class CustomFeaturesViewAdapter extends FragmentPagerAdapter {

    private final ArrayList<Integer> slideLayouts;

    public CustomFeaturesViewAdapter(FragmentManager fm, ArrayList<Integer> slideLayouts) {
        super(fm);
        this.slideLayouts = slideLayouts;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt("slideLayout", slideLayouts.get(position));
        SlideFragment fragment = new SlideFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return slideLayouts.size();
    }
}
