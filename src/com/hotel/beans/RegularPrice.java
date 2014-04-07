package com.hotel.beans;

public class RegularPrice extends Price{
	@Override
	int getPriceCode() {
		// TODO Auto-generated method stub
		return Customer.REGULAR;
	}
}
