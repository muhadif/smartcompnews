package com.docotel.muhadif.third.ui.main;

import android.content.Intent;
import android.os.Bundle;

import com.docotel.muhadif.third.R;
import com.docotel.muhadif.third.base.BaseFragment;
import com.docotel.muhadif.third.ui.fragment.news.NewsFragment;
import com.docotel.muhadif.third.ui.fragment.profile.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentTransaction;

import android.os.Handler;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MainView{

    BottomNavigationView navView;
    boolean doubleBackToExitPressedOnce = false;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            BaseFragment fragment = null;
            String tag = "";
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragment = NewsFragment.newInstance();
                    tag = "HOME";
                    break;
                case R.id.navigation_profile:
                    fragment = ProfileFragment.newInstance();
                    tag = "PROFILE";
                    break;
            }

            if(fragment != null ) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fl_main, fragment, tag).commit();
            }

            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initBottomNavigation();

    }

    private void initBottomNavigation(){
        navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fl_main, NewsFragment.newInstance()).commit();
    }

    @Override
    public void onBackPressed() {
        if(navView.getSelectedItemId() != R.id.navigation_home) {
            navView.setSelectedItemId(R.id.navigation_home);
        } else {
            if (doubleBackToExitPressedOnce) {
                super.onBackPressed();
                return;
            }
            this.doubleBackToExitPressedOnce = true;
            Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    doubleBackToExitPressedOnce=false;
                }
            }, 2000);
        }



    }



    @Override
    public void initView() {

    }

    @Override
    public void initListener() {

    }

    @Override
    public void startTask() {

    }

    @Override
    public void finishedTask() {

    }

    @Override
    public void failureTask(String message) {

    }

    @Override
    public void info(String message) {

    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
    }
}
