package eu.telecomnancy.sensor;


public class NotRoundSensor extends RoundRawDecorator {
	
	private String RS = "Raw";
	
	public NotRoundSensor(SensorDecorator tmp){
		super(tmp);
	}
	
	public NotRoundSensor(RoundRawDecorator tmp) {
		super(tmp.tempSensor);
	}

	public double getValue() throws SensorNotActivatedException {
			return tempSensor.getValue();
	}
	
	public String GetUnit(){
		return this.tempSensor.getUnit();
	}
	
	public RoundSensor changeRound(){
		return new RoundSensor(tempSensor);
	}
	
	public String getRoundSystem(){
		return RS;
	}
	
}
