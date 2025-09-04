package com.company.flightsystem;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.company.flightsystem.entities.Flight;
import com.company.flightsystem.flightrepository.FlightRepository;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class FlightSystemPaginationSortingApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightSystemPaginationSortingApplication.class, args);
	}
	
	@Autowired 
	private FlightRepository flightRepository;
	
	@PostConstruct
	public void init()
	{
	List<Flight> dummyFlights = 	 createDummyFlights();
	flightRepository.saveAll(dummyFlights);
	}
	
	private List<Flight> createDummyFlights()
	{
		
		List<Flight> flights = new ArrayList<>();
		for(int i=1 ; i<=30 ; i++)
		{
		Flight flight = new Flight();
		
		flight.setFlightNumber(1000 + i);
		flight.setFlightName("Flight " + i);
		flight.setArrival("Airport A");
		flight.setDeparture("Airport B");
		flight.setJourney(i + "hrs");
		
		flights.add(flight);
		}
		
		return flights;
	}

}
