package com.qishui.zhou.assesshomedemo;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.qishui.zhou.assesshomedemo.fragment.FragmentFactory;

public class FirstActivity extends AppCompatActivity {

    public static final int[] mTabRes = new int[]{R.drawable.tab_home_selector, R.drawable.tab_discovery_selector, R.drawable.tab_attention_selector, R.drawable.tab_profile_selector};
    public static final int[] mTabResPressed = new int[]{R.mipmap.ic_tab_strip_icon_feed_selected, R.mipmap.ic_tab_strip_icon_category_selected, R.mipmap.ic_tab_strip_icon_pgc_selected, R.mipmap.ic_tab_strip_icon_profile_selected};
    public static final String[] mTabTitle = new String[]{"首页", "发现", "关注", "我的"};


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        initView();
    }

    private void initView() {

        final ViewPager vp = (ViewPager) findViewById(R.id.id_vp);
        FragmentPagerAdapter mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public int getCount() {
                return mTabTitle.length;
            }

            @Override
            public Fragment getItem(int position) {
                return FragmentFactory.createFragment(position);
            }
        };
        vp.setAdapter(mAdapter);

        final TabLayout mTabLayout = (TabLayout) findViewById(R.id.bottom_tab_layout);
        // 提供自定义的布局添加Tab
        for (int i = 0; i < mTabTitle.length; i++) {
            mTabLayout.addTab(mTabLayout.newTab().setCustomView(getTabView(this, i)));
        }
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                vp.setCurrentItem(tab.getPosition(),false);

                //改变Tab 状态
                for (int i = 0; i < mTabLayout.getTabCount(); i++) {

                    View view = mTabLayout.getTabAt(i).getCustomView();
                    ImageView icon = (ImageView) view.findViewById(R.id.tab_content_image);
                    TextView text = (TextView) view.findViewById(R.id.tab_content_text);

                    if (i == tab.getPosition()) { // 选中状态
                        icon.setImageResource(mTabResPressed[i]);
                        text.setTextColor(getResources().getColor(android.R.color.black));
                    } else {// 未选中状态
                        icon.setImageResource(mTabRes[i]);
                        text.setTextColor(getResources().getColor(android.R.color.darker_gray));
                    }
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        vp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));

    }


    public  View getTabView(Context context, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, null);
        ImageView tabIcon = (ImageView) view.findViewById(R.id.tab_content_image);
        TextView tabText = (TextView) view.findViewById(R.id.tab_content_text);
        tabIcon.setImageResource(mTabRes[position]);
        tabText.setText(mTabTitle[position]);
        //初始化
        if(position==0){
            tabIcon.setImageResource(mTabResPressed[0]);
            tabText.setTextColor(getResources().getColor(android.R.color.black));
        }
        return view;
    }

}
