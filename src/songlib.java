import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class songlib extends Application {
	final int width  = 800;
	final int height = 600;
	private static String fileName;
	
	public void start(Stage stage) throws Exception {
		FXMLLoader FXMLLoader = new FXMLLoader(getClass().getResource("songDisplay.fxml"));
		Parent root = FXMLLoader.load();
		songDisplayController songDisplayController = FXMLLoader.getController();
		songDisplayController.fileSetUp(fileName);
		
		Scene scene = new Scene(root, width, height);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}
	
	public static void main(String[] args) {
		fileName = System.getProperty("user.dir") + "/" + args[0];
		launch(args);
	}
}