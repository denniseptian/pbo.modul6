package startup;

import javax.swing.JOptionPane;

import application.Main;
import model.SQLiteJDBCDriverConnection;

public class AppStart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (SQLiteJDBCDriverConnection.connect() == false) {
			JOptionPane.showMessageDialog(null,
					"Runing application without database, data will not stored permanenly!");
		}

		Main.main(null);
	}

}
