package com.forthtv;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;

import com.forthtv.adapter.SlideMenuAdapter;
import com.forthtv.controller.RecordActivity;
import com.forthtv.controller.fragment.VideoLiveFragment;
import com.forthtv.util.IntentUtil;
import com.forthtv.util.view.AppToolbar;

public class MainActivity extends BaseActivity {
    private static final int CONTAINER_LAYOUT = R.id.activity_main_content;

    private String[] mStringsMenuItems;
    private DrawerLayout mDrawerLayout;
    private RecyclerView mRecyclerViewSlideMenu;
    private SlideMenuAdapter mSlideMenuAdapter;

    private AppToolbar mAppToolbar;
    private VideoLiveFragment videoLiveFragment;

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
        mSlideMenuAdapter = new SlideMenuAdapter(this, mStringsMenuItems);
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
                startActivityForResult(IntentUtil.createIntent(MainActivity.this
                        , RecordActivity.class
                        , IntentUtil.NavigationUtil.OPEN_RECORD.getAction()), IntentUtil.NavigationUtil.OPEN_RECORD.getId());
            }
        });
        mAppToolbar.setTitle("STREAMING VIDEO LIVE", true);

        openVideoLive();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == IntentUtil.NavigationUtil.OPEN_RECORD.getId()){

        }
        
    }

    public void openVideoLive() {
        videoLiveFragment = new VideoLiveFragment();
        openFragment(videoLiveFragment, CONTAINER_LAYOUT, BaseFragment.FragmentType.FRAGMENT_VIDEO_LIVE);
    }
}
