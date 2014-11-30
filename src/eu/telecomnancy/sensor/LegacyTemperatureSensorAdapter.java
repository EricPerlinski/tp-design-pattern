package eu.telecomnancy.sensor;


public class LegacyTemperatureSensorAdapter extends AbstractSensor {

	private LegacyTemperatureSensor sensor = new LegacyTemperatureSensor();
	private double val;

	@Override
	public void on() {
		if(!(sensor.getStatus())){
			sensor.onOff();
			setChanged();
	        notifyObservers();
		}
		
	}

	@Override
	public void off() {
		if(sensor.getStatus()){
			sensor.onOff();
			setChanged();
	        notifyObservers();
		}
	}

	@Override
	public boolean getStatus() {
		return sensor.getStatus();
	}

	@Override
	public void update() throws SensorNotActivatedException {
		if(!(sensor.getStatus())){
			throw new SensorNotActivatedException("Capteur éteint");
		}else{
			setVal(sensor.getTemperature());
			setChanged();
	        notifyObservers();
		}
	}

	@Override
	public double getValue() throws SensorNotActivatedException {
		if(!(sensor.getStatus())){
			throw new SensorNotActivatedException("Capteur éteint");
		}
		return getVal();
	}

	public LegacyTemperatureSensor getSensor() {
		return sensor;
	}

	public void setSensor(LegacyTemperatureSensor sensor) {
		this.sensor = sensor;
	}

	public double getVal() {
		return val;
	}

	public void setVal(double val) {
		this.val = val;
	}
	
}
