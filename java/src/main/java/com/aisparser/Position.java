package com.aisparser;
/**
 * AIS Parser SDK
 * AIS Position Class
 * Copyright 2008 by Brian C. Lane <bcl@brianlane.com>
 * All Rights Reserved
 * 
 * @author Brian C. Lane
 */


/**
 * AIS Position class
 * 
 * Stores raw AIS position
 * and provide helper methods for other converting to degrees
 * 
 */
public class Position {
	private double	factor;
	private long	longitude;
	private long	latitude;

	public Position(double factor)
	{
		this.factor = factor;
	}

	public void setLongitude( long raw_longitude )
	{
		this.longitude = raw_longitude;
	}

	public void setLatitude( long raw_latitude )
	{
		this.latitude = raw_latitude;
	}

	public Double getLongitudeDeg() {
		return this.longitude / factor;
	}

	public Double getLatitudeDeg() {
		return this.latitude / factor;
	}

	public long longitude()
	{
		return this.longitude;
	}

	public long latitude()
	{
		return this.latitude;
	}
}
