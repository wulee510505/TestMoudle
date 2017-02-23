package com.wulee.administrator.testmodule.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.wulee.administrator.testmodule.R;

/**
 * Created by wulee on 2016/9/8 15:55
 */

public class CoordinatorTest extends AppCompatActivity {

    //private Toolbar toolbar;
    private ActionBarDrawerToggle drawerToggle;
    private DrawerLayout drawerLayout;
    private LinearLayout drawerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coordinator_layout);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerView = (LinearLayout) findViewById(R.id.drawer_view);
        //toolbar = (Toolbar) findViewById(R.id.tool_bar);
        // toolbar.setTitle("测试");
        //setSupportActionBar(toolbar);
        // 设置返回键可用
        //getSupportActionBar().setHomeButtonEnabled(true);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //drawerToggle = new ActionBarDrawerToggle(CoordinatorTest.this, drawerLayout, null, R.string.open, R.string.close);
        //drawerToggle.syncState();
        drawerLayout.setDrawerListener(drawerToggle);

        Button btn = (Button) findViewById(R.id.open_drawer);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(drawerView);
            }
        });

    }
}
