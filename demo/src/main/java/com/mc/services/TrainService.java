package com.mc.services;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mc.models.Train;

/**
 * Service to get trains.
 * 
 * @author Nikitha Cholleti.
 *
 */
@Service
public class TrainService {

	public List<Train> getFilteredTrains() {
		List<Train> result = getTrains(null);
		return result;
	}

	/**
	 * Returns list of trains.Filters out the trains departing in the next 30 mins.
	 * 
	 * @param trains inputTrains list.
	 * @return result.
	 */
	private List<Train> getTrains(List<Train> trains) {
		List<Train> result = new ArrayList<>();

		// modify train departute time to timestamp;
		for (Train train : trains) {
			Timestamp timestamp = this.getTimeStamp(train.getDepartureTime().getHours(), train.getDepartureTime().getMinutes(),
					train.getDepartureTime().getSeconds());
			train.getDepartureTime().setTimestamp(timestamp);
		}

		// filter  trains departing in the next 30 mins.
		for (Train train : trains) {
			if (!isTrainDepartingInNextThirtyMin(train)) {
				result.add(train);
			}
		}
		
		Collections.sort(result, new TrainComparator());

		
		return result;
	}

	/**
	 * Helper method to check if the train is departing in next 30 mins
	 * 
	 * @param train
	 * @return
	 */
	private boolean isTrainDepartingInNextThirtyMin(Train train) {
		Timestamp trainTimeStamp = train.getDepartureTime().getTimestamp();

		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());

		long diffInMillis = trainTimeStamp.getTime() - currentTimestamp.getTime();
		long diffInMinutes = diffInMillis / (60 * 1000);

		return diffInMinutes <= 30;
	}

	/**
	 * Helper method to convert to timestamp.
	 * 
	 * @param hours   hours of the train.
	 * @param minutes mins of the train.
	 * @param seconds sec of the train.
	 * @return
	 */
	private Timestamp getTimeStamp(int hours, int minutes, int seconds) {
		// Get the current timestamp
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());

		// Set the provided hours, minutes, and seconds
		currentTimestamp.setHours(hours);
		currentTimestamp.setMinutes(minutes);
		currentTimestamp.setSeconds(seconds);

		return currentTimestamp;

	}
}
