package com.psl.busBooking.pl;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

import com.psl.busBooking.dto.Bus;
import com.psl.busBooking.exception.BusBookingException;
import com.psl.busBooking.service.BusBookingService;
import com.psl.busBooking.service.BusBookingServiceImpl;

public class BusBookingMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BusBookingService ref = new BusBookingServiceImpl();
		int ch = 0;
		do {

			System.out
					.println("**********************************************");
			System.out.println("\t\tWELCOME TO BUS BOOKING SERVICE ");
			System.out.println("1. Show All Buses ");
			System.out.println("2. Search for a Bus ");
			System.out.println("3. Book a bus ");
			System.out.println("4. Exit");
			try {
				ch = sc.nextInt();
				switch (ch) {
				case 1:
					System.out.println("Bus details are as follows : ");
					HashMap<Integer, Bus> map = ref.showAllBusDetails();
					for (Entry<Integer, Bus> entry : map.entrySet()) {
						System.out.println(entry.getValue());
					}
					break;
				case 2:
					System.out.println("Enter a source : ");
					String source = sc.next();
					System.out.println("Enter a destination");
					String destination = sc.next();
					HashMap<Integer, Bus> map1 = ref.getBusDetails(source,
							destination);
					//System.out.println("Map 1 VALUES :: "+map1);
					for (Entry<Integer, Bus> entry : map1.entrySet()) {
						System.out.println(entry.getValue());
					}
					break;
				case 3:
					System.out.println("enter a bus id ");
					int id = sc.nextInt();
					Bus b = ref.bookBus(id);
					System.out.println(b);
					break;
				case 4:
					break;
				default:
					System.out.println("Invalid Choice");

				}
			} catch (BusBookingException e) {
				System.out.println(e.getMessage());
			}
		} while (ch > 0 && ch <= 3);
		sc.close();
	}
}
