package oldCode;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import javax.print.DocFlavor.URL;

import songEditController;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class songDisplayController2 {	
	@FXML private ListView<String> ListView;
	@FXML private TextField textFieldSong;
	@FXML private TextField textFieldArtist;
	@FXML private TextField textFieldAlbum;
	@FXML private TextField textFieldYear;
	private ArrayList<ArrayList <String>> Songs;
		
	/*Buttons*/
	@FXML public void buttonAdd(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("songAdd.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}
	@FXML public void buttonEdit (ActionEvent event) throws IOException {
		if (ListView.getSelectionModel().getSelectedItem() != null) {			
			FXMLLoader FXMLLoader = new FXMLLoader(getClass().getResource("songEdit.fxml"));
			Parent root = FXMLLoader.load();
			songEditController songEditController = FXMLLoader.getController();
			songEditController.setSelectedSong(
					getSongList(ListView.getSelectionModel().getSelectedItem())
			);
			
			Scene scene = new Scene(root);
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			stage.setScene(scene);
			stage.setResizable(false);
			stage.show();
			
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error: No song selected");
			alert.setHeaderText("Error: No song selected to edit");
			alert.setContentText("Select a song if you wish to edit it");
			alert.show();
		}
	}
	@FXML public void buttonDelete (ActionEvent event) throws IOException {
		if (ListView.getSelectionModel().getSelectedItem() != null) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmation");
			alert.setHeaderText("Are you sure you want to delete: " 
				 +ListView.getSelectionModel().getSelectedItem() + "?");
			alert.setContentText("This is permant");
			
			Optional<ButtonType> result = alert.showAndWait();
			if (result.isPresent() == true && result.get() == ButtonType.OK) {
				//TODO Method is incomplete, fix removeSong
				removeSong(ListView.getSelectionModel().getSelectedItem());
				loadList();
			}
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error: No song selected");
			alert.setHeaderText("Error: No song selected to delete");
			alert.setContentText("Select a song if you wish to delete");
			alert.show();
		}		
	}
			
	public ArrayList<ArrayList<String>> loadSong () throws FileNotFoundException {
		/* TODO get this working*/
		File songlist =  new File("src/Songs.txt");
		Songs = new ArrayList<ArrayList<String>>();
		
	    if(songlist.exists() && !songlist.isDirectory()) {
	        Scanner in = new Scanner(songlist);   
	        while(in.hasNextLine()) {
	        	String input = in.nextLine();
		        String[] arr = input.split(",");
		        
	        	ArrayList<String> Song = new ArrayList<String>();
	            Song.add(arr[0]);
	            Song.add(arr[1]);
	            Song.add(arr[2]);
	            Song.add(arr[3]);
	            
	            Songs.add(Song);
	        }
	        in.close();
	    }
	    
	    return Songs;
	}
	
	public ArrayList<String> getSongList(String s) {
		for (int i = 0; i < Songs.size(); i++) 
			if (Songs.get(i).get(0) == s)
				return Songs.get(i);
		return null;
	}
	public boolean removeSong(String s) {
		//TODO fill with song deletion
		
		//true  := remove song successful
		//false := remove song failure
		
		return false;
	}
	public void loadList() {
		//TODO replace with actual file reading
		Songs = new ArrayList<ArrayList <String>>();
		for (int i = 0; i < 3; i++) {
			Songs.add(new ArrayList<String>());
			Songs.get(i).add("Song: " +i);
			Songs.get(i).add("ARTIST" +i);
			Songs.get(i).add("ALBUM" +i);
			Songs.get(i).add("YEAR" +i);
			
		}
		
		//Creating List from Entries
		List<String> temp = new ArrayList();
		for (int i = 0; i < Songs.size(); i++)
			temp.add(Songs.get(i).get(0));
		temp.sort(String.CASE_INSENSITIVE_ORDER);
		
		//Adding to List View
		ListView.getItems().addAll(FXCollections.observableList(temp));
		ListView.setOnMouseClicked(e -> {
			ArrayList<String> songsSelected = getSongList(ListView.getSelectionModel().getSelectedItem());				
			if (songsSelected != null) {			
				textFieldSong.setText(songsSelected.get(0));
				textFieldArtist.setText(songsSelected.get(1));
				textFieldAlbum.setText(songsSelected.get(2));
				textFieldYear.setText(songsSelected.get(3));
			}
	    });
		
		if (ListView.getItems().get(0) != null) {
			ArrayList<String> songsSelected = getSongList(Songs.get(0).get(0));	
			textFieldSong.setText(songsSelected.get(0));
			textFieldArtist.setText(songsSelected.get(1));
			textFieldAlbum.setText(songsSelected.get(2));
			textFieldYear.setText(songsSelected.get(3));
		}
		else {
			textFieldSong.setText("<Song>");
			textFieldArtist.setText("<Artist>");
			textFieldAlbum.setText("<Album>");
			textFieldYear.setText("<Year>");
		}		
	}
	
	public void initialize() {
		loadList();
	}	
}
//DEBUG
//System.out.println("clicked on " + ListView.getSelectionModel().getSelectedItem());