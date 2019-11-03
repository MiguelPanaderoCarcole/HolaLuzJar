package com.hola.luz.pojo;

public class Measure {

	String client;
	
	String period;
		
	Long reading;

	public Measure() {
		
	};
	
	public Measure(String client, String period, Long reading) {
		
		this.client = client;
		this.period = period;
		this.reading = reading;	
	}
	
	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public Long getReading() {
		return reading;
	}

	public void setReading(Long reading) {
		this.reading = reading;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Measure [client=");
		builder.append(client);
		builder.append(", period=");
		builder.append(period);
		builder.append(", reading=");
		builder.append(reading);
		builder.append("]");
		return builder.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Measure other = (Measure) obj;
		if (client == null) {
			if (other.client != null)
				return false;
		} else if (!client.equals(other.client))
			return false;
		if (period == null) {
			if (other.period != null)
				return false;
		} else if (!period.equals(other.period))
			return false;
		if (reading == null) {
			if (other.reading != null)
				return false;
		} else if (!reading.equals(other.reading))
			return false;
		return true;
	}
	
	
}
