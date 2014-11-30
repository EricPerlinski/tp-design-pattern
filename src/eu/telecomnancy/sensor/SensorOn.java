package eu.telecomnancy.sensor;

import java.util.Random;


public class SensorOn implements SensorState {
	public TemperatureSensor sensor;
	public SensorOn(TemperatureSensor sensor){
		this.sensor = sensor;
	}

	public void update() throws SensorNotActivatedException{
		this.sensor.value = (new Random()).nextDouble() * 100;
	}

	public boolean getStatus() {
		return true;
	}

	@Override
	public double getValue() throws SensorNotActivatedException {
        	return this.sensor.value;
	}
}
