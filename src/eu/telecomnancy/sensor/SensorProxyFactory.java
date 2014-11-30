package eu.telecomnancy.sensor;

import java.io.IOException;
import java.util.Properties;

import eu.telecomnancy.helpers.ReadPropertyFile;


/**
 * Created with IntelliJ IDEA.
 * User: charoy
 * Date: 13/12/13
 * Time: 19:33
 */
public class SensorProxyFactory extends SensorFactory {
    @Override
    
    
    
    
    public SensorProxy getSensor() {
    	
    	ReadPropertyFile rp = new ReadPropertyFile();
        Properties p = null;
        try {
            p = rp.readFile("/eu/telecomnancy/sensor.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
        String sensorname = p.getProperty("sensor");
        System.out.println("Name = " +sensorname);
    	
    	try {
			return new SensorProxy(new NotRoundSensor(new CelciusSensor( (AbstractSensor) Class.forName(sensorname).newInstance())),new SimpleSensorLogger());
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }
    	
}
    	
  
