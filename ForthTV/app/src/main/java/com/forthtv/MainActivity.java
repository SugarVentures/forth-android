package com.forthtv;

import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;

import com.forthtv.adapter.AdapterSlideMenu;
import com.forthtv.controller.RecordActivity;
import com.forthtv.util.IntentUtil;
import com.forthtv.util.view.AppToolbar;

public class MainActivity extends BaseActivity {

    private String[] mStringsMenuItems;
    private DrawerLayout mDrawerLayout;
    private RecyclerView mRecyclerViewSlideMenu;
    private AdapterSlideMenu mSlideMenuAdapter;

    private AppToolbar mAppToolbar;

    public MainActivity() {
        mActivityType = ActivityType.ACTIVITY_MAIN;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.activity_main_slide_menu);

        mRecyclerViewSlideMenu = (RecyclerView) findViewById(R.id.activity_main_slide_menu_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerViewSlideMenu.setLayoutManager(linearLayoutManager);

        mStringsMenuItems = getResources().getStringArray(R.array.array_slide_menu);
        mSlideMenuAdapter = new AdapterSlideMenu(this, mStringsMenuItems);
        mRecyclerViewSlideMenu.setAdapter(mSlideMenuAdapter);

        mAppToolbar = (com.forthtv.util.view.AppToolbar) findViewById(R.id.activity_main_toolbar);
        mAppToolbar.setActionLeftImage(R.drawable.icon_menu);
        mAppToolbar.setActionRightImage(R.drawable.icon_createstream);
        mAppToolbar.displayActionLeft(true);
        mAppToolbar.displayActionRight(true);
        mAppToolbar.getImageViewActionLeft().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.openDrawer(Gravity.LEFT);
            }
        });
        mAppToolbar.getImageViewActionRight().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(IntentUtil.createIntent(MainActivity.this
                        , RecordActivity.class
                        , IntentUtil.NavigationUtil.OPEN_RECORD.getAction()));
            }
        });
        mAppToolbar.setTitle("STREAMING VIDEO LIVE", true);
    }
}
