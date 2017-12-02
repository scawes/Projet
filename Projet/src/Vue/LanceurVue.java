package Vue;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class LanceurVue extends Application {
  
	static LanceurVue vue = new LanceurVue();
	  
	  public void lancer(String[] args) {
	    launch(args); //lancement via un thread
	  }
	  
	  @Override
	  public void start(Stage stage) throws Exception {
	    stage.setTitle("Fourmiliere");
	    
	    Parent root = FXMLLoader.load(getClass().getResource("InterfaceFourmi.fxml"));
	    System.out.println("Test");
	    Scene scene = new Scene(root);
	    stage.setScene(scene);
	    stage.show();
	  }
	  
	  public static LanceurVue getVue() {
	    return vue;
	  }
	  

	  
}