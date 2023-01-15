package entities;

public class OutsourcedEmployee extends Employee{
	private Double adittionalCharge;
	
	public OutsourcedEmployee(String name, Integer hours, Double valuePerHour, Double adittionalCharge) {
		super(name, hours, valuePerHour);
		this.adittionalCharge = adittionalCharge;
	}
	
	public OutsourcedEmployee() {
		super();
	}

	@Override
	public Double payment() {
		 return super.payment() + (adittionalCharge * 1.1);
	}
	
	public Double getAdittionalCharge() {
		return adittionalCharge;
	}

	public void setAdittionalCharge(Double adittionalCharge) {
		this.adittionalCharge = adittionalCharge;
	}
}
