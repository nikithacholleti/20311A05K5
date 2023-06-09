package com.mc.models;

/**
 * Model class for train.
 * 
 * @author Nikitha Cholleti.
 *
 */
public class Train {

	private String trainName;
	
	private String trainNumber;

	private DepartureTime departureTime;

	private SeatsAvailable seatsAvailable;
	
	private Price price;

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	private int delayedBy;

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public String getTrainNumber() {
		return trainNumber;
	}

	public void setTrainNumber(String trainNumber) {
		this.trainNumber = trainNumber;
	}

	public DepartureTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(DepartureTime departureTime) {
		this.departureTime = departureTime;
	}

	public SeatsAvailable getSeatsAvailable() {
		return seatsAvailable;
	}

	public void setSeatsAvailable(SeatsAvailable seatsAvailable) {
		this.seatsAvailable = seatsAvailable;
	}

	public int getDelayedBy() {
		return delayedBy;
	}

	public void setDelayedBy(int delayedBy) {
		this.delayedBy = delayedBy;
	}

}
