package com.wulee.administrator.testmodule.ui;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.wulee.administrator.testmodule.R;
import com.wulee.administrator.testmodule.utils.SntpClient;
import com.wulee.administrator.testmodule.view.YearSelectView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NetTimeActivity extends AppCompatActivity {

    private TextView tv;
    private Handler mHandler;

    private YearSelectView mYearSelectView;
    private Button btnTest;
    private CheckBox mCheckBox;

    private int currYear = 2016;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.net_time);

        tv = (TextView) findViewById(R.id.tv);
        Typeface type= Typeface.createFromAsset(getAssets(),"font/fzh.ttf");
        tv.setTypeface(type);

        btnTest = (Button) findViewById(R.id.btn_test);
        mCheckBox = (CheckBox) findViewById(R.id.checkbox);
        mYearSelectView = (YearSelectView) findViewById(R.id.select_year_view);
        mYearSelectView.setMiddleText(currYear+"年");
        mYearSelectView.setBtnClickListener(new YearSelectView.OnBtnClickListener() {
            @Override
            public void onLeftBtnClick() {
                currYear--;
                mYearSelectView.setMiddleText(currYear+"年");
            }

            @Override
            public void onRightBtnClick() {
                currYear++;
                mYearSelectView.setMiddleText(currYear+"年");
            }
        });



       mHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if(msg != null && msg.obj != null){
                    if(!TextUtils.isEmpty(msg.obj.toString())){
                        tv.setText(msg.obj.toString());
                    }else{
                        Toast.makeText(NetTimeActivity.this,"同步时间失败",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(NetTimeActivity.this,"同步时间失败",Toast.LENGTH_SHORT).show();
                }
            }
        };

        getServerCurrentTime();

        btnTest.setEnabled(false);
        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(NetTimeActivity.this,"点击了按钮",Toast.LENGTH_SHORT).show();
            }
        });
        mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    btnTest.setEnabled(true);
                }else{
                    btnTest.setEnabled(false);
                }
            }
        });
    }


    private void getServerCurrentTime() {
       new Thread(new Runnable() {
            @Override
            public void run() {
                String dateStr = "";
                SntpClient client = new SntpClient();
                if (client.requestTime("pool.ntp.org", 30000)) {
                    long now = client.getNtpTime() + System.nanoTime() / 1000
                            - client.getNtpTimeReference();
                    Date current = new Date(now);
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    try {
                        dateStr = sdf.format(current);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
               }
                Message msg = new Message();
                msg.obj = dateStr;
                mHandler.sendMessageDelayed(msg,0);
            }
        }).start();
    }

}
