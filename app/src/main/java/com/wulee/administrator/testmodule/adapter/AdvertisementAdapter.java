package com.wulee.administrator.testmodule.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.wulee.administrator.testmodule.R;
import com.wulee.administrator.testmodule.utils.ImageUtil;

import org.json.JSONArray;

import java.util.List;

/**
 * 广告轮播adapter
 */
public class AdvertisementAdapter extends PagerAdapter {

	private Context context;
	private List<View> views;
	JSONArray advertiseArray;
	
	public AdvertisementAdapter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdvertisementAdapter(Context context, List<View> views, JSONArray advertiseArray) {
		this.context = context;
		this.views = views;
		this.advertiseArray = advertiseArray;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return views.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return (arg0 == arg1);
	}
	
	@Override
	public void destroyItem(View container, int position, Object object) {
		((ViewPager) container).removeView(views.get(position));
	}

	@Override
	public Object instantiateItem(View container, int position) {
		((ViewPager) container).addView(views.get(position), 0);
		final int POSITION = position;
		View view = views.get(position);
		try {
			String head_img = advertiseArray.optJSONObject(position).optString("head_img");
			ImageView ivAdvertise = (ImageView) view.findViewById(R.id.ivAdvertise);
			ImageUtil.setDefaultImageView(ivAdvertise,head_img, R.mipmap.loading,context);

			final int index = position;
			ivAdvertise.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					v.setOnClickListener(new OnClickListener() {
						@Override
						public void onClick(View v) {

						}
					});
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return view;
	}
	
}
