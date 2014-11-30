package eu.telecomnancy.sensor;

public class CommandeOn implements Command{

	SensorProxy sensor;
	
	public CommandeOn (SensorProxy newSensor){
		sensor = newSensor;
	}
	
	public void execute() {
		sensor.on();
	}

}
