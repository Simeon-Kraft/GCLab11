package lab11;

public class UsedCar extends Car {
	private double mileage;
	
	public UsedCar() {}
	
	public UsedCar(String make, String model, int year, double price, double mileage) {
		super(make, model, year, price);
		this.mileage = mileage;
	}
	
	public UsedCar(double mileage) {
		this.mileage = mileage;
	}
	
	@Override
	public String toString() {
		return String.format("%-6s %9s %17d %12s %.3f %14s %.3f %-9s", getMake(), getModel(), getYear(), "$", getPrice(), "(Used)", mileage, "miles");
	}
}
