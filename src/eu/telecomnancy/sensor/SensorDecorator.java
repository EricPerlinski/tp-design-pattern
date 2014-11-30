package eu.telecomnancy.sensor;


abstract class SensorDecorator extends AbstractSensor {

	protected AbstractSensor tempSensor;
	
	
	public SensorDecorator(AbstractSensor tmp){
		tempSensor = tmp;
	}
	
	public void on() {
		tempSensor.on();
	}

	public void off() {
		tempSensor.off();

	}

	public boolean getStatus() {
		return tempSensor.getStatus();
	}

	public void update() throws SensorNotActivatedException {
		tempSensor.update();
	}

	public double getValue() throws SensorNotActivatedException {
		return tempSensor.getValue();
	}
	
	public String getUnit(){
		return "";
	}
	
	public String getRoundSystem(){
		return "";
	}
	
	public SensorDecorator changeUnit(){
		return null;
		
	}

	public SensorDecorator changeRound() {
		return null;
	}

}
