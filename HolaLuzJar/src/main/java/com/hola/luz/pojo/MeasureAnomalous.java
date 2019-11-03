package com.hola.luz.pojo;

public class MeasureAnomalous extends Measure {

	Double median;

	public MeasureAnomalous(Measure measure, double median){
				
		this.setClient(measure.getClient());
		this.setPeriod(measure.getPeriod());
		this.setReading(measure.getReading());
		
		this.median = median;
	}

	public Double getMedian() {
		return median;
	}

	public void setMedian(Double median) {
		this.median = median;
	}

	@Override
	public boolean equals(Object obj) {
		
		if (! super.equals(obj))
			return false;
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MeasureAnomalous other = (MeasureAnomalous) obj;
		if (median == null) {
			if (other.median != null)
				return false;
		} else if (!median.equals(other.median))
			return false;
		return true;
	}
	
	
}
