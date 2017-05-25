package application;


import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
	Processed processed = new Processed();

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Form");
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

		Button btnSave = new Button("Save");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_LEFT);
		hbBtn.getChildren().add(btnSave);
		grid.add(hbBtn, 1, 9);

		Button btnShow = new Button("Show");
		HBox hbBtnShow = new HBox(10);
		hbBtnShow.setAlignment(Pos.BOTTOM_LEFT);
		hbBtnShow.getChildren().add(btnShow);
		grid.add(hbBtnShow, 0, 9);

		final Text actiontarget = new Text();
		grid.add(actiontarget, 1, 12);

		btnSave.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				actiontarget.setFill(Color.FIREBRICK);

				if (userTextFieldKodePos.getText().matches("[0-9]+") && userTextFieldKodePos.getText().length() > 2) {

					processed.tambah(userTextFieldNim.getText(), userTextFieldNama.getText(),
							userTextFieldJurusan.getText(), userTextFieldJurusan.getText(),
							userTextFieldAlamat.getText(), userTextFieldKota.getText(), userTextFieldKodePos.getText(),
							userTextFieldHobby.getText());

				} else if (userTextFieldNim.getText().matches("[0-9]+")
						&& (userTextFieldNim.getText().length() < 15 || userTextFieldNim.getText().length() > 15)) {
					JOptionPane.showMessageDialog(null, "Masukkan Nim dengan benar!");
				} else {
					JOptionPane.showMessageDialog(null, "Masukkan kode pos dengan benar!");
				}
				
			}
		});

		btnShow.setOnAction(new EventHandler<ActionEvent>() {

			@SuppressWarnings("unchecked")
			@Override
			public void handle(ActionEvent e) {
				actiontarget.setFill(Color.FIREBRICK);

				Pane stackPane = new Pane();
				Scene scene = new Scene(stackPane, 500, 435);

				Stage secondStage = new Stage();
				secondStage.setTitle("Data");
				secondStage.setScene(scene);
				secondStage.setResizable(false);

				TableView<Mahasiswa> table = new TableView<>();
				table.setPrefWidth(1f * stackPane.getWidth() + 10);
				table.setEditable(true);

				TableColumn<Mahasiswa, String> nimColum = new TableColumn<>("Nim");
				nimColum.prefWidthProperty().bind(table.widthProperty().multiply(0.2));
				nimColum.setCellValueFactory(new PropertyValueFactory<Mahasiswa, String>("nim"));

				TableColumn<Mahasiswa, String> nameColum = new TableColumn<>("Nama");
				nameColum.prefWidthProperty().bind(table.widthProperty().multiply(0.3));
				nameColum.setCellValueFactory(new PropertyValueFactory<Mahasiswa, String>("nama"));

				TableColumn<Mahasiswa, String> jurusanColum = new TableColumn<>("Jurusan");
				jurusanColum.prefWidthProperty().bind(table.widthProperty().multiply(0.2));
				jurusanColum.setCellValueFactory(new PropertyValueFactory<Mahasiswa, String>("jurusan"));

				TableColumn<Mahasiswa, String> AlamatColum = new TableColumn<>("Alamat");
				AlamatColum.prefWidthProperty().bind(table.widthProperty().multiply(0.3));
				AlamatColum.setCellValueFactory(new PropertyValueFactory<Mahasiswa, String>("alamat"));

				table.getColumns().addAll(nimColum, nameColum, jurusanColum, AlamatColum);

				table.setItems(getMahasiswa());
				assert table.getItems() == getMahasiswa();

				final VBox vbox = new VBox();
				vbox.setSpacing(5);
				vbox.setPadding(new Insets(0, 0, 0, 0));
				vbox.getChildren().add(table);

				stackPane.getChildren().add(vbox);

				Button btnClose = new Button("Close");
				btnClose.setTranslateX(450);
				btnClose.setTranslateY(410);
				stackPane.getChildren().add(btnClose);

				btnClose.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						// TODO Auto-generated method stub
						secondStage.close();

					}
				});

				Button btnDelete = new Button("delete");
				btnDelete.setTranslateX(390);
				btnDelete.setTranslateY(410);
				stackPane.getChildren().add(btnDelete);

				btnDelete.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						// TODO Auto-generated method stub
						System.out.println(table.getSelectionModel().getSelectedItem().getNim());
						processed.remove(table.getSelectionModel().getSelectedItem().getNim());
						table.getItems().clear();
						table.setItems(getMahasiswa());
						// assert table.getItems() == getMahasiswa();
					}
				});

				Button btnEdit = new Button("Edit");
				btnEdit.setTranslateX(343);
				btnEdit.setTranslateY(410);
				stackPane.getChildren().add(btnEdit);

				btnEdit.setOnAction(new EventHandler<ActionEvent>() {
							
					@Override
					public void handle(ActionEvent event) {
						// TODO Auto-generated method stub
						
						System.out.println(processed.get(table.getSelectionModel().getSelectedItem().getNim()));
						Mahasiswa data = processed.get(table.getSelectionModel().getSelectedItem().getNim());
						
						Stage thithStage = new Stage();
						thithStage.setTitle("Edit Form");

						GridPane gridEdit = new GridPane();
						gridEdit.setAlignment(Pos.CENTER);
						gridEdit.setHgap(10);
						gridEdit.setVgap(10);
						gridEdit.setPadding(new Insets(25, 25, 25, 25));

						Scene sceneEdit = new Scene(gridEdit, 320, 450);
						thithStage.setScene(sceneEdit);

						Text scenetitleEdit = new Text("Form Biodata");
						scenetitleEdit.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
						gridEdit.add(scenetitleEdit, 0, 0, 2, 1);

						Label userNimEdit = new Label("Nim:");
						gridEdit.add(userNimEdit, 0, 1);

						TextField userTextFieldNimEdit = new TextField();
						gridEdit.add(userTextFieldNimEdit, 1, 1);
						userTextFieldNimEdit.setText(data.getNim());

						Label userNameEdit = new Label("Nama:");
						gridEdit.add(userNameEdit, 0, 2);

						TextField userTextFieldNamaEdit = new TextField();
						gridEdit.add(userTextFieldNamaEdit, 1, 2);
						userTextFieldNamaEdit.setText(data.getNama());

						Label userFakultasEdit = new Label("Fakultas:");
						gridEdit.add(userFakultasEdit, 0, 3);

						TextField userTextFieldFakultasEdit = new TextField();
						gridEdit.add(userTextFieldFakultasEdit, 1, 3);
						userTextFieldFakultasEdit.setText(data.getFakultas());

						Label userJurusanEdit = new Label("Jurusan:");
						gridEdit.add(userJurusanEdit, 0, 4);

						TextField userTextFieldJurusanEdit = new TextField();
						gridEdit.add(userTextFieldJurusanEdit, 1, 4);
						userTextFieldJurusanEdit.setText(data.getJurusan());

						Label userAlamatEdit = new Label("Alamat:");
						gridEdit.add(userAlamatEdit, 0, 5);

						TextField userTextFieldAlamatEdit = new TextField();
						gridEdit.add(userTextFieldAlamatEdit, 1, 5);
						userTextFieldAlamatEdit.setText(data.getAlamat());

						Label userKotaEdit = new Label("Kota:");
						gridEdit.add(userKotaEdit, 0, 6);

						TextField userTextFieldKotaEdit = new TextField();
						gridEdit.add(userTextFieldKotaEdit, 1, 6);
						userTextFieldKotaEdit.setText(data.getKota());

						Label userKodePosEdit = new Label("Kode pos:");
						gridEdit.add(userKodePosEdit, 0, 7);

						TextField userTextFieldKodePosEdit = new TextField();
						gridEdit.add(userTextFieldKodePosEdit, 1, 7);
						userTextFieldKodePosEdit.setText(data.getKodePos());

						Label userHobbyEdit = new Label("Hobby:");
						gridEdit.add(userHobbyEdit, 0, 8);

						TextField userTextFieldHobbyEdit = new TextField();
						gridEdit.add(userTextFieldHobbyEdit, 1, 8);
						userTextFieldHobbyEdit.setText(data.getHobby());

						Button btnSaveEdit = new Button("Update");
						HBox HbBtnSaveEdit = new HBox(10);
						HbBtnSaveEdit.setAlignment(Pos.BOTTOM_LEFT);
						HbBtnSaveEdit.getChildren().add(btnSaveEdit);
						gridEdit.add(btnSaveEdit, 1, 9);

						btnSaveEdit.setOnAction(new EventHandler<ActionEvent>() {

							@Override
							public void handle(ActionEvent event) {
								// TODO Auto-generated method stub
								
								processed.update(data.getNim(), new Mahasiswa(userTextFieldNimEdit.getText(), userTextFieldNamaEdit.getText(),
										userTextFieldJurusanEdit.getText(), userTextFieldJurusanEdit.getText(),
										userTextFieldAlamatEdit.getText(), userTextFieldKotaEdit.getText(), userTextFieldKodePosEdit.getText(),
										userTextFieldHobbyEdit.getText()));
								
								table.getItems().clear();
								table.setItems(getMahasiswa());
								thithStage.close();

							}
						});

						thithStage.show();
					}
				});

				secondStage.show();
			}
		});

		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

	public ObservableList<Mahasiswa> getMahasiswa() {
		ObservableList<Mahasiswa> mahasiswa = FXCollections.observableArrayList(processed.getAll());
		return mahasiswa;
	}
}