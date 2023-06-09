package com.mc.services;

import java.util.*;

import com.mc.models.Train;

/**
 * Comparator to sort the trains
 * 
 * @author Nikitha Cholleti.
 *
 */
public class TrainComparator implements Comparator<Train> {
	@Override
	public int compare(Train train1, Train train2) {
		// Compare sleeper prices in ascending order
		int priceComparison = Integer.compare(train1.getPrice().getSleeperPrice(), train2.getPrice().getSleeperPrice());
		if (priceComparison != 0) {
			return priceComparison;
		}

		// Compare ac prices in ascending order
		int acPriceComparison = Integer.compare(train1.getPrice().getAcPrice(), train2.getPrice().getAcPrice());
		if (priceComparison != 0) {
			return acPriceComparison;
		}

		// Compare departure timestamps in descending order
		int departureComparison = train2.getDepartureTime().getTimestamp()
				.compareTo(train1.getDepartureTime().getTimestamp());
		if (departureComparison != 0) {
			return departureComparison;
		}

		// Compare sleeper seats in descending order
		int seatComparisonSleeper = Integer.compare(train2.getSeatsAvailable().getSleeper(),
				train1.getSeatsAvailable().getSleeper());

		if (seatComparisonSleeper != 0) {
			return seatComparisonSleeper;
		}

		// finally compare ac seats;
		return Integer.compare(train2.getSeatsAvailable().getAc(), train1.getSeatsAvailable().getAc());
	}
}
