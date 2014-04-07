package com.hotel.beans;

import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.Vector;

public abstract class Price {

	abstract int getPriceCode();
	
	public static final int WEEKDAY_PRICE = 0;
	public static final int WEEKEND_PRICE = 1;
	
	private double _weekdayPrice = 0.0;
	private double _weekendPrice = 0.0;
	
	public double getCharge(Vector<Date> resvDates){
		double result = 0.0;
		
		Calendar calendar = Calendar.getInstance();
		Enumeration<Date> dates = resvDates.elements();
		while (dates.hasMoreElements()) {
			Date date = (Date) dates.nextElement();
			calendar.setTime(date);
			
			int dayofWeek = calendar.get(Calendar.DAY_OF_WEEK);
			if (dayofWeek == Calendar.SUNDAY
					|| dayofWeek == Calendar.SATURDAY) {
				result += _weekendPrice;
			}else {
				result += _weekdayPrice;
			}			
		}
		return result;
	}
	
	public void setWeekdayPrice(double weekdayPrice) {
		_weekdayPrice = weekdayPrice;
	}
	
	public void setWeekendPrice(double weekendPrice) {
		_weekendPrice = weekendPrice;
	}
	
	public double getWeekdayPrice() {
		return _weekdayPrice;
	}
	
	public double getWeekendPrice() {
		return _weekendPrice;
	}
	
}
