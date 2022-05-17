//Adam Fariello 
//EDISON FLORES

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class songAddController {
	@FXML private TextField TextFieldSong;
	@FXML private TextField TextFieldAlbum;
	@FXML private TextField TextFieldArtist;
	@FXML private TextField TextFieldEdit;
	private String fileName;
	
	@FXML public void buttonAddSong (ActionEvent event) throws Exception {
		//TODO tie file creator
		if (TextFieldSong.getText().isEmpty() == false && 
			TextFieldArtist.getText().isEmpty() == false &&
		    TextFieldSong.getText() != TextFieldArtist.getText()) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmation");
			alert.setHeaderText("Are you sure you want to create this song?");
			alert.setContentText("This is permant");
			
			Optional<ButtonType> result = alert.showAndWait();
			if (result.isPresent() == true && result.get() == ButtonType.OK) {
				FileOutputStream fos = new FileOutputStream(fileName, true);
				String string = TextFieldSong  .getText() + "\r,"
							  + TextFieldAlbum .getText() + "\r,"
							  + TextFieldArtist.getText() + "\r,"
							  + TextFieldEdit  .getText() + "\r\n";
			    fos.write(string.getBytes());
			    fos.close();
			}
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error: Incomplete Data");
			alert.setHeaderText("Error: Not enough imformation to create a song");
			alert.setContentText("To edit a song you need: Song Name, and Artist Name");
			alert.show();
		}
	}
	
	@FXML public void buttonClose (ActionEvent event) throws Exception{
		/*
		Parent root = FXMLLoader.load(getClass().getResource("songDisplay.fxml"));
	    Scene scene = new Scene(root);
	    Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	    stage.setScene(scene);
	    stage.setResizable(false);
	    stage.show();
	    */
		
		FXMLLoader FXMLLoader = new FXMLLoader(getClass().getResource("songDisplay.fxml"));
		Parent root = FXMLLoader.load();
		songDisplayController songDisplayController = FXMLLoader.getController();
		songDisplayController.loadList();
		
		Scene scene = new Scene(root);
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.setResizable(false);
		
		stage.show();
	}
	@FXML public void buttonClearFields (ActionEvent event) {
		TextFieldSong.setText("");
		TextFieldAlbum.setText("");
		TextFieldArtist.setText("");
		TextFieldEdit.setText("");
	}
	
	public void setSelectedSong(String fileName) {
		this.fileName = fileName;
	}
}
