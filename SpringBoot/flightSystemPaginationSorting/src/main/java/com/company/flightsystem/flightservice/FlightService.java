package com.company.flightsystem.flightservice;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.company.flightsystem.entities.Flight;

public interface FlightService {
	
	Flight addFlightDetails(Flight flight);
	Flight updateFlightDetails(Integer flightNumber , Flight flight);
	Flight getFlightDetails(Integer flightNumber);
	List<Flight> getAllFlightsDetails();
	String deleteFlightDetails(Integer flightNumber);
	
	public Page<Flight> getAllFlights(Pageable pageable);
	
	
	

}
