package com.wulee.administrator.testmodule.ui;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.wulee.administrator.testmodule.R;

/**
 * Created by wulee on 2016/4/13.
 */
public class DrawTestActivity extends AppCompatActivity {

    private ImageView ivSource;
    private ImageView ivTarget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_container);


        ivSource = (ImageView) findViewById(R.id.iv_source);
        ivTarget = (ImageView) findViewById(R.id.iv_target);


        Bitmap bmpSource = BitmapFactory.decodeResource(getResources(),R.drawable.icon);
        ivSource.setImageBitmap(bmpSource);

        Matrix matrix = new Matrix();
        matrix.postScale(1.2f,1.2f);
        matrix.postRotate(45);
        Bitmap bmpTarget = Bitmap.createBitmap(bmpSource,0,0,bmpSource.getWidth(),bmpSource.getHeight(),matrix,true);
        ivTarget.setImageBitmap(bmpTarget);
    }
}
