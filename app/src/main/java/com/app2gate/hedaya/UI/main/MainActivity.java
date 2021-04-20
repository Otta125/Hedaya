package com.app2gate.hedaya.UI.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;

import com.app2gate.hedaya.UI.Fragments.HomeFragment;
import com.app2gate.hedaya.UI.Fragments.ProgramsFragment;
import com.app2gate.hedaya.UI.Fragments.ProjectsFragment;
import com.app2gate.hedaya.UI.Fragments.SettingsFragment;
import com.app2gate.hedaya.R;
import com.app2gate.hedaya.viewmodels.PostInterface;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import net.time4j.android.ApplicationStarter;

public class MainActivity extends AppCompatActivity implements PostInterface,NavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;
    private Context context;

    final Fragment home = new HomeFragment();
    final Fragment Programs = new ProgramsFragment();
    final Fragment Projects = new ProjectsFragment();
    final Fragment Settings = new SettingsFragment();

    final FragmentManager fm = getSupportFragmentManager();
    Fragment active = home;

    @Override
    protected void onResume() {
        super.onResume();
        context = this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ApplicationStarter.initialize(this, true); // with prefetch on background thread
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        //bottom nav clear shadow background
        bottomNavigationView.setBackground(null);
        //bottom nav clear make the menu item that make space not clickable
        bottomNavigationView.getMenu().getItem(2).setEnabled(false);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        fm.beginTransaction().add(R.id.viewpager, Settings, "4").hide(Settings).commit();
        fm.beginTransaction().add(R.id.viewpager, Projects, "3").hide(Projects).commit();
        fm.beginTransaction().add(R.id.viewpager, Programs, "2").hide(Programs).commit();
        fm.beginTransaction().add(R.id.viewpager, home, "1")/*.hide(home)*/.commit();
    }

    private final BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {

                case R.id.nav_home:
                    fm.beginTransaction().hide(active).show(home).commit();
                    active = home;
                    HomeFragment fragment = (HomeFragment) getSupportFragmentManager().findFragmentByTag("1");
                    return true;
                case R.id.nav_edu_programs:
                    fm.beginTransaction().hide(active).show(Programs).commit();
                    active = Programs;
                    return true;

                case R.id.nav_projects:
                    fm.beginTransaction().hide(active).show(Projects).commit();
                    active = Projects;
                    return true;

                case R.id.nav_settings:
                    fm.beginTransaction().hide(active).show(Settings).commit();
                    active = Settings;
                    return true;
            }
            return false;
        }
    };

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

    @Override
    public void Load() {

    }

    @Override
    public void Dissmiss() {
        
    }
}