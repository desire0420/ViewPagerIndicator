package com.shizhefei.indicator.tabmain;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.shizhefei.indicator.demo.R;
//不使用预加载
public class TextFragment extends Fragment {
    TextView textView;
    private ProgressBar progressBar;

    public static TextFragment newInstance(String text) {
        TextFragment TextFragment = new TextFragment();
        Bundle bundle = new Bundle();
        bundle.putString("text", text);
        TextFragment.setArguments(bundle);
        return TextFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_common, container, false);
        textView = (TextView) view.findViewById(R.id.textView);
        textView.setText(getArguments().getString("text"));
        progressBar = (ProgressBar) view.findViewById(R.id.fragment_mainTab_item_progressBar);
        handler.sendEmptyMessageDelayed(1, 2000);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
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
