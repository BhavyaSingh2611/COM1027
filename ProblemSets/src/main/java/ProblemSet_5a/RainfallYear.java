package ProblemSet_5a;

import java.util.Arrays;
import java.util.HashMap;

public class RainfallYear {
	private int year = 0;
	private double[] rainfallMonths = {};
	
	public RainfallYear(int year) {
		this.year = year;
		this.rainfallMonths = Arrays.copyOf(rainfallMonths, 12);
	}

	public double calculateMeanRainfall() {
		double sum = 0;
		for (int i = 0; i < rainfallMonths.length; i++) {
			sum += rainfallMonths[i];
		}
		return sum / 12;
	}

	public int getYear() {
		return year;
	}

	public void enterData(double[] data) {
		rainfallMonths = data;
	}

	public double getRainfallMonth(String month) {
	    HashMap<String, Integer> months = new HashMap<>();
	    months.put("JANUARY", 0);
	    months.put("FEBRUARY", 1);
	    months.put("MARCH", 2);
	    months.put("APRIL", 3);
	    months.put("MAY", 4);
	    months.put("JUNE", 5);
	    months.put("JULY", 6);
	    months.put("AUGUST", 7);
	    months.put("SEPTEMBER", 8);
	    months.put("OCTOBER", 9);
	    months.put("NOVEMBER", 10);
	    months.put("DECEMBER", 11);
	    
	    
		return rainfallMonths[months.get(month)];
	}

	public double calculateHighestRainfall() {
		double max = 0;
		for (int i = 0; i < rainfallMonths.length; i++) {
			if (rainfallMonths[i] > max) {
				max = rainfallMonths[i];
			}
		}
		return max;
	}
}
