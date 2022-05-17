package oldCode;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.print.DocFlavor.URL;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class songDisplayControllerOLd {	
	@FXML private ListView<String> ListView;
	@FXML private TextField textFieldSong;
	@FXML private TextField textFieldArtist;
	@FXML private TextField textFieldAlbum;
	@FXML private TextField textFieldYear;
	
	public void buttonAdd(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("songEdit.fxml"));
		Scene scene = new Scene(root);
		
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
	}
	
	public void loadList() {
		//Creating List
		ArrayList<ArrayList <String>> Songs = new ArrayList<ArrayList <String>>();
		for (int i = 0; i < 5; i++) {
			Songs.add(new ArrayList<String>());
			Songs.get(i).add("SONG " +i);
			Songs.get(i).add("ARTIST" +i);
			Songs.get(i).add("ALBUM" +i);
			Songs.get(i).add("YEAR" +i);
			
		}
		
		//Sort List
		//TODO
		
		//Creating List from Entries
		List<String> temp = new ArrayList();
		for (int i = 0; i < Songs.size(); i++)
			temp.add(Songs.get(i).get(0));
		String asdf = "dsassdf";
		
		//Adding to List View
		ListView.getItems().addAll(FXCollections.observableList(temp));
		ListView.setOnMouseClicked(e -> {
			for (int i = 0; i < Songs.size(); i++) {
				if (Songs.get(i).get(0) == ListView.getSelectionModel().getSelectedItem()) {
					textFieldSong.setText(Songs.get(i).get(0));
					textFieldArtist.setText(Songs.get(i).get(1));
					textFieldAlbum.setText(Songs.get(i).get(2));
					textFieldYear.setText(Songs.get(i).get(3));
					
					System.out.println("List: " +);
				}
			}
	    });
		
		if (ListView.getItems().get(0) != null) {
			textFieldSong.setText(Songs.get(i).get(0));
			textFieldArtist.setText(Songs.get(i).get(1));
			textFieldAlbum.setText(Songs.get(i).get(2));
			textFieldYear.setText(Songs.get(i).get(3));
		}
		//Setting up ListView General
		
		
		
	}
	
	public void initialize() {
		loadList();
	}	
}
//DEBUG
//System.out.println("clicked on " + ListView.getSelectionModel().getSelectedItem());