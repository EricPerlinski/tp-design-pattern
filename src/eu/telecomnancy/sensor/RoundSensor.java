package eu.telecomnancy.sensor;


public class RoundSensor extends RoundRawDecorator {

	private String RS = "Round";
	
	public RoundSensor(SensorDecorator tmp){
		super(tmp);
	}
	
	public RoundSensor(RoundRawDecorator tmp){
		super(tmp.tempSensor);
	}

	public double getValue() throws SensorNotActivatedException {
			return Math.round(this.tempSensor.getValue());
	}
	
	public String GetUnit(){
		return this.tempSensor.getUnit();
	}
	
	public NotRoundSensor changeRound(){
		return new NotRoundSensor(tempSensor);
	}
	
	public String getRoundSystem(){
		return RS;
	}
	
}
