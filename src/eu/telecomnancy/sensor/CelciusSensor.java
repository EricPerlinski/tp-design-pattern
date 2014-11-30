package eu.telecomnancy.sensor;


public class CelciusSensor extends SensorDecorator {
	
	private String Unit ="°C";
	
	public CelciusSensor(AbstractSensor tmp) {
		super(tmp);
	}
	
	public double getValue() throws SensorNotActivatedException {
			return tempSensor.getValue() /1.8;
	}

	public String getUnit() {
		return Unit;
	}
	
	public FahrenheitSensor changeUnit(){
		return new FahrenheitSensor(this);
	}

}
