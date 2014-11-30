package eu.telecomnancy.sensor;

public class CommandeGetValue implements Command{

	SensorProxy sensor;
		
	public CommandeGetValue (SensorProxy newSensor){
		sensor = newSensor;
	}
		
	public void execute()  {
		try {
			sensor.getValue();
		} catch (SensorNotActivatedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

