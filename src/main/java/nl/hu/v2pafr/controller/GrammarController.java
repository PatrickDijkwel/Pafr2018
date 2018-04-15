package nl.hu.v2pafr.controller;

import java.io.File;
import java.io.IOException;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import nl.hu.v2pafr.application.Main;
import nl.hu.v2pafr.service.GrammarService;
import nl.hu.v2pafr.view.MainWindow;

public class GrammarController implements Initializable{

    @FXML private TextField tfDutch;
    @FXML private TextField tfEnglish;
    @FXML private TextField tfGerman;
    @FXML private Label lblError;
    @FXML private ComboBox<String> cbWordType;
    @FXML private Button addButton;
    @FXML private VBox grammarContainer;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cbWordType.setItems(FXCollections.observableArrayList(GrammarService.getWordTypes()));
	}
	
    @FXML
    private void onClickAdd(ActionEvent event) throws IOException {
    	
    	//Showing errors in the GUI
    	if(tfDutch.getText().isEmpty() | tfEnglish.getText().isEmpty() | tfGerman.getText().isEmpty()) {
    		lblError.setText("Please fill in all fields!");
    		return;
    	} 
    	else {
    		if(cbWordType.getSelectionModel().getSelectedItem() == null) {
    			lblError.setText("Please select a word type!");
    			return;
    		}
    	}
    	
    	//Here the english and german translations are only added if the dutch word was added correctly to the grammar
    	if(GrammarService.writeGrammarForDutch(cbWordType.getSelectionModel().getSelectedItem(), tfDutch.getText())) {
			GrammarService.writeGrammarForLanguage("English", tfEnglish.getText(), tfDutch.getText());
			GrammarService.writeGrammarForLanguage("German", tfGerman.getText(), tfDutch.getText());
			
			//The program needs to restart to recognize the new grammar as valid syntax for the translator
			Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
			alert.setTitle("Info");
			alert.setContentText("The grammar was added to the program!\n\nFor the changes to take effect you need to restart the program.");
			alert.show();
		}
    }

}
