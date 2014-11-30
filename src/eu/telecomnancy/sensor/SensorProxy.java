package eu.telecomnancy.sensor;

import java.util.Observable;



/**
 * Created with IntelliJ IDEA.
 * User: charoy
 * Date: 13/12/13
 * Time: 18:07
 */
public class SensorProxy extends Observable implements ISensor {
    private RoundRawDecorator sensor;
    private SensorLogger log;

    public SensorProxy(RoundRawDecorator _sensor, SensorLogger sensorLogger) {
        sensor = _sensor;
        log = sensorLogger;
    }
    
    public void changeUnit(){
    	this.sensor = this.sensor.changeUnit();
    	log.log(LogLevel.INFO, "Sensor has just changed its unit system to "+this.sensor.getUnit());
    	setChanged();
        notifyObservers();
    }
    
    public void roundUnit(){
    	this.sensor = this.sensor.changeRound();
    	log.log(LogLevel.INFO, "Sensor has just changed its round system to " +this.sensor.getRoundSystem());
    	setChanged();
        notifyObservers();
    }
    
    public String getUnit(){
    	return this.sensor.getUnit();
    }
    @Override
    public void on() {
        log.log(LogLevel.INFO, "Sensor On");
        sensor.on();
        setChanged();
        notifyObservers();
    }

    @Override
    public void off() {
        log.log(LogLevel.INFO, "Sensor Off");
        sensor.off();
        setChanged();
        notifyObservers();
    }

    @Override
    public boolean getStatus() {
        log.log(LogLevel.INFO, "Sensor getStatus");
        return sensor.getStatus();
    }

    @Override
    public void update() throws SensorNotActivatedException {
        log.log(LogLevel.INFO, "Sensor update");
        sensor.update();
        setChanged();
        notifyObservers();
    }

    @Override
    public double getValue() throws SensorNotActivatedException {
        log.log(LogLevel.INFO, "Sensor value =" + sensor.getValue());
        return sensor.getValue();
    }
}
