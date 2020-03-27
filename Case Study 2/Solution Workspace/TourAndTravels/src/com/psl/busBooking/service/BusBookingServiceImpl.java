package com.psl.busBooking.service;

import java.util.HashMap;

import com.psl.busBooking.dao.BusBookingDao;
import com.psl.busBooking.dao.BusBookingDaoImpl;
import com.psl.busBooking.dto.Bus;
import com.psl.busBooking.exception.BusBookingException;

public class BusBookingServiceImpl implements BusBookingService{

	BusBookingDao ref = new BusBookingDaoImpl();
	@Override
	public HashMap<Integer, Bus> showAllBusDetails() throws BusBookingException {
		return ref.showAllBusDetails();
	}

	@Override
	public HashMap<Integer, Bus> getBusDetails(String from, String to)
			throws BusBookingException {
		return ref.getBusDetails(from, to);

	}

	@Override
	public Bus bookBus(int busId) throws BusBookingException {
		return ref.bookBus(busId);
	}

}
