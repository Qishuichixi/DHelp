package com.qishui.zhou.assesshomedemo.fragment;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

/**
 * 作者：Created by zhou on 2017/6/7 21:21
 * 邮箱：qishuichixi@126.com
 * 版本：V 1.0
 * 描述：
 */

public class FragmentFactory {
    public static Map<Integer, BaseFragment> map = new HashMap<Integer, BaseFragment>();

    public static BaseFragment createFragment(int position) {

        BaseFragment fragment = map.get(position);
        if (fragment == null) {
            Log.e("TAG", "创建一个新的Fragment了...");
            switch (position) {
                case 0:
                    fragment = new HomeFragment();
                    break;
                case 1:
                    fragment = new RecommendFrament();
                    break;
                case 2:
                    fragment = new TopicFragment();
                    break;
                case 3:
                    fragment = new MineFragment();
                    break;

            }
            if (fragment != null) {
                map.put(position, fragment);
            }
        }

        return fragment;
    }

}
