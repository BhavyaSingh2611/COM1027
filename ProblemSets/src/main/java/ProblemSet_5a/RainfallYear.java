package ProblemSet_5a;

public class RainfallYear {
	private int year = 0;
	private double[] rainfallMonths = null;

	public RainfallYear(int year) {
		super();
		this.year = year;
		this.rainfallMonths = new double[12];
	}

	public double calculateMeanRainfall() {
		double sum = 0;
        for (double rainfallMonth : this.rainfallMonths) {
            sum += rainfallMonth;
        }
		return sum / this.rainfallMonths.length;
	}

	public int getYear() {
		return this.year;
	}

	public void enterData(double[] data) {
		this.rainfallMonths = data;
	}

	public double getRainfallMonth(String month) {
	    /* I tried to implement it using hashmap later realizing that we had
	    to use switch case
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
		return rainfallMonths[months.get(month)];*/

        int index = switch (month) {
            case "JANUARY" -> 0;
            case "FEBRUARY" -> 1;
            case "MARCH" -> 2;
            case "APRIL" -> 3;
            case "MAY" -> 4;
            case "JUNE" -> 5;
            case "JULY" -> 6;
            case "AUGUST" -> 7;
            case "SEPTEMBER" -> 8;
            case "OCTOBER" -> 9;
            case "NOVEMBER" -> 10;
            case "DECEMBER" -> 11;
            default -> -1;
        };
        return rainfallMonths[index];
	}

	public double calculateHighestRainfall() {
		double max = 0;
        for (double rainfallMonth : this.rainfallMonths) {
            if (rainfallMonth > max) {
                max = rainfallMonth;
            }
        }
		return max;
	}
}
