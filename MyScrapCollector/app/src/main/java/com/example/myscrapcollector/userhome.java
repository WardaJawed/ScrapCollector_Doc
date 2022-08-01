package com.example.myscrapcollector;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class userhome extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userhome);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.nav_view);
        navigationView .setNavigationItemSelectedListener(this);
    //    navigationView .setNavigationItemSelectedListener(this::onNavigationItemSelected);//calling

        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();

    }

    public boolean onNavigationItemSelected(MenuItem item)
    {
        selectDrawerItem(item);
        return true;
    }
    public  void selectDrawerItem(MenuItem menu)
    {
        Fragment fragment = null;
        Class fragmentclass;
        switch (menu.getItemId())
        {
            case R.id.menuitem1:
               fragmentclass=UserHomeFragment.class;

                break;
            case R.id.menuitem2:
                fragmentclass=user_services.class;
                break;
            case R.id.menuitem3:
                fragmentclass= user_appoint.class;
                break;
            case R.id.menuitem4:
                fragmentclass= user_ratelist.class;
                break;
//            case R.id.menuitem5:
//                fragmentclass= MyAccountFragment.class;
//                break;
            case R.id.menuitem6:
                fragmentclass= user_login.class;
                break;
            default:
                fragmentclass=UserHomeFragment.class;

        }
        try {
            fragment = (Fragment) fragmentclass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flcontent, fragment).commit();
        // Highlight the selected item has been done by NavigationView
        menu.setChecked(true);
        // Set action bar title
        setTitle(menu.getTitle());
        // Close the navigation drawer
        drawerLayout.closeDrawers();


    }
}