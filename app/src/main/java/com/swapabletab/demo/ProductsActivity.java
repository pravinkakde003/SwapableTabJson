package com.swapabletab.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ProductsActivity extends AppCompatActivity implements
		OnClickListener {
	private Toolbar toolbar;
	ArrayList<String> sectionName;
	List<PriceList> pList;
	List<Product> myProductList;
	private ViewPager viewPager;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_products);
		initViews();
	}



	private void initViews() {
//		toolbar = (Toolbar) findViewById(R.id.toolbar);
//		if (toolbar != null) {
//			setSupportActionBar(toolbar);
//			getSupportActionBar().setDisplayShowTitleEnabled(true);
//			getSupportActionBar().setTitle("Fruits & Vegetables");
//			getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//			getSupportActionBar().setDisplayShowHomeEnabled(true);
//			toolbar.setNavigationOnClickListener(new OnClickListener() {
//				@Override
//				public void onClick(View v) {
//					// TODO Auto-generated method stub
//					onBackPressed();
//				}
//			});
//		}
		viewPager = (ViewPager) findViewById(R.id.viewPager);
		sectionName = new ArrayList<String>();
		myProductList= new ArrayList<Product>();
		getResultBack(AppUtils.loadJSONFromAsset(ProductsActivity.this, "test.json"));
	}

	private void getResultBack(String result) {

		// TODO Auto-generated method stub
		if (result != null) {
			try {
//				 Log.e("Result:::", result);
				JSONObject Jobject = new JSONObject(result);
				if (Jobject.getString("status").trim()
						.equalsIgnoreCase("success")) {
					JSONArray jsonArray = Jobject.getJSONArray("products_data");
//					 Product[] producArray = new
//					 Gson().fromJson(jsonArray.toString(), Product[].class);
//					 List<Product> productList = Arrays.asList(producArray);
					
					for (int i = 0; i < jsonArray.length(); i++) {
						 pList = new ArrayList<PriceList>();
						JSONObject obj = jsonArray.getJSONObject(i);
						sectionName.add(obj.getString("product_name"));

						JSONArray jsonArrayPriceList = obj
								.getJSONArray("price_list");
						for (int j = 0; j < jsonArrayPriceList.length(); j++) {
							JSONObject innerobj = jsonArrayPriceList
									.getJSONObject(j);
							Log.e("price", innerobj.getString("price"));
							Log.e("currency", innerobj.getString("currency"));
							pList.add(new PriceList(innerobj
									.getString("product_id"), 
									innerobj.getString("name"),
									innerobj.getString("price"),
									innerobj.getString("currency"),
									innerobj.getString("quantity"), 
									innerobj.getString("description"),
									innerobj.getString("image")));
						}
						
						myProductList.add(new Product(obj.getString("product_name"), pList));
						
						

					}
					viewPager.setAdapter(new ProductAdapter(
							getSupportFragmentManager(),myProductList));
					 ViewPagerTabs viewPagerTabs = (ViewPagerTabs) findViewById(R.id.tabs);
				        viewPagerTabs.setViewPager(viewPager);
//					viewPager.setAdapter(new NewPagerAdapter(
//							getSupportFragmentManager(), productList));

				} else {
//					AppUtils.ShowToast(ProductsActivity.this,
//							Jobject.getString("msg"));
				}

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		} else {
			Log.e("", "Result Null");
		}
	
		
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		finish();
//		overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

	}

}
