package eu.telecomnancy.sensor;


public class TemperatureSensor extends AbstractSensor  {
    SensorState state;
    double value = 0;
    
    public TemperatureSensor (){
    	this.state =  new SensorOff(this);
    	
    }

    @Override
    public void on() {
        state = new SensorOn(this);
    }

    @Override
    public void off() {
        state = new SensorOff(this);
    }

    @Override
    public boolean getStatus() {
        return state.getStatus();
    }

    @Override
    public void update() throws SensorNotActivatedException {
        state.update();
    }

    @Override
    public double getValue() throws SensorNotActivatedException {
    	try {
    		return state.getValue();
    	}finally{
    		
    	}
    }

}
