package com.wulee.administrator.testmodule.utils;


import android.content.Context;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;


/**
 * 地理位置工具类 借助高德SDK
 */
public class LocationUtils {

	public static String ACTION_UPDATE_CURR_LOCATION = "action_update_curr_location";
	private static LocationUtils mLocationUtils = null;

	//声明AMapLocationClient类对象
	private AMapLocationClient mLocationClient = null;
	private AMapLocationClientOption mLocationOption = null;


	private LocationUtils(Context context) {
       //初始化定位
		mLocationClient = new AMapLocationClient(context);
		//设置定位回调监听
		mLocationClient.setLocationListener(mLocationListener);

		//初始化定位参数
		mLocationOption = new AMapLocationClientOption();
		//设置定位模式为高精度模式，Battery_Saving为低功耗模式，Device_Sensors是仅设备模式
		mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
		//设置是否返回地址信息（默认返回地址信息）
		mLocationOption.setNeedAddress(true);
		//设置是否只定位一次,默认为false
		mLocationOption.setOnceLocation(false);
		//设置是否强制刷新WIFI，默认为强制刷新
		mLocationOption.setWifiActiveScan(true);
		//设置是否允许模拟位置,默认为false，不允许模拟位置
		mLocationOption.setMockEnable(false);
		//设置定位间隔,单位毫秒,默认为2000ms
		mLocationOption.setInterval(5000);
		//给定位客户端对象设置定位参数
		mLocationClient.setLocationOption(mLocationOption);
	}

	public static LocationUtils getInstance(Context context) {
		if (null == mLocationUtils) {
			mLocationUtils = new LocationUtils(context);
		}
		return mLocationUtils;
	}

	public void startGetLocation() {
		if (mLocationClient != null) {
			mLocationClient.startLocation();
		}
	}

	public void stopGetLocation() {
		if (mLocationClient != null) {
			mLocationClient.stopLocation();
		}
	}

	/*
	 *声明定位回调监听器
	 */
	private AMapLocationListener mLocationListener = new AMapLocationListener() {
		@Override
		public void onLocationChanged(AMapLocation amapLocation) {
			if (amapLocation != null && amapLocation.getErrorCode() == AMapLocation.LOCATION_SUCCESS) {
				//存储自己位置信息
				//将高德坐标转化为百度坐标



			} else {

			}

			if (mListener != null){
				mListener.onLocationChanged(amapLocation);// 显示系统小蓝点
			}
		}
	};

	private MyLocationChangedListener mListener;

	public void setOnLocationChangedListener(MyLocationChangedListener listener){
		this.mListener=listener;
	}

	public interface MyLocationChangedListener{
		void onLocationChanged(AMapLocation amapLocation);
	}

}

