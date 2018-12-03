package com.sungminapplication.weathersmash;

import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bnv;
    ViewPager fragmentScreen;
    Toolbar toolbar;
    DrawerLayout burgerItem;
    NavigationView navi;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer_main);
        fragmentScreen = (ViewPager) findViewById(R.id.mainFragmentScreen);
        bnv = (BottomNavigationView) findViewById(R.id.mainBottomNavi);
        toolbar = (Toolbar) findViewById(R.id.mainToolbar);
        burgerItem = findViewById(R.id.toolbarDrawer);
        navi= findViewById(R.id.drawerNavi);
        toolbar.setTitle("");
        ViewpagerSetting();
        BottomNaviSetting();
        DrawerNaviSetting();
        LogoutButton();
    }

    public void DrawerNaviSetting(){
        setSupportActionBar(toolbar);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.toolbar_menu);
        navi.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                burgerItem.closeDrawers();
                switch (menuItem.getItemId()){
                    case R.id.drawerItem1:
                        Toast.makeText(getApplicationContext(), "item1", Toast.LENGTH_SHORT).show();
                        return true;

                    case R.id.drawerItem2:
                        Toast.makeText(getApplicationContext(), "item2", Toast.LENGTH_SHORT).show();
                        return true;

                    case R.id.drawerItem3:
                        Toast.makeText(getApplicationContext(), "item3", Toast.LENGTH_SHORT).show();
                        return true;

                    case R.id.drawerItem4:
                        Toast.makeText(getApplicationContext(), "item4", Toast.LENGTH_SHORT).show();
                        return true;

                    default:
                        return true;
                }
            }
        });
    }

    public void LogoutButton(){
        Button bt_logout = findViewById(R.id.logoutButton);
        bt_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "로그아웃 버튼", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.item_toolbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home:
                burgerItem.openDrawer(GravityCompat.START);
                break;

            case R.id.searchh_icon:
                Toast.makeText(getApplicationContext(), "김현구 바보", Toast.LENGTH_SHORT).show();
                break;

            case R.id.etcItem1:
                Toast.makeText(getApplicationContext(), "김현구 바보", Toast.LENGTH_SHORT).show();
                break;

            case R.id.etcItem2:
                Toast.makeText(getApplicationContext(), "김현구 바보", Toast.LENGTH_SHORT).show();
                break;

            case R.id.etcItem3:
                Toast.makeText(getApplicationContext(), "김현구 바보", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void ViewpagerSetting(){
        fragmentScreen.setAdapter(new ViewpagerAdopter(getSupportFragmentManager()));
        fragmentScreen.setCurrentItem(0);

        fragmentScreen.setOffscreenPageLimit(3);

        fragmentScreen.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
                bnv.getMenu().getItem(i).setChecked(true);
            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    public void BottomNaviSetting(){
        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.fragmentItem1:
                        fragmentScreen.setCurrentItem(0);
                        break;

                    case R.id.fragmentItem2:
                        fragmentScreen.setCurrentItem(1);
                        break;

                    case R.id.fragmentItem3:
                        fragmentScreen.setCurrentItem(2);
                        break;
                }
                return false;
            }
        });
    }
}
