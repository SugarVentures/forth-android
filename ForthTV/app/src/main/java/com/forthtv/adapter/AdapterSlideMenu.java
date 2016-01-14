package com.forthtv.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.forthtv.R;
import com.forthtv.controller.AuthenticationActivity;
import com.forthtv.controller.SearchActivity;
import com.forthtv.util.IntentUtil;

/**
 * Created by cuongvo on 1/13/16.
 */
public class AdapterSlideMenu extends RecyclerView.Adapter<AdapterSlideMenu.SlideMenuViewHolder>{
    private Context mContext;
    private String[] mMenuItems;

    public AdapterSlideMenu(Context context, String[] menuItems){
        this.mContext = context;
        this.mMenuItems = menuItems;

    }

    @Override
    public SlideMenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = (LayoutInflater) parent
                .getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (viewType == 1) {
            View itemLayout = layoutInflater.inflate(R.layout.view_slide_menu_item, parent, false);
            return new SlideMenuViewHolder(mContext, itemLayout, viewType);
        } else if (viewType == 0) {
            View itemHeader = layoutInflater.inflate(R.layout.view_slide_menu_header, parent, false);
            return new SlideMenuViewHolder(mContext, itemHeader, viewType);
        }

        return null;
    }

    @Override
    public void onBindViewHolder(SlideMenuViewHolder holder, int position) {
        if(position!=0){
            holder.mTextViewMenuOption.setText(mMenuItems[position - 1]);
        }
    }

    @Override
    public int getItemCount() {
        return mMenuItems.length + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if(position==0){
            return 0;
        } else {
            return 1;
        }
    }

    public class SlideMenuViewHolder extends RecyclerView.ViewHolder{
        Context mContext;
        TextView mTextViewMenuOption;

        TextView mTextViewSignIn;
        TextView mTextViewRegister;
        TextView mTextViewSearch;

        public SlideMenuViewHolder(Context context, View drawerItem, int itemType){
            super(drawerItem);

            this.mContext = context;

            if (itemType == 1) {
                mTextViewMenuOption = (TextView) drawerItem.findViewById(R.id.view_slide_menu_item_option);
            } else if (itemType == 0) {
                mTextViewSearch = (TextView)drawerItem.findViewById(R.id.view_slide_menu_search);
                mTextViewSearch.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mContext.startActivity(IntentUtil.createIntent((Activity) mContext
                                , SearchActivity.class
                                , IntentUtil.NavigationUtil.OPEN_SEARCH.getAction()));
                    }
                });
                mTextViewSignIn = (TextView)drawerItem.findViewById(R.id.view_slide_menu_signin);
                mTextViewSignIn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mContext.startActivity(IntentUtil.createIntent((Activity) mContext
                                , AuthenticationActivity.class
                                , IntentUtil.NavigationUtil.OPEN_SIGNIN.getAction()));
                    }
                });

                mTextViewRegister = (TextView)drawerItem.findViewById(R.id.view_slide_menu_register);
                mTextViewRegister.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mContext.startActivity(IntentUtil.createIntent((Activity) mContext
                                , AuthenticationActivity.class
                                , IntentUtil.NavigationUtil.OPEN_REGISTER.getAction()));
                    }
                });
            }
        }
    }

}
