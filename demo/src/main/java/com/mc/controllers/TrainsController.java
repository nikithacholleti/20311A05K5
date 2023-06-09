package com.mc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mc.models.Train;
import com.mc.services.TrainService;

/**
 * Rest controller for the trains API.
 * 
 * @author Nikitha Cholleti.
 *
 */
@RestController
public class TrainsController {

	/**
	 * Service to get the trains.
	 */
	@Autowired
	private TrainService trainService;

	/**
	 * Returns filters trains.
	 * @return train list
	 */
	@GetMapping("/trains")
	public List<Train> getTrains() {
		return trainService.getFilteredTrains();
	}
}
