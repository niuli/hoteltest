package com.hotel.beans;

import java.util.Vector;

public class Manager {

	private static Vector<Hotel> _hotelList = new Vector<Hotel>();
	
	public void initHotelList() {
		Hotel hotel1 = new Hotel("Lakewood", 3);
		Hotel hotel2 = new Hotel("Bridgewood", 4);
		Hotel hotel3 = new Hotel("Ridgwood", 5);
		
		hotel1.setPricePolicy(Customer.REGULAR, Price.WEEKDAY_PRICE, 110);
		hotel1.setPricePolicy(Customer.REGULAR, Price.WEEKEND_PRICE, 90);
		hotel1.setPricePolicy(Customer.REWARDS, Price.WEEKDAY_PRICE, 80);
		hotel1.setPricePolicy(Customer.REWARDS, Price.WEEKEND_PRICE, 80);
		
		hotel2.setPricePolicy(Customer.REGULAR, Price.WEEKDAY_PRICE, 160);
		hotel2.setPricePolicy(Customer.REGULAR, Price.WEEKEND_PRICE, 60);
		hotel2.setPricePolicy(Customer.REWARDS, Price.WEEKDAY_PRICE, 110);
		hotel2.setPricePolicy(Customer.REWARDS, Price.WEEKEND_PRICE, 50);
		
		hotel3.setPricePolicy(Customer.REGULAR, Price.WEEKDAY_PRICE, 220);
		hotel3.setPricePolicy(Customer.REGULAR, Price.WEEKEND_PRICE, 150);
		hotel3.setPricePolicy(Customer.REWARDS, Price.WEEKDAY_PRICE, 100);
		hotel3.setPricePolicy(Customer.REWARDS, Price.WEEKEND_PRICE, 40);
		
		_hotelList.add(hotel1);
		_hotelList.add(hotel2);
		_hotelList.add(hotel3);
	}
	
	public Vector<Hotel> getHotelList() {
		return _hotelList;
	}
}
