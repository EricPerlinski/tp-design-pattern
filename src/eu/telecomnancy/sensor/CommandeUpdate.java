package eu.telecomnancy.sensor;

public class CommandeUpdate implements Command{

	SensorProxy sensor;
	
	public CommandeUpdate (SensorProxy newSensor){
		sensor = newSensor;
	}
	
	public void execute() {
		try {
			sensor.update();
		} catch (SensorNotActivatedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}