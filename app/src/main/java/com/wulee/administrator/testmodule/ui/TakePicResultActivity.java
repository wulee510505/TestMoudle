package com.wulee.administrator.testmodule.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.wulee.administrator.testmodule.R;

/**
 * Created by wulee on 2016/9/27 10:59
 */

public class TakePicResultActivity extends Activity {

    private TextView tv;
    private Button btnCamer;
    private ImageView iv;
    private static final int PHOTO_CAMAER = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.take_pic_result);

        tv = (TextView) findViewById(R.id.tv);
        btnCamer = (Button) findViewById(R.id.btn_camer);
        iv = (ImageView) findViewById(R.id.iv_show_pic);
        btnCamer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(TakePicResultActivity.this, PictureActivity.class), PHOTO_CAMAER);
            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case PHOTO_CAMAER:
                if (resultCode == Activity.RESULT_OK) {
                    if (data == null)
                        break;
                    String path = data.getStringExtra("save_path");
                    Bitmap bmp = BitmapFactory.decodeFile(path);
                    tv.setText(path);
                    iv.setImageBitmap(bmp);
                }
                break;
        }
    }
}