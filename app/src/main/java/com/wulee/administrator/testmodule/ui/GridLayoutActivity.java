package com.wulee.administrator.testmodule.ui;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.wulee.administrator.testmodule.R;
import com.wulee.administrator.testmodule.utils.SystemUtils;
import com.wulee.administrator.testmodule.view.WhewView;

/**
 * Created by wulee on 2016/5/17.
 */
public class GridLayoutActivity extends Activity {

    GridLayout mGridLayoutTop;
    GridLayout mGridLayoutBottom;
    TableLayout mTableLayout;
    private WhewView wv;

    private Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            if (msg.what == 100) {
               // 每隔10s响一次
                handler.sendEmptyMessageDelayed(100, 5000);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.grid_layout);
        setContentView(R.layout.table_layout);
        //setContentView(new CircleMenu(this,300,300,250));

      /*mGridLayoutBottom = (GridLayout) findViewById(R.id.gridlayout_bottom);
        mGridLayoutBottom.setColumnCount(7);
        for (int i=0;i<22;i++){
            TextView tv = new TextView(this);

            tv.setText(i+"");
            mGridLayoutBottom.addView(tv,i);
        }*/

        mTableLayout = (TableLayout) findViewById(R.id.tablayout2);
        for (int i = 0; i < 3; i++) {
            LinearLayout llayout = new LinearLayout(this);
            int[] ss = SystemUtils.getScreenWidthAndHeight(this);
            int sw = ss[0];
            LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(sw/7,LinearLayout.LayoutParams.WRAP_CONTENT);
            for (int j = 0;j<7;j++) {
                final TextView itemTv = new TextView(this);
                itemTv.setLayoutParams(new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT));
                itemTv.setTextColor(Color.BLACK);
                itemTv.setBackgroundColor(Color.WHITE);
                itemTv.setTextSize(20f);
                itemTv.setPadding(10,10,10,10);
                initTableData(i,j,itemTv);
                itemTv.setGravity(Gravity.CENTER);
                itemTv.setTag(j);
                llp.setMargins(1, 1, 1, 1);
                itemTv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(GridLayoutActivity.this,itemTv.getText(),Toast.LENGTH_SHORT).show();
                    }
                });
                llayout.addView(itemTv,llp);
            }


            TableRow trow = new TableRow(this);
            trow.setId(i);
            trow.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));

            TextView aaa = new TextView(this);

            aaa.setBackgroundColor(Color.RED);
            aaa.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));
            TextView bbb = new TextView(this);
            bbb.setText(""+i + "");

            bbb.setTextColor(Color.BLACK);
            bbb.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));

            TextView ccc = new TextView(this);
            ccc.setText(""+"Dynamic Button");
            ccc.setTextColor(Color.BLACK);
            ccc.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));

            trow.addView(aaa);
            trow.addView(bbb);
            trow.addView(ccc);
            mTableLayout.addView(llayout);
        }

        wv = (WhewView) findViewById(R.id.wv);

        wv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(wv.isStarting()){
                   //如果动画正在运行就停止，否则就继续执行
                    wv.stop();
                    handler.removeMessages(100);
                }else{
                     // 执行动画
                    wv.start();
                    handler.sendEmptyMessage(100);
                }
            }
        });
    }

    private void initTableData(int row,int column,TextView tv) {
      if(row == 0 ){
          if(column == 0){
              tv.setText("日期");
          }else{
              tv.setText(column+"");
          }
      }else if(row == 1 && column==0){
          tv.setText("上午");
      }else if(row == 2 && column==0){
          tv.setText("下午");
      }
    }
}
