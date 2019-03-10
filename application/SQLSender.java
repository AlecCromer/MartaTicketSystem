package application;

import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class SQLSender {


	keyGenerator keyGen = new keyGenerator();
	popUps popup = new popUps();
	MainMartaSystem main = new MainMartaSystem();
	
	// photo gets sent to database as a blob
	public void sendStringToDatabase(String key) throws SQLException, FileNotFoundException {

		LocalDateTime currentTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	    String formatDateTime = currentTime.format(formatter);

		// generates query into the martadatabase table
		String query = "INSERT INTO `carinfo` (`carKey`, `date`)" + " VALUES (?, ?)";

		// insert preparedstatement into database
		PreparedStatement preparedStmt = null;
		try {
			preparedStmt = DatabaseConnector.getConnection().prepareStatement(query);

			preparedStmt.setString(1, key);
			preparedStmt.setString(2, formatDateTime);
			preparedStmt.execute();

			popup.TicketPopUp(key);

		} catch (SQLException e) {
			e.printStackTrace();
			
			// If the key SOMEHOW exists already, it will generate a new key, and retry. (very unlikely).
			preparedStmt.close();
			sendStringToDatabase(keyGen.StringKey());
		} finally {
			preparedStmt.close();

		}

	}

	public boolean checkMartaDatabase(String key) throws SQLException, ParseException {
		
		// checks if the user left something blank
		if (key.isEmpty()) {

			popup.keyError();
		} else {
			String carKey = "SELECT carKey FROM carinfo WHERE carKey = '" + key + "';";
			PreparedStatement preparedStmt;
			preparedStmt = DatabaseConnector.getConnection().prepareStatement(carKey);
			ResultSet result = preparedStmt.executeQuery();
			if (result.next()) {
				System.out.println("Data was found");
				preparedStmt.close();
				
				
				//calculate how much they owe
				String date = "SELECT date FROM carinfo WHERE carKey = '" + key + "';";
				preparedStmt = DatabaseConnector.getConnection().prepareStatement(date);
				result = preparedStmt.executeQuery();
				if (result.next()) {
					main.calculateAmount(result.getString(1));
					return true;
				}
			} else {
			popup.keyError();

			}
		}
		return false;
	}

}
