package controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.MainMartaSystem;
import application.popUps;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PaymentPageController implements Initializable{
	
    @FXML
    private Text usingMarta;

    @FXML
    private Button payBill;

    @FXML
    private Text prolongedStayText, billAmountTxt;
    
    @FXML
    private Stage stage;
    private AnchorPane root;
    private Scene scene;

    MainMartaSystem main = new MainMartaSystem();
    popUps popup = new popUps();
	

    public void payBill(ActionEvent event) throws Exception{
    	popup.billPaid();
        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        root = FXMLLoader.load(getClass().getClassLoader().getResource("view/TicketIndex.fxml"));
        scene = new Scene(root);
        stage.setScene(scene);
    }



	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		prolongedStayText.setText("Due to your prolonged stay for "+ MainMartaSystem.getDays()+" day(s)");
		billAmountTxt.setText("Your bill is $"+ MainMartaSystem.getDays()*8);
	}
    
}
