package application;

import javax.swing.*;

public class popUps {
	JFrame f = new JFrame();

	public void TicketPopUp(String stringKey) {
		final JDialog dialog = new JDialog();
		dialog.setAlwaysOnTop(true);
		JOptionPane.showMessageDialog(dialog,
				"Your ticket number is: " + stringKey
						+ "\n\n Remember that your first 24 hours of parking are free. Any extra days incur an $8 fee.",
				"Marta Alert", JOptionPane.WARNING_MESSAGE);

		System.out.println("User requested a ticket");
	}

	public void insertInputDialog() {}

	public void keyError() {
		final JDialog dialog = new JDialog();
		dialog.setAlwaysOnTop(true);  
		JOptionPane.showMessageDialog(dialog, "I'm sorry, but we could not locate that ticket number, please try again",
				"Ticket Alert", JOptionPane.WARNING_MESSAGE);

	}
	public void billPaid() {
		final JDialog dialog = new JDialog();
		dialog.setAlwaysOnTop(true);  
		JOptionPane.showMessageDialog(dialog, "Thank you for visiting Marta",
				"Bill Paid", JOptionPane.WARNING_MESSAGE);

	}
	
}