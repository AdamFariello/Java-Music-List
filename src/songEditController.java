import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class songEditController {
	@FXML private TextField TextFieldSong;
	@FXML private TextField TextFieldAlbum;
	@FXML private TextField TextFieldArtist;
	@FXML private TextField TextFieldEdit;
	private String fileName;
	
	public void setSelectedSong (ArrayList<String> songSelected, String fileName){
		TextFieldSong  .setText(songSelected.get(0));
		TextFieldAlbum .setText(songSelected.get(1));
		TextFieldArtist.setText(songSelected.get(2));
		TextFieldEdit  .setText(songSelected.get(3));
		
		this.fileName = fileName;
	}
	
	@FXML public void buttonUpdateSong(ActionEvent event) throws IOException {
		if (TextFieldSong.getText() != "" && TextFieldArtist.getText() != "" 
		    && TextFieldSong.getText() != TextFieldArtist.getText()) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmation");
			alert.setHeaderText("Are you sure you want to edit this song?");
			alert.setContentText("This is permant");
			
			Optional<ButtonType> result = alert.showAndWait();
			if (result.isPresent() == true && result.get() == ButtonType.OK) {
				//TODO add method to manipulate file
			}
		}
		else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error: Incomplete Data");
			alert.setHeaderText("Error: Incomplete data to edit song with");
			alert.setContentText("To edit a song you need: Song Name, and Artist Name");
			alert.show();
		}
	}
	
	@FXML public void buttonClose(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("songDisplay.fxml"));
	    Scene scene = new Scene(root);
	    Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	    stage.setScene(scene);
	    stage.setResizable(false);
	    stage.show();
	}	 
	@FXML public void buttonClearFields (ActionEvent event) {
		TextFieldSong  .setText("");
		TextFieldAlbum .setText("");
		TextFieldArtist.setText("");
		TextFieldEdit  .setText("");
	}
}