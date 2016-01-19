package com.forthtv.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.forthtv.R;
import com.forthtv.model.MessageData;

import java.util.List;

/**
 * Created by cuongvo on 1/14/16.
 */
public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder>{
    private Context mContext;
    private List<MessageData> mMessageDataList;

    public ChatAdapter(Context context, List<MessageData> list){
        this.mContext = context;
        this.mMessageDataList = list;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = (LayoutInflater) parent
                .getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.adapter_chat, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MessageData messageData = mMessageDataList.get(position);

    }

    @Override
    public int getItemCount() {
        return mMessageDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mImageViewAvatar;
        TextView mTextViewMessage;

        public ViewHolder(View itemView) {
            super(itemView);
            this.mImageViewAvatar = (ImageView) itemView.findViewById(R.id.adapter_video_live_thumbnail);

        }
    }
}
