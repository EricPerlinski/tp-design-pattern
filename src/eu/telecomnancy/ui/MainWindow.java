package eu.telecomnancy.ui;

import eu.telecomnancy.sensor.SensorProxy;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SensorProxy sensor;
    private SensorView sensorView;

    public MainWindow(SensorProxy sensor) {
        this.sensor = sensor;
        this.sensorView = new SensorView(this.sensor);
        
        this.setLayout(new BorderLayout());
        this.add(this.sensorView, BorderLayout.CENTER);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }


}
