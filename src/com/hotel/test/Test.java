package com.hotel.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Vector;

import com.hotel.beans.Customer;
import com.hotel.beans.Hotel;
import com.hotel.beans.Manager;

public class Test {
	public static void main(String[] args) {
		Manager manager = new Manager();
		manager.initHotelList();		
		Vector<Hotel> hotelList = manager.getHotelList();
		
		System.out.println("Please input the Hotel Reservation:");
		InputStreamReader isReader = new InputStreamReader(System.in);
		
		BufferedReader bReader = new BufferedReader(isReader);
		String strInput = null;
		
		try {
			strInput = bReader.readLine();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		Customer customer = new Customer(strInput);
		Hotel cheapHotel = customer.getCheapestHotel(hotelList);
		
		if (cheapHotel != null) {
			System.out.println(cheapHotel.getName());
		}else {
			System.out.println("Error: getCheapestHotel Failed!");
		}
	}
}
