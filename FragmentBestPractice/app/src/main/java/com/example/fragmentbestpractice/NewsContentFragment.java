package com.example.fragmentbestpractice;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by subaru on 2017/3/19.
 */

public class NewsContentFragment extends Fragment{
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        view = inflater.inflate(R.layout.news_content_frag,container,false);
        return view;
    }

    public void refresh(String newsTitle, String newsContent){
        View visibilityLayout = view.findViewById(R.id.visibility_layout);
        visibilityLayout.setVisibility(View.VISIBLE);
        TextView titleTextView = (TextView) view.findViewById(R.id.news_title);
        TextView contentTextView = (TextView) view.findViewById(R.id.news_content);
        titleTextView.setText(newsTitle); //刷新新闻标题
        contentTextView.setText(newsContent); //刷新新闻内容
    }
}
