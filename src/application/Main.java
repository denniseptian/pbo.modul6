package application;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("JavaFX Welcome");
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		Scene scene = new Scene(grid, 320, 450);
		primaryStage.setScene(scene);

		Text scenetitle = new Text("Form Biodata");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(scenetitle, 0, 0, 2, 1);

		Label userNim = new Label("Nim:");
		grid.add(userNim, 0, 1);

		TextField userTextFieldNim = new TextField();
		grid.add(userTextFieldNim, 1, 1);

		Label userName = new Label("Nama:");
		grid.add(userName, 0, 2);

		TextField userTextFieldNama = new TextField();
		grid.add(userTextFieldNama, 1, 2);

		Label userFakultas = new Label("Fakultas:");
		grid.add(userFakultas, 0, 3);

		TextField userTextFieldFakultas = new TextField();
		grid.add(userTextFieldFakultas, 1, 3);

		Label userJurusan = new Label("Jurusan:");
		grid.add(userJurusan, 0, 4);

		TextField userTextFieldJurusan = new TextField();
		grid.add(userTextFieldJurusan, 1, 4);

		Label userAlamat = new Label("Alamat:");
		grid.add(userAlamat, 0, 5);

		TextField userTextFieldAlamat = new TextField();
		grid.add(userTextFieldAlamat, 1, 5);

		Label userKota = new Label("Kota:");
		grid.add(userKota, 0, 6);

		TextField userTextFieldKota = new TextField();
		grid.add(userTextFieldKota, 1, 6);

		Label userKodePos = new Label("Kode pos:");
		grid.add(userKodePos, 0, 7);

		TextField userTextFieldKodePos = new TextField();
		grid.add(userTextFieldKodePos, 1, 7);

		Label userHobby = new Label("Hobby:");
		grid.add(userHobby, 0, 8);

		TextField userTextFieldHobby = new TextField();
		grid.add(userTextFieldHobby, 1, 8);

		Button btnEdit = new Button("Edit");
		HBox hbBtnEdit = new HBox(10);
		hbBtnEdit.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtnEdit.getChildren().add(btnEdit);
		grid.add(hbBtnEdit, 0, 9);
		
		Button btnSave = new Button("Save");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_LEFT);
		hbBtn.getChildren().add(btnSave);
		grid.add(hbBtn, 1, 9);
		
		Button btnDelete = new Button("Dellete");
		HBox hbBtnDelete = new HBox(10);
		hbBtnDelete.setAlignment(Pos.BOTTOM_LEFT);
		hbBtnDelete.getChildren().add(btnDelete);
		grid.add(hbBtnDelete, 1, 10);
		
		Button btnShow = new Button("Show");
		HBox hbBtnShow = new HBox(10);
		hbBtnShow.setAlignment(Pos.BOTTOM_LEFT);
		hbBtnShow.getChildren().add(btnShow);
		grid.add(hbBtnShow, 1, 11);

		final Text actiontarget = new Text();
		grid.add(actiontarget, 1, 12);
		Processed processed = new Processed();
		
		btnSave.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				actiontarget.setFill(Color.FIREBRICK);
				
				if (userTextFieldKodePos.getText().matches("[0-9]+") && userTextFieldKodePos.getText().length() > 2) {

					processed.tambah(userTextFieldNim.getText(), userTextFieldNama.getText(),
							userTextFieldJurusan.getText(), userTextFieldJurusan.getText(),
							userTextFieldAlamat.getText(), userTextFieldKota.getText(), userTextFieldKodePos.getText(),
							userTextFieldHobby.getText());

				}else if(userTextFieldNim.getText().matches("[0-9]+") && (userTextFieldNim.getText().length() < 15 || userTextFieldNim.getText().length() > 15) ){
					JOptionPane.showMessageDialog(null, "Masukkan Nim dengan benar!");
				} else {
					JOptionPane.showMessageDialog(null, "Masukkan kode pos dengan benar!");
				}
			}
		});
		
		btnShow.setOnAction(new EventHandler<ActionEvent>() {
			 
		    @Override
		    public void handle(ActionEvent e) {
		        actiontarget.setFill(Color.FIREBRICK);
		        processed.show();
		    }
		});

		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}