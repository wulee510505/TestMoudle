package com.wulee.administrator.testmodule.ui;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import com.wulee.administrator.testmodule.R;
import com.wulee.administrator.testmodule.utils.SearchUtils;

/**
 * Created by wulee on 2016/8/5 16:53
 */

public class SearchActivity extends Activity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seach_main);


        findViewById(R.id.btn_search).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SearchUtils(SearchActivity.this, findViewById(R.id.rootview),
                        findViewById(R.id.rootview), "搜索", new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }
                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        Toast.makeText(SearchActivity.this,s,Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                }).showSearchBar();
            }
        });
    }
}
