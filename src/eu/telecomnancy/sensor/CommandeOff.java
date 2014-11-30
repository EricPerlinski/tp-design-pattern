package eu.telecomnancy.sensor;

public class CommandeOff implements Command{

	SensorProxy sensor;
	
	public CommandeOff (SensorProxy newSensor){
		sensor = newSensor;
	}
	
	public void execute() {
		sensor.off();
	}

}