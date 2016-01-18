package com.forthtv.controller.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.forthtv.BaseFragment;
import com.forthtv.R;
import com.forthtv.adapter.LiveVideoAdapter;
import com.forthtv.mockup.MockupVideoData;

/**
 * Created by baongoc on 1/18/16.
 */
public class VideoLiveFragment extends BaseFragment {
    private LiveVideoAdapter mLiveVideoAdapter;
    private RecyclerView mRecyclerViewVideoList;

    public VideoLiveFragment() {
        mFragmentType = FragmentType.FRAGMENT_VIDEO_LIVE;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        mRecyclerViewVideoList = (RecyclerView)view.findViewById(R.id.fragment_video_live_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerViewVideoList.setLayoutManager(linearLayoutManager);

        getVideoLiveList();

        return view;
    }

    private void getVideoLiveList(){
        // For demo, do not call to the server yet.
        mLiveVideoAdapter = new LiveVideoAdapter(mContext, MockupVideoData.getMockuVideo());
        mRecyclerViewVideoList.setAdapter(mLiveVideoAdapter);
        mLiveVideoAdapter.notifyDataSetChanged();
    }
}
