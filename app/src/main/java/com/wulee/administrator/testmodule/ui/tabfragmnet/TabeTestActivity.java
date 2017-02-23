package com.wulee.administrator.testmodule.ui.tabfragmnet;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.wulee.administrator.testmodule.R;
import com.wulee.administrator.testmodule.ui.tabfragmnet.fragments.MainTabFragment;
import com.wulee.administrator.testmodule.ui.tabfragmnet.fragments.Tab1Fragment;
import com.wulee.administrator.testmodule.ui.tabfragmnet.fragments.Tab2Fragment;
import com.wulee.administrator.testmodule.ui.tabfragmnet.fragments.Tab3Fragment;

/**
 * Created by wulee on 2016/9/28 14:50
 */

public class TabeTestActivity extends AppCompatActivity {


    private TabLayout testTablayout;
    private ViewPager mViewPager;
    private MainTabFragment mainTabFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabe_test);

        testTablayout = (TabLayout) findViewById(R.id.test_tablayout);
        testTablayout.addTab(testTablayout.newTab().setText("标题1"));
        testTablayout.addTab(testTablayout.newTab().setText("标题2"));
        testTablayout.addTab(testTablayout.newTab().setText("标题3"));
        testTablayout.addTab(testTablayout.newTab().setText("标题4"));
        testTablayout.addTab(testTablayout.newTab().setText("标题5"));
        testTablayout.addTab(testTablayout.newTab().setText("标题6"));
        testTablayout.addTab(testTablayout.newTab().setText("标题7"));
        testTablayout.addTab(testTablayout.newTab().setText("标题8"));

        mainTabFragment = new MainTabFragment() {
            @Override
            public void addSubViewTab() {
                addTab("标题1",Tab1Fragment.class);
                addTab("标题2",Tab2Fragment.class);
                addTab("标题3",Tab3Fragment.class);
                addTab("标题4",Tab3Fragment.class);
                addTab("标题5",Tab3Fragment.class);
                addTab("标题6",Tab3Fragment.class);
                addTab("标题7",Tab3Fragment.class);
                addTab("标题8",Tab3Fragment.class);
            }

            @Override
            public void loadFinishView(ViewPager viewPager, FragmentStatePagerAdapter mAdapter) {
                mViewPager = viewPager;
                testTablayout.setupWithViewPager(mViewPager);
                testTablayout.setTabsFromPagerAdapter(mAdapter);
            }

        };
        getSupportFragmentManager().beginTransaction().add(R.id.test_contanter,mainTabFragment).commit();
        //关联Tab
    }
}
