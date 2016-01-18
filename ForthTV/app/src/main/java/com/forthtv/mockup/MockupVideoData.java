package com.forthtv.mockup;

import com.forthtv.R;
import com.forthtv.model.VideoData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by baongoc on 1/18/16.
 */
public class MockupVideoData {
    public static List<VideoData> getMockuVideo(){
        List<VideoData> list = new ArrayList<>();
        VideoData videoData1 = new VideoData();
        videoData1.setImageId(R.drawable.streamlist_1);
        list.add(videoData1);

        VideoData videoData2 = new VideoData();
        videoData2.setImageId(R.drawable.streamlist_2);
        list.add(videoData2);

        VideoData videoData3 = new VideoData();
        videoData3.setImageId(R.drawable.streamlist_3);
        list.add(videoData3);

        VideoData videoData4 = new VideoData();
        videoData4.setImageId(R.drawable.streamlist_4);
        list.add(videoData4);

        VideoData videoData5 = new VideoData();
        videoData5.setImageId(R.drawable.streamlist_5);
        list.add(videoData5);

        VideoData videoData6 = new VideoData();
        videoData6.setImageId(R.drawable.streamlist_6);
        list.add(videoData6);

        VideoData videoData7 = new VideoData();
        videoData7.setImageId(R.drawable.streamlist_7);
        list.add(videoData7);

        VideoData videoData8 = new VideoData();
        videoData8.setImageId(R.drawable.streamlist_8);
        list.add(videoData8);

        VideoData videoData9 = new VideoData();
        videoData9.setImageId(R.drawable.streamlist_9);
        list.add(videoData9);

        VideoData videoData10 = new VideoData();
        videoData10.setImageId(R.drawable.streamlist_10);
        list.add(videoData10);

        return list;
    }
}
