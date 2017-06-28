package com.wulee.administrator.testmodule.ui;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.wulee.administrator.testmodule.R;

/**
 * Created by wulee on 2017/6/28 16:24
 */

public class GpsLocationActivity extends AppCompatActivity {
    private TextView tv_location;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gps_location);
        //控件
        tv_location = (TextView) findViewById(R.id.tv_location);
        //获取经纬度
        //1.获取管理者对象
        LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        //获取经纬度需要在AndroidManifest添加权限，在java代码里检查权限
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        //2.获取经纬度坐标，参数：1.定位方式，2.最小更新时间,3.最小更新距离，4.位置监听者
        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                //位置发生改变时候监听
                //获取经度longitude
                double longitude = location.getLongitude();
                //获取纬度altitude
                double latitude = location.getLatitude();

                //设置给控件
                tv_location.setText("拿到的经度为：" + longitude + ",\n拿到的纬度为：" + latitude+String.valueOf(latitude));
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {
                //状态变化监听
            }

            @Override
            public void onProviderEnabled(String provider) {
                //GPS开启时候事件监听
            }

            @Override
            public void onProviderDisabled(String provider) {
                //GPS关闭时候事件监听
            }
        });
    }
}
