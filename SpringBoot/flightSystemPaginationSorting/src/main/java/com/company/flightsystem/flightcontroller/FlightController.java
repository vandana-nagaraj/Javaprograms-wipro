package com.company.flightsystem.flightcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.flightsystem.entities.Flight;
import com.company.flightsystem.flightservice.FlightService;

@RestController
@RequestMapping("/flight.com")
public class FlightController {
	
	
	@Autowired
	FlightService flightService;
	
	@PostMapping("/addFlight")
	public Flight addFlightDetails(@RequestBody Flight flight)
	{
		Flight flightSaved = flightService.addFlightDetails(flight);
		return flightSaved;
	}
	
	@PutMapping("/updateFlight/{flightNumber}")
	public Flight updateFlightDetails(@PathVariable Integer flightNumber ,@RequestBody Flight flight)
	{
		Flight flightUpdated = flightService.updateFlightDetails(flightNumber, flight);
		return flightUpdated;
	}
	
	@GetMapping("/allFlights")
	public List<Flight> getAllFlights()
	{
		return flightService.getAllFlightsDetails();
	}
	
	
	@GetMapping("/allFlights/{flightNumber}")
	public Flight getFlightDetailByFlightNumber(@PathVariable Integer flightNumber)
	{
		return flightService.getFlightDetails(flightNumber);
	}
	
	@DeleteMapping("/deleteFlight/{flightNumber}")
	public String deleteFlight(@PathVariable Integer flightNumber)
	{
		String message;
	  message = 	flightService.deleteFlightDetails(flightNumber);
	  return message;
	}
	
	
	@GetMapping("allFlightPaged")
	public ResponseEntity<Page<Flight>> getAllPagedFlights(	
		@RequestParam(defaultValue ="0") int page,
		@RequestParam(defaultValue = "5") int size,
		//group by
		@RequestParam(defaultValue = "flightNumber") String sortBy,
		//order by
		@RequestParam(defaultValue = "asc") String sortDirection)
	{
		Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortBy));
			System.out.println(pageable);
			Page<Flight> flights = flightService.getAllFlights(pageable);
			List<Flight> flightsList = flights.getContent();
	  return new ResponseEntity(flights, HttpStatus.OK);
	}

}
