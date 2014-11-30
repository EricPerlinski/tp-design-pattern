package eu.telecomnancy.sensor;

public class SensorButton {

	 Command commande;
	 
	 public SensorButton(Command newCommand){
		 
		 commande = newCommand;
		 
	 }
	 
	 public void press(){
		 commande.execute();
	 }

}
