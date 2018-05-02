package com.swapabletab.demo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyListViewAdapter extends BaseAdapter {

	private ArrayList<PriceList> priceList;
	private LayoutInflater inflater;
	Context mContext;
	int layouID;

	public MyListViewAdapter(Context context, int resource,
			ArrayList<PriceList> priceList) {
		this.mContext = context;
		inflater = (LayoutInflater) mContext
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.layouID = resource;
		this.priceList = priceList;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return priceList.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return priceList.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	class ViewHolder {
		TextView txt_product_name;
		TextView txt_quantity;
		TextView txt_price;
	}

	@SuppressLint("NewApi")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;

		if (convertView == null) {
			convertView = inflater.inflate(layouID, null);
			holder = new ViewHolder();
			holder.txt_product_name = (TextView) convertView
					.findViewById(R.id.txt_product_name);
			holder.txt_quantity = (TextView) convertView
					.findViewById(R.id.txt_quantity);
			holder.txt_price = (TextView) convertView
					.findViewById(R.id.txt_price);
			convertView.setTag(holder);

		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		final PriceList notes = priceList.get(position);

		holder.txt_product_name.setText(notes.getName());
		holder.txt_quantity.setText(notes.getQuantity());
		holder.txt_price.setText("\u20B9"+notes.getPrice());

		return convertView;
	}

}
