package com.swapabletab.demo;


import android.os.Parcel;
import android.os.Parcelable;

public class PriceList implements Parcelable {

	String product_id;
	String name;
	String price;
	String currency;
	String quantity;
	String description;
	String image;

	public PriceList(String product_id, String name, String price,
			String currency, String quantity, String description, String image) {
		super();
		this.product_id = product_id;
		this.name = name;
		this.price = price;
		this.currency = currency;
		this.quantity = quantity;
		this.description = description;
		this.image = image;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	public PriceList(Parcel source) {
		String[] data = new String[7];
		source.readStringArray(data);
		this.product_id = data[0];
		this.name = data[1];
		this.price = data[2];
		this.currency = data[3];
		this.quantity = data[4];
		this.description = data[5];
		this.image = data[6];

	}

	public static final Creator<PriceList> CREATOR = new Creator<PriceList>() {

		@Override
		public PriceList createFromParcel(Parcel source) {
			// TODO Auto-generated method stub
			return new PriceList(source);
		}

		@Override
		public PriceList[] newArray(int arg0) {
			// TODO Auto-generated method stub
			return new PriceList[arg0];
		}

	};

	@Override
	public void writeToParcel(Parcel dest, int arg1) {
		dest.writeStringArray(
				new String[] {
				this.product_id, 
				this.name,
				this.price,
				this.currency,
				this.quantity,
				this.description,
				this.image
		});
	}

}
