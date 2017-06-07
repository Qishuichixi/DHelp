package com.qishui.zhou.assesshomedemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * 作者：Created by zhou on 2017/6/7 21:23
 * 邮箱：qishuichixi@126.com
 * 版本：V 1.0
 * 描述：
 */

public class RecommendFrament extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        TextView tv = new TextView(getActivity());
        tv.setText("发现");
        return tv;
    }
}
