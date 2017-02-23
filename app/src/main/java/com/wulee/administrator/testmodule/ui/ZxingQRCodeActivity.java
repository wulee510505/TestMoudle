package com.wulee.administrator.testmodule.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.wulee.administrator.testmodule.R;
import com.wulee.administrator.testmodule.zxing.activity.CaptureActivity;
import com.wulee.administrator.testmodule.zxing.encoding.EncodingHandler;

/**
 * Created by wulee on 2016/9/27 10:59
 */

public class ZxingQRCodeActivity extends Activity implements View.OnClickListener{

    Button scannerQRCode, generateQRCode;
    ImageView qrcodeImg;

    public static final int REQUEST_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zxing_qr_code);

        scannerQRCode = (Button) findViewById(R.id.qrcode_dencode);
        generateQRCode = (Button) findViewById(R.id.qrcode_encode);
        qrcodeImg = (ImageView) findViewById(R.id.qrcode_img);

        scannerQRCode.setOnClickListener(this);
        generateQRCode.setOnClickListener(this);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.qrcode_encode: //生成
                try {
//                    Bitmap mBitmap = EncodingHandler.createQRCode("www.baidu.com", 300);
//                    qrcodeImg.setImageBitmap(mBitmap);
                    Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.icon);
                    Bitmap www = EncodingHandler.createQRCode("www", 600, 600, bitmap);
                    qrcodeImg.setImageBitmap(www);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.qrcode_dencode: //扫描
                Intent intent = new Intent(ZxingQRCodeActivity.this, CaptureActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivityForResult(intent, REQUEST_CODE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) { //RESULT_OK = -1
            Bundle bundle = data.getExtras();
            String scanResult = bundle.getString("result");
            Toast.makeText(ZxingQRCodeActivity.this, scanResult, Toast.LENGTH_LONG).show();
        }
    }
}