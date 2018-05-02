package com.swapabletab.demo;

import java.util.List;

public class Product {

	private String product_name;
	private List<PriceList> price_list;

	public Product(String product_name, List<PriceList> priceList) {
		super();
		this.product_name = product_name;
		this.price_list = priceList;
	}

	public List<PriceList> getPrice_list() {
		return price_list;
	}

	public void setPrice_list(List<PriceList> price_list) {
		this.price_list = price_list;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

}
