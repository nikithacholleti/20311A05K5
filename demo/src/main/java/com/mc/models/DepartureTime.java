package com.mc.models;

import java.sql.Timestamp;

/**
 * Model class for departure time.
 * 
 * @author Nikitha Cholleti.
 *
 */
public class DepartureTime {

	private int hours;
	
	private int minutes;

	private int seconds;
	
	private Timestamp timestamp;

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public int getSeconds() {
		return seconds;
	}

	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}
}
