package com.shizhefei.indicator.tabmain;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.shizhefei.fragment.LazyFragment;
import com.shizhefei.indicator.demo.R;

/**
 * Created by wangwei on 2016/10/19.
 * //使用预加载   点击fragment可见后才会加载数据
 */

public class YuLoadFragment extends LazyFragment {
    TextView textView;
    private ProgressBar progressBar;

    public static YuLoadFragment newInstance(String text) {
        YuLoadFragment YuLoadFragment = new YuLoadFragment();
        Bundle bundle = new Bundle();
        bundle.putString("text", text);
        YuLoadFragment.setArguments(bundle);
        return YuLoadFragment;
    }

    @Override
    protected void onCreateViewLazy(Bundle savedInstanceState) {
        super.onCreateViewLazy(savedInstanceState);
        setContentView(R.layout.fragment_common);
        textView = (TextView) findViewById(R.id.textView);
        textView.setText(getArguments().getString("text"));
        progressBar = (ProgressBar) findViewById(R.id.fragment_mainTab_item_progressBar);
        handler.sendEmptyMessageDelayed(1, 2000);
    }

    @Override
    protected void onDestroyViewLazy() {
        super.onDestroyViewLazy();
        handler.removeMessages(1);
    }

    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(android.os.Message msg) {
            textView.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.GONE);
        }

        ;
    };
}
