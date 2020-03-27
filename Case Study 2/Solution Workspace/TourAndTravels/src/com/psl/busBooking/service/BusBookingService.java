package com.psl.busBooking.service;

import java.util.HashMap;

import com.psl.busBooking.dto.Bus;
import com.psl.busBooking.exception.BusBookingException;

public interface BusBookingService {
	HashMap<Integer,Bus>showAllBusDetails() throws BusBookingException;
	HashMap<Integer,Bus> getBusDetails(String from,String to) throws BusBookingException;
	Bus bookBus(int busId) throws BusBookingException;
}
