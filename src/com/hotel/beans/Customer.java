package com.hotel.beans;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Vector;

public class Customer {

	public static final int REGULAR = 0;
	public static final int REWARDS = 1;
	
	private int _cusType;
	private Vector<Date> _resvDates = new Vector<Date>();
	
	public Customer(int cusType){
		_cusType = cusType;
		//
	}
	
	public Customer(String strInput){
		int posTypeEnd = strInput.indexOf(":");
		String strCurType = strInput.substring(0, posTypeEnd);
		
		if (strCurType.compareToIgnoreCase("Regular") == 0) {
			setCustomerType(REGULAR);
		}else if (strCurType.compareToIgnoreCase("Rewards") == 0) {
			setCustomerType(REWARDS);
		}else {
			System.out.println("Error: Customer Type is undefined!");
			return;
		}
		
		String strDatesInput = strInput.substring(posTypeEnd + 1);
		String [] strDates = strDatesInput.split(",");
		SimpleDateFormat sDateFormat = new SimpleDateFormat("ddMMMyyyy", Locale.US);
		
		int i = 0;
		while (i < strDates.length) {
			try {
				Date date = sDateFormat.parse(strDates[i].trim());
				addResvDate(date);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}			
			++i;
		}
	}
	
	public void addResvDate(Date date) {
		_resvDates.add(date);
	}
	
	public void setCustomerType(int cusType) {
		_cusType = cusType;
	}
	
	public int getCustomerType() {
		return _cusType;
	}
	
	public Hotel getCheapestHotel(Vector<Hotel> hotelList) {
		Hotel cheapHotel = null;
		double cheapPrice = Double.MAX_VALUE;
		
		Enumeration<Hotel> hotels = hotelList.elements();
		while (hotels.hasMoreElements()) {			
			Hotel hotel = (Hotel) hotels.nextElement();
			if (cheapHotel == null) {
				cheapHotel = hotel;
			}
			
			double d = getHotelCharge(hotel);
			if (d < cheapPrice) {
				cheapPrice = d;
				cheapHotel = hotel;
			}else if (d == cheapPrice && hotel.getRate() > cheapHotel.getRate()) {
				cheapHotel = hotel;
			}
		}
		
		return cheapHotel;		
	}
	
	public double getHotelCharge(Hotel hotel){
		return hotel.getCharge(_cusType, _resvDates);
	}
}
