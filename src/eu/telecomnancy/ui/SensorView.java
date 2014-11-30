package eu.telecomnancy.ui;

import eu.telecomnancy.sensor.CommandeChangeRound;
import eu.telecomnancy.sensor.CommandeChangeUnit;
import eu.telecomnancy.sensor.CommandeOff;
import eu.telecomnancy.sensor.CommandeOn;
import eu.telecomnancy.sensor.CommandeUpdate;
import eu.telecomnancy.sensor.SensorButton;
import eu.telecomnancy.sensor.SensorNotActivatedException;
import eu.telecomnancy.sensor.SensorProxy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class SensorView extends JPanel implements Observer{
    
	private static final long serialVersionUID = -8002171911539324642L;

	private SensorProxy sensor;

    private JLabel value = new JLabel("N/A °C");
    private JButton on = new JButton("On");
    private JButton off = new JButton("Off");
    private JButton update = new JButton("Acquire");
    private JButton changeUnit = new JButton("C° / F°");
    private JButton roundUnit = new JButton("= / ~");
    private CommandeOn COn; 
    private CommandeOff COff; 
    private CommandeUpdate CUpd;
    private CommandeChangeUnit Ccu; 
    private CommandeChangeRound Ccr;
    private SensorButton SB;
    
    public SensorView(SensorProxy c) {
        this.sensor = c;
        this.sensor.addObserver(this);
        COn = new CommandeOn(sensor);
        COff = new CommandeOff(sensor);
        CUpd = new CommandeUpdate(sensor);
        Ccu = new CommandeChangeUnit(sensor);
        Ccr = new CommandeChangeRound(sensor);
        this.setLayout(new BorderLayout());

        value.setHorizontalAlignment(SwingConstants.CENTER);
        Font sensorValueFont = new Font("Sans Serif", Font.BOLD, 18);
        value.setFont(sensorValueFont);

        this.add(value, BorderLayout.CENTER);


        on.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SB = new SensorButton(COn);
                SB.press();
            }
        });

        off.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	SB = new SensorButton(COff);
                SB.press();
            }
        });

        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SB = new SensorButton(CUpd);
                SB.press();
            }
        });
        
        changeUnit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	SB = new SensorButton(Ccu);
                SB.press();
            }
        });
        
        roundUnit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	SB = new SensorButton(Ccr);
                SB.press();
            }
        });

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1, 5));
        buttonsPanel.add(update);
        buttonsPanel.add(on);
        buttonsPanel.add(off);
        buttonsPanel.add(changeUnit);
        buttonsPanel.add(roundUnit);

        this.add(buttonsPanel, BorderLayout.SOUTH);
    }

	@Override
	public void update(Observable arg0, Object arg1) {
		
		if(!(this.sensor.getStatus())){
			this.value.setText("N/A" + (this.sensor.getUnit()));
		}else{
			try {
				this.value.setText((Double.toString(this.sensor.getValue())) + this.sensor.getUnit());
			} catch (SensorNotActivatedException e) {
				
			}
		}
	}

	public JButton getChangeUnit() {
		return changeUnit;
	}

	public void setChangeUnit(JButton changeUnit) {
		this.changeUnit = changeUnit;
	}
}
