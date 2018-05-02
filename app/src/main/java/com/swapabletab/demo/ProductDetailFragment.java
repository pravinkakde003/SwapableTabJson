package com.swapabletab.demo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;




public class ProductDetailFragment extends Fragment {

	/**
	 * {@link Fragment} rootview
	 */
	private View rootView;

	/**
	 * {@link ListView} For product list
	 */
	private ListView listView;

	private ArrayList<PriceList> priceList;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		rootView = inflater.inflate(R.layout.vp_phone, container, false);
		listView = (ListView) rootView.findViewById(R.id.listview_phone);
		Bundle bundle = getArguments();
		priceList = bundle.getParcelableArrayList("pricelist");
		listView.setAdapter(new MyListViewAdapter(getActivity(),R.layout.item_file,priceList));
		return rootView;
	}

}
