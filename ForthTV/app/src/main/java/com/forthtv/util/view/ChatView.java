package com.forthtv.util.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.forthtv.R;

/**
 * Created by baongoc on 1/19/16.
 */
public class ChatView extends LinearLayout {
    private Context mContext;
    private RecyclerView mRecyclerViewMessageList;
    private EditText mEditTextMessage;
    private ImageView mImageViewSend;

    public ChatView(Context context) {
        super(context);
        initialize(context);
    }

    public ChatView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize(context);

    }

    public ChatView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize(context);

    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ChatView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initialize(context);

    }

    public void initialize(Context context){
        this.mContext = context;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.view_chat, this);
        mRecyclerViewMessageList = (RecyclerView)view.findViewById(R.id.view_chat_message_list);
        mImageViewSend = (ImageView)view.findViewById(R.id.view_chat_send);
        mImageViewSend.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

}
