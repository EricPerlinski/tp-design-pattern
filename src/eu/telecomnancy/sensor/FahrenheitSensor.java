package eu.telecomnancy.sensor;

public class FahrenheitSensor extends SensorDecorator {
	
	private String Unit ="°F";
	
	public FahrenheitSensor(AbstractSensor tmp) {
		super(tmp);
	}
	
	public void off() {
		tempSensor.off();

	}

	public boolean getStatus() {
		return tempSensor.getStatus();
	}

	public void update() throws SensorNotActivatedException {
		tempSensor.update();
	}

	public double getValue() throws SensorNotActivatedException {
		return ((tempSensor.getValue())*1.8);
	}

	public String getUnit() {
		return Unit;
	}
	
	public CelciusSensor changeUnit(){
		return new CelciusSensor(this);
	}
}
