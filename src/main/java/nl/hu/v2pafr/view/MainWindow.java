package nl.hu.v2pafr.view;

import java.util.Optional;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class MainWindow extends Application{
	
	@Override
	public void start(Stage stage) throws Exception {
		Parent root;
		
		try {
			root = FXMLLoader.load(getClass().getClassLoader().getResource("mainMenu.fxml"));
		} catch(Exception e) {
			e.printStackTrace();
			return;
		}
		
		stage.setResizable(false);
		stage.setTitle("Vertaler");
		stage.setScene(new Scene(root));
		
		stage.sizeToScene();
		stage.show();
		
		stage.setOnCloseRequest(event -> {
			Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
			alert.setTitle("Warning");
			alert.setContentText("Are you sure you want to exit this application?");
			
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.CANCEL) {
				event.consume();
			}
		});
	}
	
	public void openWindow(String args[]) {
		launch(args);
	}

}
