package application;

import java.text.ParseException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainMartaSystem extends Application {

	private static int days;

	@Override
	public void start(Stage primaryStage) {
		try {

			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/TicketIndex.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("Marta Ticket System");
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);

	}

	public void calculateAmount(String string) throws ParseException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		int i = 0;

		LocalDateTime stringFormatted = LocalDateTime.parse(string, formatter);
		Duration durationBetween = Duration.between(stringFormatted, LocalDateTime.now());
		
		if (durationBetween.compareTo(Duration.ofDays(1)) < 1) {
			System.out.println("It has been less than 1 day");
		} else {
			while(durationBetween.compareTo(Duration.ofDays(i)) > 0) {
				System.out.println("up");
				i++;
				
			}
			
			System.out.println(i);
			setDays(i);
			
		}

	}

	private void setDays(int i) {
		days = i;

	}


	public static int getDays() {
		return days;
	}

}
