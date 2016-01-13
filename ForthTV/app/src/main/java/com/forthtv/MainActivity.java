package com.forthtv;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.forthtv.adapter.SlideMenuAdapter;

public class MainActivity extends BaseActivity {
    private String[] mStringsMenuItems;
    private DrawerLayout mDrawerLayout;
    private RecyclerView mRecyclerViewSlideMenu;
    private SlideMenuAdapter mSlideMenuAdapter;

    public MainActivity() {
        mActivityType = ActivityType.ACTIVITY_MAIN;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mDrawerLayout =(DrawerLayout)findViewById(R.id.activity_main_slide_menu);

        mRecyclerViewSlideMenu = (RecyclerView)findViewById(R.id.activity_main_slide_menu_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerViewSlideMenu.setLayoutManager(linearLayoutManager);

        mStringsMenuItems = getResources().getStringArray(R.array.array_slide_menu);
        mSlideMenuAdapter = new SlideMenuAdapter(this, mStringsMenuItems);
        mRecyclerViewSlideMenu.setAdapter(mSlideMenuAdapter);

    }
}
