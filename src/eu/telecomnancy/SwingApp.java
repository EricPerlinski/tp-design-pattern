package eu.telecomnancy;

import eu.telecomnancy.sensor.SensorProxyFactory;
import eu.telecomnancy.sensor.SensorProxy;
import eu.telecomnancy.ui.MainWindow;

public class SwingApp {

    public static void main(String[] args) {
    	SensorProxyFactory SPF = new SensorProxyFactory(); 
    	SensorProxy sens = SPF.getSensor();
        
        new MainWindow(sens);
    }

}
