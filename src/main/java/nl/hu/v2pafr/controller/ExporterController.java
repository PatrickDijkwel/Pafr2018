package nl.hu.v2pafr.controller;

import java.io.File;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import nl.hu.v2pafr.service.ExporterService;

public class ExporterController implements Initializable{

    @FXML private Button exportButton;
    @FXML private Button cancelButton;
    @FXML private ComboBox<String> cbExportType;
    @FXML private VBox exporterContainer;
    
    Stage windowStage;
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {	
		cbExportType.setItems(FXCollections.observableArrayList(ExporterService.getExportTypes()));
	}
    
    @FXML 
    void onClickExport(ActionEvent event) {
    	if(cbExportType.getSelectionModel().getSelectedItem() == null) {
    		return;
    	}
    	
    	File file = this.askForFileLocation(new FileChooser.ExtensionFilter(cbExportType.getSelectionModel().getSelectedItem(), "*"));
    }

    @FXML
    void onClickCancel(ActionEvent event) {
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle("Warning");
		alert.setContentText("Are you sure you want to exit this application?");
		
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.CANCEL) {
			event.consume();
		}
		else if (result.get() == ButtonType.OK) {
			this.
		}
    }
    
    private File askForFileLocation(FileChooser.ExtensionFilter... elements) {
    	FileChooser fileChooser = new FileChooser();
    	fileChooser.getExtensionFilters().addAll(elements);
    	return fileChooser.showSaveDialog(windowStage);
    }

}