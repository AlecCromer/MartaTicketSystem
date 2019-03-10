package controller;

import application.SQLSender;
import application.keyGenerator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class TicketIndexController {
	@FXML
	private Button takeTicket;

	@FXML
	private Button insertTicket;
	
	@FXML
	private TextField keyEntry;
	
    @FXML
    private PasswordField password;
    private Stage stage;
    private AnchorPane root;
    private Scene scene;
    @FXML
    private Node anyNode ;
    

	keyGenerator keyGen = new keyGenerator();
	SQLSender sql = new SQLSender();

	
	public void newTicket(ActionEvent event) throws Exception {

		sql.sendStringToDatabase(keyGen.StringKey());
		
	}
	

	public void submitPressed(ActionEvent event) throws Exception {

		if(sql.checkMartaDatabase(keyEntry.getText()) == true) {
	        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
	        root = FXMLLoader.load(getClass().getClassLoader().getResource("view/paymentPage.fxml"));
	        scene = new Scene(root);
	        stage.setScene(scene);
		}
		
		
	}
}
