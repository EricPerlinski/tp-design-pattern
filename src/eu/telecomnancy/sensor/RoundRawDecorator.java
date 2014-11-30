package eu.telecomnancy.sensor;


abstract class RoundRawDecorator extends AbstractSensor {

	protected SensorDecorator tempSensor;
	
	public RoundRawDecorator(SensorDecorator tmp){
		this.tempSensor = tmp;
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
		return tempSensor.getUnit();
	}
	
	public String getRoundSystem(){
		return "";
	}
	
	public RoundRawDecorator changeUnit(){
		this.tempSensor = tempSensor.changeUnit();
		return this;
	}

	public RoundRawDecorator changeRound() {
		return null;
	}

}
