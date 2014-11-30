package eu.telecomnancy.sensor;


public class SensorOff implements SensorState {
	public TemperatureSensor sensor;
	public SensorOff(TemperatureSensor sensor){
		this.sensor = sensor;
	}

	public void update() throws SensorNotActivatedException {
		throw new SensorNotActivatedException("Sensor needs to be activated before used");
	}

	public boolean getStatus() {
		return false;
	}

	@Override
	public double getValue() throws SensorNotActivatedException {

        throw new SensorNotActivatedException("Sensor must be activated to get its value.");
    
	}
	
}


