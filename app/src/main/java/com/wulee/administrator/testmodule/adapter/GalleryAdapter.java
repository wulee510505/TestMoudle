package com.wulee.administrator.testmodule.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.wulee.administrator.testmodule.R;

import java.util.List;

public class GalleryAdapter extends
		RecyclerView.Adapter<GalleryAdapter.ViewHolder>
{

	public interface OnItemClickLitener
	{
		void onItemClick(View view, int position);
	}

	private OnItemClickLitener mOnItemClickLitener;

	public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener)
	{
		this.mOnItemClickLitener = mOnItemClickLitener;
	}

	private LayoutInflater mInflater;
	private List<Integer> mDatas;

	public GalleryAdapter(Context context, List<Integer> datats)
	{
		mInflater = LayoutInflater.from(context);
		mDatas = datats;
	}

	public static class ViewHolder extends RecyclerView.ViewHolder
	{
		public ViewHolder(View arg0)
		{
			super(arg0);
		}

		ImageView mImg;
		TextView mTxt;
	}

	@Override
	public int getItemCount()
	{
		return mDatas.size();
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i)
	{
		View view = mInflater.inflate(R.layout.gallery_item,
				viewGroup, false);
		ViewHolder viewHolder = new ViewHolder(view);

		viewHolder.mImg = (ImageView) view.findViewById(R.id.id_index_gallery_item_image);
		viewHolder.mTxt = (TextView) view.findViewById(R.id.id_index_gallery_item_text);
		return viewHolder;
	}

	@Override
	public void onBindViewHolder(final ViewHolder viewHolder, final int i)
	{
		viewHolder.mImg.setImageResource(mDatas.get(i));
		viewHolder.mTxt.setText(i+"");
		if (mOnItemClickLitener != null)
		{
			viewHolder.itemView.setOnClickListener(new OnClickListener()
			{
				@Override
				public void onClick(View v)
				{
					mOnItemClickLitener.onItemClick(viewHolder.itemView, i);
				}
			});

		}

	}

}
