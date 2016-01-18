package com.forthtv.adapter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.forthtv.R;
import com.forthtv.controller.WatchVideoActivity;
import com.forthtv.model.VideoData;
import com.forthtv.util.IntentUtil;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by cuongvo on 1/12/16.
 */
public class LiveVideoAdapter extends RecyclerView.Adapter<LiveVideoAdapter.ViewHolder> {
    private Context mContext;
    private List<VideoData> mList;

    public LiveVideoAdapter(Context context, List<VideoData> list) {
        this.mContext = context;
        this.mList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = (LayoutInflater) parent
                .getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.adapter_video_live, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final VideoData videoData = mList.get(position);
        videoData.setVideoPath("/sdcard/myvideo.mp4");
        Picasso.with(mContext).load(videoData.getImageId()).into(holder.mImageViewThumbnail);
        holder.mImageViewThumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("VideoData",videoData);
                mContext.startActivity(IntentUtil.createIntentWithBundle((Activity) mContext,
                        WatchVideoActivity.class,
                        IntentUtil.NavigationUtil.OPEN_WATCH_VIDEO.getAction(),bundle));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mImageViewThumbnail;

        public ViewHolder(View itemView) {
            super(itemView);
            this.mImageViewThumbnail = (ImageView) itemView.findViewById(R.id.adapter_video_live_thumbnail);

        }
    }
}
