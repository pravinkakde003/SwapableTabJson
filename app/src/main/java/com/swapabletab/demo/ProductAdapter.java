package com.swapabletab.demo;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;



public class ProductAdapter extends FragmentPagerAdapter {

	List<Product> products;

	public ProductAdapter(FragmentManager fm) {
		super(fm);
	}

	public ProductAdapter(FragmentManager fm, List<Product> productList) {
		// TODO Auto-generated constructor stub
		super(fm);

		this.products = productList;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return products.get(position).getProduct_name().toString();
	}

	private List<PriceList> getPriceList(int pos) {

		return this.products.get(pos).getPrice_list();
	}

	@Override
	public Fragment getItem(int position) {
		Fragment fragment = new ProductDetailFragment();
		Bundle bundle = new Bundle();
		bundle.putParcelableArrayList("pricelist", (ArrayList<? extends Parcelable>) getPriceList(position));
		fragment.setArguments(bundle);
		return fragment;
	}

	@Override
	public int getCount() {
		return products.size();
	}
}
