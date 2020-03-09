package com.zakirah.myapplication.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.zakirah.myapplication.fragments.HomeFragment;
import com.zakirah.myapplication.fragments.MedicationFragment;
import com.zakirah.myapplication.fragments.ReportFragment;

import java.util.ArrayList;
import java.util.List;

public class MainPagerAdapter extends FragmentStatePagerAdapter {

    // declare components
    private final List<Fragment> mc_list;

    public MainPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);

        mc_list = new ArrayList<>();

        mc_list.add(new HomeFragment());
        mc_list.add(new MedicationFragment());
        mc_list.add(new ReportFragment());
        mc_list.add(new ProfileFragment());
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return mc_list.get(position);
    }

    @Override
    public int getCount() {
        return mc_list.size();
    }
}
