package eu.telecomnancy.sensor;

public class CommandeChangeRound implements Command{

	SensorProxy sensor;
		
	public CommandeChangeRound (SensorProxy newSensor){
		sensor = newSensor;
	}
		
	public void execute() {
		sensor.roundUnit();
	}

}

