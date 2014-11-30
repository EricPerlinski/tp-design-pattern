package eu.telecomnancy.sensor;

public class CommandeChangeUnit implements Command{

	SensorProxy sensor;
		
	public CommandeChangeUnit (SensorProxy newSensor){
		sensor = newSensor;
	}
		
	public void execute(){
		sensor.changeUnit();
	}

}

