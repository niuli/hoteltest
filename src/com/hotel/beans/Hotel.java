package com.hotel.beans;

import java.util.Date;
import java.util.HashMap;
import java.util.Vector;

public class Hotel {

	private String _name;
	private int _rate;
	private HashMap<Integer, Price> _prices = new HashMap<Integer, Price>();
	
	public Hotel(String name, int rate) {
		_name = name;
		_rate = rate;
	}
	
	public void setPricePolicy(int cusType, int dateType, double dPrice) {
		Price price = null;
		
		if (_prices.containsKey(cusType)) {
			price = _prices.get(cusType);
		}else {
			switch (cusType) {
			case Customer.REGULAR:
				price = new RegularPrice();				
				break;

			case Customer.REWARDS:
				price = new RewardsPrice();				
				break;
				
			default:
				System.out.println("Error: setPricePolicy Failed! Caused by CustomType undefined.");
				return;
			}
		}
		
		if (price != null) {
			switch (dateType) {
			case Price.WEEKDAY_PRICE:
				price.setWeekdayPrice(dPrice);
				break;
				
			case Price.WEEKEND_PRICE:
				price.setWeekendPrice(dPrice);
				break;

			default:
				System.out.println("Error: setPricePolicy Failed! Caused by DateType undefined.");
				break;
			}
		}
		
		_prices.put((Integer)cusType, price);		
	}
	
	public double getCharge(int cusType, Vector<Date> resvDates) {
		if (_prices.containsKey(cusType)) {
			return _prices.get(cusType).getCharge(resvDates);
		}		
		return 0.0;
	}
	
	public String getName(){
		return _name;
	}
	
	public int getRate(){
		return _rate;
	}
}
