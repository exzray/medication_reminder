package com.zakirah.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationAdapter;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationViewPager;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.zakirah.myapplication.adapters.MainPagerAdapter;

public class MainActivity extends AppCompatActivity implements AHBottomNavigation.OnTabSelectedListener {

    // declare components
    private MainPagerAdapter mc_pagerAdapter;
    private AHBottomNavigationAdapter mc_navigationAdapter;

    // declare views
    private Toolbar mv_toolbar;
    private AHBottomNavigationViewPager mv_pager;
    private AHBottomNavigation mv_navigation;
    private FloatingActionButton mv_fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize
        mc_pagerAdapter = new MainPagerAdapter(getSupportFragmentManager());
        mc_navigationAdapter= new AHBottomNavigationAdapter(this, R.menu.main_navigation);

        // initialize views
        mv_toolbar = findViewById(R.id.my_toolbar);
        mv_pager = findViewById(R.id.pager);
        mv_navigation = findViewById(R.id.navigation);
        mv_fab= findViewById(R.id.fab);

        setupToolbar();
        setupPager();
        setupNavigation();
    }

    @Override
    public boolean onTabSelected(int position, boolean wasSelected) {
        mv_pager.setCurrentItem(position, true);

        if (position != 0) mv_fab.hide();
        else mv_fab.show();

        return true;
    }

    private void setupToolbar() {
        setSupportActionBar(mv_toolbar);
    }

    private void setupPager(){
        mv_pager.setAdapter(mc_pagerAdapter);
    }

    private void setupNavigation() {
        mv_navigation.setTitleState(AHBottomNavigation.TitleState.ALWAYS_SHOW);
        mv_navigation.setAccentColor(Color.parseColor("#F63D2B"));
        mv_navigation.setInactiveColor(Color.parseColor("#747474"));
        mv_navigation.setOnTabSelectedListener(this);

        mc_navigationAdapter.setupWithBottomNavigation(mv_navigation);
    }
}
